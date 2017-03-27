package com.energyxxer.newtest;

import com.energyxxer.npplayer.Presentation;
import com.energyxxer.npplayer.objects.ImageObject;
import com.energyxxer.npplayer.objects.RectangleObject;
import com.energyxxer.npplayer.objects.TextObject;
import com.energyxxer.npplayer.objects.VisualObject;
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
public class BusinessPresentation extends Presentation {
    private static final Color PRIMARY_COLOR = new Color(183, 141, 56);

    //Text snippets:
    private static final String ACTIVITY = "This is a center for children with Down Syndrome. This center aims to provide these children with a better development during their early stages of life.";
    private static final String MARKET = "We believe the state of the market for this service is growing.\n\nThis business will be at an upmarket position (USD 640.00 /mo)\n\nOur target customers will be parents of children with special needs, and our major competitor in the Dominican Republic would be CAID.\n\nOur advertisement methods include trade press, Internet and word of mouth.";
    private static final String PERSONNEL = "Our company will require approximately 14 employees. These include: Marketer, physical therapist, general therapist, psychologist, pediatrician, special education teachers and janitors.";
    private static final String PREMISES = "The company will be located in Santo Domingo, Dominican Republic.\n\nWe will require a leased building, containing an office for the administration.";
    private static final String EQUIPMENT = "As for general trading equipment, a vehicle for transportation of furniture will be needed.\n\nOther equipment for therapy will be needed. Some examples are: hydrotherapy, occupational therapy, physical therapy, among others.";
    private static final String FINANCIAL_PLAN = "To start this business, we will require around USD 100,000.00. This will pay for the employees, equipment, furniture and rent, among other things.\nAfter some time has passed and we are no longer focusing on kicking off the business, we will start needing a larger amount of USD 250,000.00.\n\nFinally, we expect the business to become self-sustainable after the first or second year.";

    {
        this.dimensions = new Dimension(1280, 720);
        this.breakpoints.add(30);
        this.breakpoints.add(60);
        this.breakpoints.add(90);
        this.breakpoints.add(120);
        this.breakpoints.add(150);
        this.breakpoints.add(180);
        this.breakpoints.add(210);

        int panelWidth = 640;
        int margin = 75;
        int margin2 = 100;

        {
            //Background
            for(int i = 0; i < 210; i += 30) {
                VisualObject obj = new ImageObject(i - 15, i + 30, new Point(0, 0), new Dimension(1280, 720), "/assets/business/bg" + (i / 30) + ".png");
                obj.setOpacity(0);

                VisualState state1 = obj.cloneDefaultState();
                state1.setOpacity(1);
                obj.putTransition(15, state1, Easing.EASE_IN_OUT);

                objects.add(obj);
            }
        }

        {
            //Title background shadow
            VisualObject obj = new RectangleObject(0, 10, new Point(0, 197), new Dimension(1280, 326), Color.BLACK);
            obj.setOpacity(0.3f);

            VisualState state1 = obj.cloneDefaultState();
            state1.setOpacity(0);
            obj.putTransition(10, state1, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel shadow
            VisualObject obj = new RectangleObject(0, 200, new Point(1280, 0), new Dimension(panelWidth, 720));
            obj.setOpacity(0.3f);

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280 - (panelWidth + 3), 0));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);
            obj.putTransition(60, state1);

            VisualState state2 = state1.clone();
            state2.setPosition(new Point(0,0));
            state2.setSize(new Dimension(1280, 720));
            obj.putTransition(75, state2, Easing.EASE_IN_OUT);

            VisualState state3 = state2.clone();
            state3.setSize(new Dimension(panelWidth + 3, 720));
            obj.putTransition(90, state3, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Title background
            VisualObject obj = new RectangleObject(0, 15, new Point(0, 200), new Dimension(1280, 320), PRIMARY_COLOR);

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280, 200));
            state1.setSize(new Dimension(0, 320));
            state1.setOpacity(0);
            obj.putTransition(15, state1, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel background
            VisualObject obj = new RectangleObject(0, 200, new Point(1280, 0), new Dimension(panelWidth, 720), PRIMARY_COLOR);

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280 - panelWidth, 0));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);
            obj.putTransition(60, state1);

            VisualState state2 = state1.clone();
            state2.setPosition(new Point(0,0));
            state2.setSize(new Dimension(1280, 720));
            obj.putTransition(75, state2, Easing.EASE_IN_OUT);

            VisualState state3 = state2.clone();
            state3.setSize(new Dimension(panelWidth, 720));
            obj.putTransition(90, state3, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Logo
            VisualObject obj = new ImageObject(0, 10, new Point(0, 200), new Dimension(1280, 320), "/assets/business/logo.png");

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280, 200));
            obj.putTransition(10, state1, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text header
            VisualObject obj = new TextObject(
                    0,
                    100,
                    new Point(1280, 50),
                    new Dimension(panelWidth - 2 * margin, 720),
                    "OBJECTIVE",
                    new Font("Lucida Handwriting", Font.BOLD, 50),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280 - panelWidth + margin, 50));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text
            VisualObject obj = new TextObject(
                    0,
                    100,
                    new Point(1280, 200),
                    new Dimension(panelWidth - 2 * margin2, 720),
                    ACTIVITY,
                    new Font("Source Sans Pro", Font.PLAIN, 40),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280 - panelWidth + margin2, 200));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text header
            VisualObject obj = new TextObject(
                    30,
                    100,
                    new Point(1280, 50),
                    new Dimension(panelWidth - 2 * margin, 720),
                    "MARKET",
                    new Font("Lucida Handwriting", Font.BOLD, 50),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280 - panelWidth + margin, 50));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text
            VisualObject obj = new TextObject(
                    30,
                    100,
                    new Point(1280, 200),
                    new Dimension(panelWidth - 2 * margin2, 720),
                    MARKET,
                    new Font("Source Sans Pro", Font.PLAIN, 28),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(1280 - panelWidth + margin2, 200));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }

        //Personnel
        {
            //Panel text header
            VisualObject obj = new TextObject(
                    75,
                    100,
                    new Point(-(panelWidth - 2 * margin), 0),
                    new Dimension(panelWidth - 2 * margin, 720),
                    "PERSONNEL",
                    new Font("Lucida Handwriting", Font.BOLD, 50),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin, 50));
            obj.putTransition(15, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(30, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text
            VisualObject obj = new TextObject(
                    75,
                    100,
                    new Point(-(panelWidth - 2 * margin2), 200),
                    new Dimension(panelWidth - 2 * margin2, 720),
                    PERSONNEL,
                    new Font("Source Sans Pro", Font.PLAIN, 28),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin2, 200));
            obj.putTransition(15, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(30, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }

        //Premises
        {
            //Panel text header
            VisualObject obj = new TextObject(
                    90,
                    135,
                    new Point(-(panelWidth - 2 * margin), 0),
                    new Dimension(panelWidth - 2 * margin, 720),
                    "PREMISES",
                    new Font("Lucida Handwriting", Font.BOLD, 50),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin, 50));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text
            VisualObject obj = new TextObject(
                    90,
                    135,
                    new Point(-(panelWidth - 2 * margin2), 200),
                    new Dimension(panelWidth - 2 * margin2, 720),
                    PREMISES,
                    new Font("Source Sans Pro", Font.PLAIN, 28),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin2, 200));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }

        //Equipment
        {
            //Panel text header
            VisualObject obj = new TextObject(
                    120,
                    165,
                    new Point(-(panelWidth - 2 * margin), 0),
                    new Dimension(panelWidth - 2 * margin, 720),
                    "EQUIPMENT",
                    new Font("Lucida Handwriting", Font.BOLD, 50),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin, 50));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text
            VisualObject obj = new TextObject(
                    120,
                    165,
                    new Point(-(panelWidth - 2 * margin2), 200),
                    new Dimension(panelWidth - 2 * margin2, 720),
                    EQUIPMENT,
                    new Font("Source Sans Pro", Font.PLAIN, 28),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin2, 200));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }

        //Financial Plans
        {
            //Panel text header
            VisualObject obj = new TextObject(
                    150,
                    195,
                    new Point(-(panelWidth - 2 * margin), 0),
                    new Dimension(panelWidth - 2 * margin, 720),
                    "FINANCIAL PLAN",
                    new Font("Lucida Handwriting", Font.BOLD, 50),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin, 50));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            //Panel text
            VisualObject obj = new TextObject(
                    150,
                    195,
                    new Point(-(panelWidth - 2 * margin2), 200),
                    new Dimension(panelWidth - 2 * margin2, 720),
                    FINANCIAL_PLAN,
                    new Font("Source Sans Pro", Font.PLAIN, 28),
                    Color.WHITE,
                    TextObject.TextAlignment.LEFT
            );

            VisualState state1 = obj.cloneDefaultState();
            state1.setPosition(new Point(margin2, 200));
            obj.putTransition(30, state1, Easing.EASE_IN_OUT);

            VisualState state2 = state1.clone();
            state2.translate(new Vector2D(-300, 0));
            state2.setOpacity(0);
            obj.putTransition(45, state2, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
        {
            VisualObject obj = new RectangleObject(180, 250, new Point(0, 0), new Dimension(1280, 720), Color.BLACK);
            obj.setOpacity(0);

            VisualState state1 = obj.cloneDefaultState();
            state1.setOpacity(1);
            obj.putTransition(20, state1, Easing.EASE_IN_OUT);

            objects.add(obj);
        }
    }
}
