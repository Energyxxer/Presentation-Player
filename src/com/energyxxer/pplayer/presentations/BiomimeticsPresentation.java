package com.energyxxer.pplayer.presentations;

import com.energyxxer.pplayer.presentationutil.ObjectState;
import com.energyxxer.pplayer.presentationutil.ObjectTransition;
import com.energyxxer.pplayer.presentationutil.Presentation;
import com.energyxxer.pplayer.presentationutil.PresentationObject;
import com.energyxxer.pplayer.presentationutil.enums.Easing;
import com.energyxxer.pplayer.presentationutil.enums.ObjectType;
import com.energyxxer.pplayer.presentationutil.enums.TextAlignment;
import com.energyxxer.pplayer.util.ImageManager;
import com.energyxxer.pplayer.util.Vector2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

/**
 * Created by User on 2/20/2017.
 */
public class BiomimeticsPresentation extends Presentation {
    {
        this.dimensions = new Dimension(1280,720);
        this.breakpoints.add(50);
        this.breakpoints.add(125);
        this.breakpoints.add(200);
        this.breakpoints.add(275);
        this.breakpoints.add(350);
        this.breakpoints.add(425);
        this.breakpoints.add(525);

        {
            //Bg
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,0,1000,new Point(0,0),new Dimension(1280,720));
            obj.value = ImageManager.load("/assets/biomimetics/bg.png");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(990, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(1000,Easing.EASE_IN_OUT,state1));
            objects.add(obj);
        }
        {
            //Text Background
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE, 0, 150, new Point(0, 300), new Dimension(1280, 100));
            obj.color = new Color(0,0,0);
            obj.opacity = 0.5f;

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-150));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state1));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.opacity = 0;
            obj.transitions.add(new ObjectTransition(100, Easing.EASE_IN_OUT, state2));

            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,0,150,new Point(0,312),new Dimension(560,100));
            obj.value = "Biomimetics";
            obj.color = new Color(237, 237, 237);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-150));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state1));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(-360, 0));
            state2.opacity = 0;
            obj.transitions.add(new ObjectTransition(100, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Concept
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,25,75,new Point(100,312),new Dimension(720,500));
            obj.value = "Biomimetics, also known as biomimicry, refers to the imitation of models, systems and elements of nature to solve complex human problems.";
            obj.color = new Color(237, 237, 237);
            obj.font = new Font("Tahoma", Font.PLAIN, 28);

            obj.opacity = 0;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 1;
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, obj.getDefaultState()));
            objects.add(obj);
        }

        {
            //Velcro
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,100,175,new Point(128,72),new Dimension(1024,576));
            obj.value = ImageManager.load("/assets/biomimetics/velcro.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75,Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Bur
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,175,250,new Point(128,72),new Dimension(1024,576));
            obj.value = ImageManager.load("/assets/biomimetics/bur.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75,Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Morpho
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,250,325,new Point(128,72),new Dimension(1024,576));
            obj.value = ImageManager.load("/assets/biomimetics/morpho.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75,Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Structural Coloration
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,325,400,new Point(128,72),new Dimension(1024,576));
            obj.value = ImageManager.load("/assets/biomimetics/structural_coloration.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75,Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Biomineralization
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,400,475,new Point(128,72),new Dimension(1024,576));
            obj.value = ImageManager.load("/assets/biomimetics/biomineralization.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75,Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Fade out
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE,500,550,new Point(0,0),new Dimension(1280,720));
            obj.color = Color.BLACK;

            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.opacity = 0;
            objects.add(obj);
        }
    }
}
