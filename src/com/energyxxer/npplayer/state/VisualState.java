package com.energyxxer.npplayer.state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Created by User on 3/26/2017.
 */
public class VisualState {
    private Point position;
    private Dimension size;
    private Rotation rotation;
    private Color color;
    private float opacity;

    public VisualState() {
        this(new Point(0,0), new Dimension(0,0));
    }

    public VisualState(Point position, Dimension size) {
        this(position, size, new Rotation(0));
    }

    public VisualState(Point position, Dimension size, Color color) {
        this(position, size, new Rotation(0), color, 1);
    }

    public VisualState(Point position, Dimension size, Rotation rotation) {
        this(position, size, rotation, 1);
    }

    public VisualState(Point position, Dimension size, Rotation rotation, float opacity) {
        this(position, size, rotation, Color.BLACK, opacity);
    }

    public VisualState(Point position, Dimension size, Rotation rotation, Color color, float opacity) {
        this.position = position;
        this.size = size;
        this.rotation = rotation;
        this.color = color;
        this.opacity = opacity;
    }

    public void translate(Vector2D vec) {
        this.position.x += vec.x;
        this.position.y += vec.y;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public VisualState clone() {
        return new VisualState(new Point(position.x,position.y), new Dimension(size.width,size.height), rotation.clone(), color, opacity);
    }
}
