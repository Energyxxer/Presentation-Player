package com.energyxxer.pplayer.presentationutil;

import com.energyxxer.pplayer.presentationutil.enums.ObjectType;
import com.energyxxer.pplayer.presentationutil.enums.TextAlignment;
import com.energyxxer.pplayer.util.ImageUtil;

import javax.swing.JPanel;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 2/1/2017.
 */
public class PresentationPlayer extends JPanel {

    public int keyframe = 0,
            targetBreakpoint = -1;

    public Presentation presentation = null;

    {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                advance();
                repaint();
            }
        },5,5);
    }

    public void setPresentation(Presentation p) {
        this.presentation = p;
        this.setPreferredSize(p.dimensions);
        keyframe = 0;
        targetBreakpoint = -1;
    }

    public ArrayList<PresentationObject> getObjectsAtTime(int frame) {
        ArrayList<PresentationObject> returnValue = new ArrayList<>();

        for(PresentationObject obj : presentation.objects) {
            if(frame >= obj.startKeyframe && frame < obj.endKeyframe) {
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

    public void advance() {
        if(targetBreakpoint < 0) {
            if(keyframe > 0) {
                keyframe--;
            }
        } else if(targetBreakpoint >= presentation.breakpoints.size()) {
            if(keyframe <= presentation.breakpoints.get(presentation.breakpoints.size()-1)) {
                keyframe++;
            }
        } else {
            if(keyframe < presentation.breakpoints.get(targetBreakpoint)) {
                keyframe++;
            } else if(keyframe > presentation.breakpoints.get(targetBreakpoint)) {
                keyframe--;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g0) {

        Graphics2D g2d = (Graphics2D) g0;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());

        if(presentation == null) return;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        int frame = keyframe;

        ArrayList<PresentationObject> objectsToPaint = getObjectsAtTime(frame);

        for(PresentationObject obj : objectsToPaint) {

            Graphics2D g = (Graphics2D) g2d.create();

            ObjectState state = obj.interpolateStates(frame);
            if(state.opacity == 0) continue;

            if(state.rotation.locked) {
                g.translate(state.position.x + (state.size.width/2),state.position.y + (state.size.height/2));
                g.rotate(Math.toRadians(state.rotation.angle));
                g.translate(-(state.position.x + (state.size.width/2)),-(state.position.y + (state.size.height/2)));
            } else {
                g.translate(state.rotation.origin.x,state.rotation.origin.y);
                g.rotate(Math.toRadians(state.rotation.angle));
                g.translate(-state.rotation.origin.x,-state.rotation.origin.y);
            }

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, state.opacity));

            if(obj.type == ObjectType.RECTANGLE) {

                g.setColor(state.color);
                g.fillRect(state.position.x, state.position.y, state.size.width, state.size.height);

            } else if(obj.type == ObjectType.OVAL) {

                g.setColor(state.color);
                g.fillOval(state.position.x, state.position.y, state.size.width, state.size.height);

            } else if(obj.type == ObjectType.TEXT) {

                Color newColor = new Color(state.color.getRed(),state.color.getGreen(),state.color.getBlue(),(int) (state.color.getAlpha() * state.opacity));
                g.setColor(newColor);
                g.setFont(state.font);
                //g.setOpacity(1);

                String text = (String) state.value;

                int y = state.position.y;
                FontMetrics metrics = g.getFontMetrics(state.font);
                y += metrics.getAscent();
                int lineHeight = state.font.getSize() + metrics.getDescent();
                int maxWidth = state.size.width;

                String[] lines = text.split("\n");

                for(String l : lines) {
                    String[] words = l.split(" ");
                    String line = "";

                    for(String word : words) {
                        String testLine = line + word + ' ';
                        int testWidth = metrics.stringWidth(testLine);
                        if(testWidth > maxWidth) {
                            g.drawString(line, state.position.x, y);
                            line = word + ' ';
                            y += lineHeight;
                        } else {
                            line = testLine;
                        }
                    }

                    int x = state.position.x;
                    if(obj.textAlignment == TextAlignment.CENTER) {
                        x += (state.size.width/2) - (metrics.stringWidth(line)/2);
                    } else if(obj.textAlignment == TextAlignment.RIGHT) {
                        x += state.size.width;
                        x -= metrics.stringWidth(line);
                    }
                    g.drawString(line, x, y);
                    y += lineHeight;
                }
            } else if(obj.type == ObjectType.IMAGE) {

                BufferedImage img = (BufferedImage) state.getValue();
                Dimension scaledInstance = ImageUtil.getScaledDimension(new Dimension(img.getWidth(), img.getHeight()), state.getSize());
                Rectangle drawingRectangle = ImageUtil.centerDimension(scaledInstance, state.getSize());

                g.drawImage(img, state.getPosition().x+drawingRectangle.x, state.getPosition().y+drawingRectangle.y, drawingRectangle.width, drawingRectangle.height, null);

            }

            g.dispose();
        }
    }
}
