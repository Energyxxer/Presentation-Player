package com.energyxxer.npplayer.objects;

import com.energyxxer.npplayer.state.VisualState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Created by User on 3/26/2017.
 */
public class OvalObject extends VisualObject {
    public OvalObject(int start, int end, Point pos, Dimension size) {
        this(start, end, pos, size, Color.BLACK);
    }
    public OvalObject(int start, int end, Point pos, Dimension size, Color color) {
        super(start, end, new VisualState(pos, size, color));
    }

    @Override
    protected boolean drawObject(Graphics2D g, VisualState s) {
        Point pos = s.getPosition();
        Dimension size = s.getSize();

        g.setColor(s.getColor());
        g.fillOval(pos.x, pos.y, size.width, size.height);

        return true;
    }
}
