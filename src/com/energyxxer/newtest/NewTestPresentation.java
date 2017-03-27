package com.energyxxer.newtest;

import com.energyxxer.npplayer.Presentation;
import com.energyxxer.npplayer.objects.ImageObject;
import com.energyxxer.npplayer.objects.RectangleObject;
import com.energyxxer.npplayer.objects.TextObject;
import com.energyxxer.npplayer.objects.VisualObject;
import com.energyxxer.npplayer.objects.effect.EffectObject;
import com.energyxxer.npplayer.state.Rotation;
import com.energyxxer.npplayer.state.Vector2D;
import com.energyxxer.npplayer.state.VisualState;
import com.energyxxer.npplayer.transitions.Easing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

/**
 * Created by User on 3/26/2017.
 */
public class NewTestPresentation extends Presentation {
    {
        this.dimensions = new Dimension(1280,720);
        this.breakpoints.add(50);
        this.breakpoints.add(75);

        {
            VisualObject obj = new RectangleObject(0, 1000, new Point(0,0), new Dimension(1280, 720));
            obj.setColor(new Color(50,50,50));

            VisualState state1 = obj.cloneDefaultState();
            state1.setColor(Color.BLACK);

            VisualState state2 = obj.cloneDefaultState();
            state2.translate(new Vector2D(0,-720));
            state2.setColor(Color.BLACK);
            obj.putTransition(50, state1);
            obj.putTransition(75, state2, Easing.EASE_IN_OUT);
            objects.add(obj);
        }
        {
            VisualObject obj = new RectangleObject(0, 100, new Point(100, 300), new Dimension(100, 100), Color.GREEN);

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(588, 175));
            state1.setRotation(new Rotation(340));
            obj.putTransition(25, state1);

            VisualState state2 = obj.cloneDefaultState();
            state2.setPosition(new Point(1175, 275));
            state2.setColor(Color.WHITE);
            state2.setRotation(new Rotation(700));
            obj.putTransition(50, state2);

            VisualState state3 = state2.clone();
            state3.translate(new Vector2D(0,-720));
            obj.putTransition(75, state3);
            //objects.add(obj);
        }
        {
            VisualObject obj = new TextObject(0, 100, new Point(100, 300), new Dimension(100, 100), "HI", new Font("Tahoma", Font.BOLD, 50), Color.GREEN);

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(588, 175));
            state1.setRotation(new Rotation(340));
            obj.putTransition(25, state1);

            VisualState state2 = obj.cloneDefaultState();
            state2.setPosition(new Point(1175, 275));
            state2.setColor(Color.WHITE);
            state2.setRotation(new Rotation(700));
            obj.putTransition(50, state2);

            VisualState state3 = state2.clone();
            state3.translate(new Vector2D(0,-720));
            obj.putTransition(75, state3);
            objects.add(obj);
        }
        {
            VisualObject obj = new ImageObject(0, 100, new Point(100, 300), new Dimension(100, 100), "/assets/mendiants/mendiants0.png");

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(588, 175));
            state1.setRotation(new Rotation(340));
            state1.setOpacity(0);
            obj.putTransition(25, state1);

            VisualState state2 = obj.cloneDefaultState();
            state2.setPosition(new Point(1175, 275));
            state2.setRotation(new Rotation(700));
            obj.putTransition(50, state2);

            VisualState state3 = state2.clone();
            state3.translate(new Vector2D(0,-720));
            obj.putTransition(75, state3);
            objects.add(obj);
        }
        objects.add(new EffectObject(0, 1000));
    }
}
