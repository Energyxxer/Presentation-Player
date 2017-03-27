package com.energyxxer.npplayer;

import com.energyxxer.npplayer.objects.VisualObject;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 3/26/2017.
 */
public class PresentationPlayer extends JPanel {
    private int keyframe = 0;
    private int targetBreakpoint = -1;

    private Presentation presentation = null;

    private boolean paused = false;

    {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(!paused && (advance() || true)) repaint();
            }
        },5,5);
    }

    public void setPresentation(Presentation p) {
        this.presentation = p;
        this.setPreferredSize(p.dimensions);
        keyframe = 0;
        targetBreakpoint = -1;
    }

    private ArrayList<VisualObject> getObjectsAtTime(int frame) {
        ArrayList<VisualObject> returnValue = new ArrayList<>();

        for(VisualObject obj : presentation.objects) {
            if(frame >= obj.getStart() && frame < obj.getEnd()) {
                returnValue.add(obj);
            }
        }

        return returnValue;
    }

    public void forward() {
        if(targetBreakpoint < presentation.breakpoints.size()-1) {
            targetBreakpoint++;
        }
    }

    public void back() {
        if(targetBreakpoint >= 0) {
            targetBreakpoint--;
        }
    }

    private boolean advance() {
        if(targetBreakpoint < 0) {
            if(keyframe > 0) {
                keyframe--;
                return true;
            }
        } else if(targetBreakpoint >= presentation.breakpoints.size()) {
            if(keyframe <= presentation.breakpoints.get(presentation.breakpoints.size()-1)) {
                keyframe++;
                return true;
            }
        } else {
            if(keyframe < presentation.breakpoints.get(targetBreakpoint)) {
                keyframe++;
                return true;
            } else if(keyframe > presentation.breakpoints.get(targetBreakpoint)) {
                keyframe--;
                return true;
            }
        }
        return false;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public void togglePause() {
        paused = !paused;
    }

    @Override
    protected void paintComponent(Graphics g0) {

        Graphics2D g2d = (Graphics2D) g0;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());

        if(presentation == null) return;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);

        ArrayList<VisualObject> objectsToPaint = getObjectsAtTime(keyframe);

        for(VisualObject obj : objectsToPaint) {
            obj.draw(g2d, keyframe);
        }
    }
}
