package com.energyxxer.npplayer.state;

import java.awt.Point;

/**
 * Created by User on 2/1/2017.
 */
public class Rotation {

    public double angle;
    public Point origin;
    public boolean locked;

    public Rotation(double angle, Point origin) {
        this.angle = angle;
        this.origin = origin;
        this.locked = false;
    }

    public Rotation(double angle) {
        this.angle = angle;
        this.origin = new Point();
        this.locked = true;
    }

    public Rotation clone() {
        return (locked) ? new Rotation(angle) : new Rotation(angle, origin);
    }
}
