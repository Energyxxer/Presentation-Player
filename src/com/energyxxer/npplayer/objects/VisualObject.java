package com.energyxxer.npplayer.objects;

import com.energyxxer.npplayer.state.Rotation;
import com.energyxxer.npplayer.state.VisualState;
import com.energyxxer.npplayer.transitions.Easing;
import com.energyxxer.npplayer.transitions.VisualTransition;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/26/2017.
 */
public abstract class VisualObject {
    protected final int startKeyframe;
    protected final int endKeyframe;

    protected VisualState defaultState;

    protected ArrayList<VisualTransition> transitions = new ArrayList<>();

    protected VisualObject(int start, int end) {
        this(start, end, new VisualState());
    }

    public VisualObject(int start, int end, VisualState defaultState) {
        this.startKeyframe = start;
        this.endKeyframe = end;
        this.defaultState = defaultState;
    }

    public final void draw(Graphics2D g2d, int keyframe) {
        VisualTransition previousTransition = new VisualTransition(0, defaultState);
        VisualTransition nextTransition = null;
        
        for(VisualTransition t : transitions) {
            int tk = t.getKeyframe();
            if(tk > previousTransition.getKeyframe() && tk + startKeyframe <= keyframe) previousTransition = t;
            if(tk + startKeyframe > keyframe && (nextTransition == null || tk < nextTransition.getKeyframe())) nextTransition = t;
        }
        
        VisualState state = this.interpolateStates(keyframe - startKeyframe, previousTransition, nextTransition);

        Graphics2D g = (Graphics2D) g2d.create();

        if(state.getRotation().locked) {
            g.translate(state.getPosition().x + (state.getSize().width/2),state.getPosition().y + (state.getSize().height/2));
            g.rotate(Math.toRadians(state.getRotation().angle));
            g.translate(-(state.getPosition().x + (state.getSize().width/2)),-(state.getPosition().y + (state.getSize().height/2)));
        } else {
            g.translate(state.getRotation().origin.x,state.getRotation().origin.y);
            g.rotate(Math.toRadians(state.getRotation().angle));
            g.translate(-state.getRotation().origin.x,-state.getRotation().origin.y);
        }

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, state.getOpacity()));

        if(!this.drawObject(g, state)) this.drawObject(g, state, keyframe - startKeyframe, ((nextTransition != null) ? nextTransition.getEasing() : Easing.LINEAR));

        g.dispose();
    }

    protected VisualState interpolateStates(int frame, VisualTransition previousTransition, VisualTransition nextTransition) {
        if(nextTransition == null) {
            return previousTransition.getState();
        }
        VisualState currentState = defaultState.clone();

        VisualState previousState = previousTransition.getState();
        VisualState nextState = nextTransition.getState();

        int transitionTime = nextTransition.getKeyframe() - previousTransition.getKeyframe();
        int time = (frame - previousTransition.getKeyframe());

        previousState.getRotation().locked = nextState.getRotation().locked;

        {
            float interpolation = 1;
            if(nextTransition.getEasing() == Easing.LINEAR && time != 0) {interpolation = 1-((float)time/transitionTime);}
            if(nextTransition.getEasing() == Easing.EASE_IN_OUT) {
                interpolation = (float) Math.cos(Math.PI * ((float)time/transitionTime) / 2);
            }
            {
                Point[] fieldsCurrent = {previousState.getPosition(), previousState.getRotation().origin};
                Point[] fieldsNext = {nextState.getPosition(), nextState.getRotation().origin};
                Point[] fields = {currentState.getPosition(), currentState.getRotation().origin};

                for(int i = 0; i < fields.length; i++) {
                    fields[i].x = Math.round(fieldsCurrent[i].x * interpolation + fieldsNext[i].x * (1 - interpolation));
                    fields[i].y = Math.round(fieldsCurrent[i].y * interpolation + fieldsNext[i].y * (1 - interpolation));
                }
            }
            {
                Dimension[] fieldsCurrent = {previousState.getSize()};
                Dimension[] fieldsNext = {nextState.getSize()};
                Dimension[] fields = {currentState.getSize()};

                for(int i = 0; i < fields.length; i++) {
                    fields[i].width = Math.round(fieldsCurrent[i].width * interpolation + fieldsNext[i].width * (1 - interpolation));
                    fields[i].height = Math.round(fieldsCurrent[i].height * interpolation + fieldsNext[i].height * (1 - interpolation));
                }
            }
            if(time != 0) {
                float inverse_interpolation = 1 - interpolation;
                int red = (int) (previousState.getColor().getRed()   * interpolation   +   nextState.getColor().getRed()   * inverse_interpolation);
                int green = (int) (previousState.getColor().getGreen() * interpolation   +   nextState.getColor().getGreen() * inverse_interpolation);
                int blue = (int) (previousState.getColor().getBlue()  * interpolation   +   nextState.getColor().getBlue()  * inverse_interpolation);
                currentState.setColor(new Color(red, green, blue));
            } else {
                currentState.setColor(new Color(previousState.getColor().getRed(), previousState.getColor().getGreen(), previousState.getColor().getBlue()));
            }

            float opacity = previousState.getOpacity() * interpolation + nextState.getOpacity() * (1 - interpolation);
            opacity = Math.max(opacity, 0);
            opacity = Math.min(opacity, 1);
            currentState.setOpacity(opacity);
            currentState.getRotation().angle = Math.round(previousState.getRotation().angle * interpolation + nextState.getRotation().angle * (1 - interpolation));

        }

        return currentState;
    }

    protected boolean drawObject(Graphics2D g, VisualState s) {
        return false;
    }
    
    protected boolean drawObject(Graphics2D g, VisualState s, int f, Easing e) {
        return false;
    }

    public int getStart() {
        return startKeyframe;
    }

    public int getEnd() {
        return endKeyframe;
    }

    public Point getPosition() {
        return defaultState.getPosition();
    }

    public void setPosition(Point position) {
        defaultState.setPosition(position);
    }

    public Dimension getSize() {
        return defaultState.getSize();
    }

    public void setSize(Dimension size) {
        defaultState.setSize(size);
    }

    public Rotation getRotation() {
        return defaultState.getRotation();
    }

    public void setRotation(Rotation rotation) {
        defaultState.setRotation(rotation);
    }

    public Color getColor() {
        return defaultState.getColor();
    }

    public void setColor(Color color) {
        defaultState.setColor(color);
    }

    public float getOpacity() {
        return defaultState.getOpacity();
    }

    public void setOpacity(float opacity) {
        defaultState.setOpacity(opacity);
    }

    public List<VisualTransition> getTransitions() {
        return transitions;
    }

    public void putTransition(int keyframe, VisualState state) {
        this.putTransition(keyframe, state, Easing.LINEAR);
    }

    public void putTransition(int keyframe, VisualState state, Easing easing) {
        if(keyframe < 0) throw new IllegalArgumentException("Keyframe can't be negative");

        VisualTransition newTransition = new VisualTransition(keyframe, easing, state);
        for(int i = 0; i < transitions.size(); i++) {
            VisualTransition t = transitions.get(i);
            if(t.getKeyframe() == keyframe) {
                transitions.set(i, newTransition);
                return;
            } else if(t.getKeyframe() > keyframe) {
                transitions.add(i, newTransition);
                return;
            }
        }
        transitions.add(newTransition);
    }

    public VisualState cloneDefaultState() {
        return defaultState.clone();
    }
}
