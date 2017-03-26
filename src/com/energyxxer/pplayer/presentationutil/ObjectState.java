package com.energyxxer.pplayer.presentationutil;

import com.energyxxer.pplayer.util.Rotation;
import com.energyxxer.pplayer.util.Vector2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

/**
 * Created by User on 2/1/2017.
 */
public class ObjectState {

    public Point position = null;
    public Dimension size = null;
    public Rotation rotation = null;
    public float opacity = 1;

    public Object value = null;
    public Font font = new Font("Tahoma",0,12);
    public Color color = null;

    public ObjectState() {
    }

    public ObjectState(ObjectState old) {
        this.position = new Point(old.position.x,old.position.y);
        this.size = new Dimension(old.size.width,old.size.height);
        this.rotation = new Rotation(old.rotation.angle,old.rotation.origin);
        this.rotation.locked = old.rotation.locked;
        this.opacity = old.opacity;

        this.value = old.value;
        this.font = new Font(old.font.getFontName(),old.font.getStyle(),old.font.getSize());
        this.color = new Color(old.color.getRed(),old.color.getGreen(),old.color.getBlue());
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

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
