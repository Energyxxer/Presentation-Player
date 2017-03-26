package com.energyxxer.pplayer.presentations;

import com.energyxxer.pplayer.presentationutil.ObjectState;
import com.energyxxer.pplayer.presentationutil.ObjectTransition;
import com.energyxxer.pplayer.presentationutil.Presentation;
import com.energyxxer.pplayer.presentationutil.PresentationObject;
import com.energyxxer.pplayer.presentationutil.enums.Easing;
import com.energyxxer.pplayer.presentationutil.enums.ObjectType;
import com.energyxxer.pplayer.util.ImageManager;
import com.energyxxer.pplayer.util.Vector2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

/**
 * Created by User on 2/20/2017.
 */
public class MendiantsPresentation extends Presentation {
    {
        this.dimensions = new Dimension(1280,720);
        this.breakpoints.add(50);
        this.breakpoints.add(125);
        this.breakpoints.add(200);
        this.breakpoints.add(275);
        this.breakpoints.add(350);
        this.breakpoints.add(425);
        this.breakpoints.add(500);
        this.breakpoints.add(600);

        {
            //Bg
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,0,1000,new Point(0,0),new Dimension(1280,720));
            obj.value = ImageManager.load("/assets/mendiants/bg.png");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-720));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(990, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(1000,Easing.EASE_IN_OUT,state1));
            objects.add(obj);
        }
        {
            //Bg
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,0,150,new Point(0,0),new Dimension(1280,720));
            obj.value = ImageManager.load("/assets/mendiants/title.png");

            ObjectState state1 = obj.getDefaultState();
            state1.translate(new Vector2D(0,-125));
            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, state1));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT, state1));

            ObjectState state2 = new ObjectState(state1);
            state2.opacity = 0;
            obj.transitions.add(new ObjectTransition(100, Easing.EASE_IN_OUT, state2));

            objects.add(obj);
        }

        {
            //Concept
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,25,75,new Point(102,452),new Dimension(1000,500));
            obj.value = "Un                                es una confección tradicional francesa que consiste en un disco de chocolate, adornado de nueces y frutas secas. Estos se producen generalmente en la época de Navidad y, por lo tanto, han incorporado otros ingredientes.\n";
            obj.color = new Color(75, 75, 75);
            obj.font = new Font("Tahoma", Font.PLAIN, 28);

            obj.opacity = 0;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 1;
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, obj.getDefaultState()));
            objects.add(obj);
        }
        {
            //Concept (Italic)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,25,75,new Point(102,452),new Dimension(1000,500));
            obj.value = "     mendiant en chocolat";
            obj.color = new Color(75, 75, 75);
            obj.font = new Font("Tahoma", Font.ITALIC, 28);

            obj.opacity = 0;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 1;
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, obj.getDefaultState()));
            objects.add(obj);
        }

        {
            //Concept
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,25,75,new Point(100,450),new Dimension(1000,500));
            obj.value = "Un                                es una confección tradicional francesa que consiste en un disco de chocolate, adornado de nueces y frutas secas. Estos se producen generalmente en la época de Navidad y, por lo tanto, han incorporado otros ingredientes.\n";
            obj.color = new Color(255, 255, 255);
            obj.font = new Font("Tahoma", Font.PLAIN, 28);

            obj.opacity = 0;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 1;
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, obj.getDefaultState()));
            objects.add(obj);
        }
        {
            //Concept (Italic)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,25,75,new Point(100,450),new Dimension(1000,500));
            obj.value = "     mendiant en chocolat";
            obj.color = new Color(237, 237, 237);
            obj.font = new Font("Tahoma", Font.ITALIC, 28);

            obj.opacity = 0;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 1;
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            obj.transitions.add(new ObjectTransition(50, Easing.EASE_IN_OUT, obj.getDefaultState()));
            objects.add(obj);
        }

        {
            //Ingredients (header)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,100,175,new Point(50,75),new Dimension(500,100));
            obj.value = "Ingredientes";
            obj.color = new Color(237, 237, 237);
            obj.font = new Font("Tahoma", Font.ITALIC, 60);

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Ingredients (background)
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE,100,175,new Point(0,200),new Dimension(1280,350));
            obj.color = Color.BLACK;
            obj.opacity = 0.4f;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Ingredients (text)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,100,175,new Point(100,300),new Dimension(1000,400));
            obj.value = "1. Chocolate\n2. Nueces (almendras, pistachos...)\n3. Frutas desecadas (pasas, arándanos, cerezas...)";
            obj.color = new Color(237, 237, 237);
            obj.font = new Font("Tahoma", Font.PLAIN, 36);

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Recipe (Image)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,175,250,new Point(128,72),new Dimension(1024,576));
            obj.value = ImageManager.load("/assets/mendiants/mendiants2.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Color-changing background
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE, 250, 1000, new Point(0,0), new Dimension(1280, 720));
            obj.color = new Color(50, 50, 50);
            obj.opacity = 0.5f;

            ObjectState state1 = obj.getDefaultState();
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));
            obj.transitions.add(new ObjectTransition(75, Easing.LINEAR, state1));
            ObjectState state2 = obj.getDefaultState();
            state2.color = new Color(68, 49, 30);
            obj.transitions.add(new ObjectTransition(100, Easing.EASE_IN_OUT, state2));
            obj.transitions.add(new ObjectTransition(150, Easing.LINEAR, state2));
            ObjectState state3 = obj.getDefaultState();
            state3.color = new Color(255, 255, 255);
            obj.transitions.add(new ObjectTransition(175, Easing.EASE_IN_OUT, state3));
            obj.transitions.add(new ObjectTransition(225, Easing.LINEAR, state3));
            ObjectState state4 = obj.getDefaultState();
            state4.color = new Color(128, 0, 128);
            obj.transitions.add(new ObjectTransition(250, Easing.EASE_IN_OUT, state4));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Seals (Background)
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE, 250, 1000, new Point(0, 50), new Dimension(1280, 200));
            obj.color = Color.BLACK;
            obj.opacity = 0.4f;

            ObjectState state1 = obj.getDefaultState();
            obj.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.EASE_IN_OUT, state1));

            objects.add(obj);
        }

        {
            //Franciscan Order (Seal)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,250,325,new Point(50,50),new Dimension(200,200));
            obj.value = ImageManager.load("/assets/mendiants/franciscan_order_seal.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Franciscan Order (Title)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,250,325,new Point(275,100),new Dimension(750,200));
            obj.value = "Orden Franciscana";
            obj.font = new Font("Tahoma", Font.ITALIC, 50);
            obj.color = Color.WHITE;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Franciscan Order (Image)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,250,325,new Point(50,300),new Dimension(1230,300));
            obj.value = ImageManager.load("/assets/mendiants/franciscan_order0.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Franciscan Order (Seal)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,325,400,new Point(50,50),new Dimension(200,200));
            obj.value = ImageManager.load("/assets/mendiants/carmelite_order_seal.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Franciscan Order (Title)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,325,400,new Point(275,100),new Dimension(750,200));
            obj.value = "Orden de los Carmelitas";
            obj.font = new Font("Tahoma", Font.ITALIC, 50);
            obj.color = Color.WHITE;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Franciscan Order (Image)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,325,400,new Point(50,300),new Dimension(1230,300));
            obj.value = ImageManager.load("/assets/mendiants/carmelite_order1.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Dominican Order (Seal)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,400,475,new Point(50,50),new Dimension(200,200));
            obj.value = ImageManager.load("/assets/mendiants/dominican_order_seal.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Dominican Order (Title)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,400,475,new Point(275,100),new Dimension(750,200));
            obj.value = "Orden Dominicana / de Predicadores";
            obj.font = new Font("Tahoma", Font.ITALIC, 50);
            obj.color = Color.WHITE;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Dominican Order (Image)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,400,475,new Point(50,300),new Dimension(1230,300));
            obj.value = ImageManager.load("/assets/mendiants/dominican_order0.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Augustinian Order (Seal)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,475,550,new Point(50,50),new Dimension(200,200));
            obj.value = ImageManager.load("/assets/mendiants/augustinian_order_seal.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Augustinian Order (Title)
            PresentationObject obj = new PresentationObject(ObjectType.TEXT,475,550,new Point(275,100),new Dimension(750,200));
            obj.value = "Orden de San Agustín";
            obj.font = new Font("Tahoma", Font.ITALIC, 50);
            obj.color = Color.WHITE;

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }
        {
            //Augustinian Order (Image)
            PresentationObject obj = new PresentationObject(ObjectType.IMAGE,475,550,new Point(50,300),new Dimension(1230,300));
            obj.value = ImageManager.load("/assets/mendiants/augustinian_order0.png");

            ObjectState state1 = obj.getDefaultState();
            state1.opacity = 0;
            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(50, Easing.LINEAR,obj.getDefaultState()));
            obj.transitions.add(new ObjectTransition(75, Easing.EASE_IN_OUT,state1));

            obj.opacity = 0;
            objects.add(obj);
        }

        {
            //Fade out
            PresentationObject obj = new PresentationObject(ObjectType.RECTANGLE,550,625,new Point(0,0),new Dimension(1280,720));
            obj.color = Color.BLACK;

            obj.transitions.add(new ObjectTransition(25, Easing.LINEAR,obj.getDefaultState()));
            obj.opacity = 0;
            objects.add(obj);
        }
    }
}
