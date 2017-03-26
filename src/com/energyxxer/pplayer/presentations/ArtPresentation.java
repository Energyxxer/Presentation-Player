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
 * Created by User on 2/1/2017.
 */
public class ArtPresentation extends Presentation {
    {
        this.dimensions = new Dimension(1280,720);
        this.breakpoints.add(50);
        this.breakpoints.add(75);
        this.breakpoints.add(100);
        this.breakpoints.add(125);
        this.breakpoints.add(150);
        this.breakpoints.add(175);
        this.breakpoints.add(200);
        this.breakpoints.add(225);

        {
            //Bg
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE,0,1000,new Point(0,0),new Dimension(1280,720));
            obj.color = Color.BLACK;
            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(990, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(1000,Easing.EASE_IN_OUT,state1));
            objects.add(obj);
        }
        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,0,100,new Point(0,0),new Dimension(720,720));
            obj.value = ImageManager.load("/assets/Oswaldo Guayasamin.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,0,100,new Point(720,300),new Dimension(560,100));
            obj.value = "Oswaldo\nGuayasamín";
            obj.color = Color.WHITE;
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,25,75,new Point(0,-720),new Dimension(1280,620));
            obj.value = ImageManager.load("/assets/Huacaynan.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,25,75,new Point(0,-100),new Dimension(1280,100));
            obj.value = "Huacayñán";
            obj.color = new Color(200,200,200);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,50,100,new Point(0,-720),new Dimension(1280,620));
            obj.value = ImageManager.load("/assets/La Edad de Ira.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,50,100,new Point(0,-100),new Dimension(1280,100));
            obj.value = "La Edad de Ira";
            obj.color = new Color(200,200,200);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,75,125,new Point(0,-720),new Dimension(1280,620));
            obj.value = ImageManager.load("/assets/Mientras viva siempre te recuerdo.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(-1280,0));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,75,125,new Point(0,-100),new Dimension(1280,100));
            obj.value = "Mientras viva siempre te recuerdo";
            obj.color = new Color(200,200,200);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(-1280,0));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,100,150,new Point(1280,0),new Dimension(720,720));
            obj.value = ImageManager.load("/assets/Teodoro Nunez Ureta.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(-1280,0));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,100,150,new Point(2000,300),new Dimension(560,100));
            obj.value = "Teodoro\nNúñez\nUreta";
            obj.color = Color.WHITE;
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(-1280,0));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,125,175,new Point(0,720),new Dimension(1280,620));
            obj.value = ImageManager.load("/assets/La Educacion del Peru.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,125,175,new Point(0,1340),new Dimension(1280,100));
            obj.value = "La Educación del Perú";
            obj.color = new Color(200,200,200);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,150,200,new Point(0,720),new Dimension(1280,620));
            obj.value = ImageManager.load("/assets/La Patria.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,150,200,new Point(0,1340),new Dimension(1280,100));
            obj.value = "La Patria";
            obj.color = new Color(200,200,200);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }

        {
            //Image
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,175,225,new Point(0,720),new Dimension(1280,620));
            obj.value = ImageManager.load("/assets/La ciudad de Arequipa.jpg");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            state2.opacity = 0f;
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
        {
            //Label
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,175,225,new Point(0,1340),new Dimension(1280,100));
            obj.value = "La ciudad de Arequipa";
            obj.color = new Color(200,200,200);
            obj.textAlignment = TextAlignment.CENTER;
            obj.font = new Font("Tahoma", Font.BOLD, 63);

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.translate(new Vector2D(0,-720));
            state2.opacity = 0f;
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state2));
            objects.add(obj);
        }
    }
}
