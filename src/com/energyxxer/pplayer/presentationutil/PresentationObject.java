package com.energyxxer.pplayer.presentationutil;

import com.energyxxer.pplayer.presentationutil.enums.ObjectType;
import com.energyxxer.pplayer.presentationutil.enums.TextAlignment;
import com.energyxxer.pplayer.util.Rotation;
import com.energyxxer.pplayer.util.Vector2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

import static com.energyxxer.pplayer.presentationutil.enums.Easing.EASE_IN_OUT;
import static com.energyxxer.pplayer.presentationutil.enums.Easing.LINEAR;

/**
 * Created by User on 2/1/2017.
 */
public class PresentationObject {

    public int startKeyframe,
                endKeyframe;
    public ObjectType type;
    public Object value;
    public Font font;
    public TextAlignment textAlignment;
    public Color color;

    public Point position;
    public Dimension size;
    public Rotation rotation;

    public float opacity;

    public ArrayList<ObjectTransition> transitions = new ArrayList<>();

    public PresentationObject(ObjectType type, int start, int end, Point pos, Dimension size) {
        this.startKeyframe = start;
        this.endKeyframe = end;

        this.type = type;

        this.value = null;
        this.font = new Font("Tahoma",0,12);
        this.textAlignment = TextAlignment.LEFT;
        this.color = Color.BLACK;

        this.position = pos;
        this.size = size;
        this.rotation = new Rotation(0);
        this.opacity = 1f;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public ObjectState getDefaultState() {
        ObjectState s = new ObjectState();
        s.position = new Point(this.position.x,this.position.y);
        s.size = new Dimension(this.size.width,this.size.height);
        s.rotation = new Rotation(this.rotation.angle,this.rotation.origin);
        s.opacity = this.opacity;

        s.value = this.value;
        s.font = this.font;
        s.color = this.color;
        return s;
    }

    public void translate(Vector2D vec) {
        this.position.x += vec.x;
        this.position.y += vec.y;
    }

    public ObjectState interpolateStates(int frame) {

        ObjectTransition currentTransition = new ObjectTransition(0, LINEAR, this.getDefaultState());
        ObjectTransition nextTransition = null;

        for(ObjectTransition transition : transitions) {
            if(transition.keyframe <= frame - this.startKeyframe) {
                if(currentTransition.keyframe < transition.keyframe) {
                    currentTransition = transition;
                }
            } else {
                if(nextTransition == null || nextTransition.keyframe > transition.keyframe) {
                    nextTransition = transition;
                }
            }
        }
        if(nextTransition == null) {
            return currentTransition.state;
            //nextTransition = new ObjectTransition(endKeyframe-startKeyframe, LINEAR, currentTransition.state);
        }

        ObjectState frameState = this.getDefaultState();

        ObjectState currentState = currentTransition.state;
        ObjectState nextState = nextTransition.state;

        int transitionTime = nextTransition.keyframe-currentTransition.keyframe;
        int time = ((frame - startKeyframe) - currentTransition.keyframe);

        frameState.rotation.locked = nextState.rotation.locked;

        {
            float interpolation = 1;
            if(nextTransition.easing == LINEAR && time != 0) {interpolation = 1-((float)time/transitionTime);}
            if(nextTransition.easing == EASE_IN_OUT) {
                interpolation = (float) Math.cos(Math.PI * ((float)time/transitionTime) / 2);
            }
            {
                Point[] fieldsCurrent = {currentState.position,currentTransition.state.rotation.origin};
                Point[] fieldsNext = {nextState.position,nextTransition.state.rotation.origin};
                Point[] fields = {frameState.position,frameState.rotation.origin};

                for(int i = 0; i < fields.length; i++) {
                    fields[i].x = Math.round(fieldsCurrent[i].x * interpolation + fieldsNext[i].x * (1 - interpolation));
                    fields[i].y = Math.round(fieldsCurrent[i].y * interpolation + fieldsNext[i].y * (1 - interpolation));
                }
            }
            {
                Dimension[] fieldsCurrent = {currentState.size};
                Dimension[] fieldsNext = {nextState.size};
                Dimension[] fields = {frameState.size};

                for(int i = 0; i < fields.length; i++) {
                    fields[i].width = Math.round(fieldsCurrent[i].width * interpolation + fieldsNext[i].width * (1 - interpolation));
                    fields[i].height = Math.round(fieldsCurrent[i].height * interpolation + fieldsNext[i].height * (1 - interpolation));
                }
            }
            if(time != 0) {
                float blending = interpolation;
                float inverse_blending = 1 - blending;
                int red = (int) (currentState.color.getRed()   * blending   +   nextState.color.getRed()   * inverse_blending);
                int green = (int) (currentState.color.getGreen() * blending   +   nextState.color.getGreen() * inverse_blending);
                int blue = (int) (currentState.color.getBlue()  * blending   +   nextState.color.getBlue()  * inverse_blending);
                frameState.color = new Color(red,green,blue);
            } else {
                frameState.color = new Color(currentState.color.getRed(),currentState.color.getGreen(),currentState.color.getBlue());
            }

            frameState.opacity = currentState.opacity * interpolation + nextState.opacity* (1 - interpolation);
            frameState.rotation.angle = Math.round(currentState.rotation.angle * interpolation + nextState.rotation.angle* (1 - interpolation));

        }

        return frameState;
    }
}
