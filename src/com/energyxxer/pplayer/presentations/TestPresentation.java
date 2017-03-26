package com.energyxxer.pplayer.presentations;

import com.energyxxer.pplayer.presentationutil.ObjectState;
import com.energyxxer.pplayer.presentationutil.ObjectTransition;
import com.energyxxer.pplayer.presentationutil.Presentation;
import com.energyxxer.pplayer.presentationutil.PresentationObject;
import com.energyxxer.pplayer.presentationutil.enums.Easing;
import com.energyxxer.pplayer.presentationutil.enums.ObjectType;
import com.energyxxer.pplayer.util.Rotation;
import com.energyxxer.pplayer.util.Vector2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Created by User on 2/1/2017.
 */
public class TestPresentation extends Presentation {
    {
        this.dimensions = new Dimension(1280,720);
        this.breakpoints.add(50);
        this.breakpoints.add(75);

        {
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE,0,1000,new Point(0,0),new Dimension(1280,720));
            obj.color = new Color(50,50,50);
            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75,Easing.EASE_IN_OUT,state1));
            objects.add(obj);
        }
        {
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE,0,100,new Point(100,300),new Dimension(100,100));
            obj.color = Color.GREEN;
            ObjectState state1 = obj.getDefaultState();
            state1.position.x = 588;
            state1.position.y = 175;
            state1.rotation = new Rotation(2500);
            obj.transitions.add(new ObjectTransition(25,Easing.LINEAR,state1));
            ObjectState state2 = obj.getDefaultState();
            state2.position.x = 1175;
            state2.position.y = 275;
            state2.color = Color.WHITE;
            state2.rotation = new Rotation(5000);
            obj.transitions.add(new ObjectTransition(50,Easing.LINEAR,state2));
            ObjectState state3 = new ObjectState(state2);
            state3.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(75,Easing.LINEAR,state3));
            objects.add(obj);
        }
    }
}
