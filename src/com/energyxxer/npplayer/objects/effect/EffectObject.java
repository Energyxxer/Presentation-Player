package com.energyxxer.npplayer.objects.effect;

import com.energyxxer.npplayer.objects.VisualObject;
import com.energyxxer.npplayer.state.VisualState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by User on 3/26/2017.
 */
public class EffectObject extends VisualObject {

    int maxSpecs = 50;

    ArrayList<Spec> specs = new ArrayList<>();

    int timeSinceLastCreation = 0;
    int spawnCooldown = 10;

    public EffectObject(int start, int end) {
        super(start, end);
    }

    @Override
    protected boolean drawObject(Graphics2D g, VisualState s) {
        Iterator<Spec> it = specs.iterator();
        g.setColor(new Color(200, 200, 200, 64));
        while(it.hasNext()) {
            Spec spec = it.next();
            if(spec.markedForDeletion) {
                it.remove();
                continue;
            }
            g.setColor(spec.color);
            g.fillOval(spec.pos.x - spec.radius, spec.pos.y - spec.radius, spec.radius * 2, spec.radius * 2);
            spec.tick();
        }

        if(timeSinceLastCreation > spawnCooldown && specs.size() < 50) {
            specs.add(new Spec());
            timeSinceLastCreation = 0;
        }
        timeSinceLastCreation++;

        return true;
    }
}

class Spec {
    Point pos = new Point();
    int radius;
    Color color;

    Point2D.Double realPos = new Point2D.Double();
    double xMotion = 0;

    boolean markedForDeletion = false;

    Spec() {
        Random random = new Random();
        this.radius = ((random.nextInt(7)+1) * (random.nextInt(7)+1));
        //this.radius = Math.max(1, radius);
        this.realPos = new Point2D.Double(random.nextInt(1280), 720 + radius + random.nextInt(50));
        this.xMotion = random.nextDouble()-0.5;
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
        updatePos();
    }

    void tick() {
        realPos.y -= (50d/radius) / 2d;
        realPos.x += xMotion;

        if(realPos.y < -radius) markedForDeletion = true;
        else updatePos();
    }

    void updatePos() {
        pos.x = (int) realPos.x;
        pos.y = (int) realPos.y;
    }
}