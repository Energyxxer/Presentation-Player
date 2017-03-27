package com.energyxxer.npplayer.objects;

import com.energyxxer.npplayer.state.VisualState;
import com.energyxxer.npplayer.util.ImageManager;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Created by User on 3/26/2017.
 */
public class ImageObject extends VisualObject {
    private BufferedImage img;

    public ImageObject(int start, int end, Point pos, Dimension size, BufferedImage img) {
        super(start, end, new VisualState(pos, size));
        this.img = img;
    }
    public ImageObject(int start, int end, Point pos, Dimension size, String path) {
        super(start, end, new VisualState(pos, size));
        this.img = ImageManager.load(path);
    }

    @Override
    protected boolean drawObject(Graphics2D g, VisualState s) {
        Point pos = s.getPosition();
        Dimension size = s.getSize();

        Dimension scaledInstance = getScaledDimension(new Dimension(img.getWidth(), img.getHeight()), size);
        Rectangle rect = centerDimension(scaledInstance, size);

        g.drawImage(img, pos.x + rect.x, pos.y + rect.y, rect.width, rect.height, null);

        return true;
    }

    private static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        float aspect_ratio = (float) new_width / new_height;
        float bound_ratio = (float) bound_width / bound_height;

        if(aspect_ratio > bound_ratio) {
            new_width = bound_width;
            new_height = (new_width * original_height) / original_width;
        } else {
            new_height = bound_height;
            new_width = (new_height * original_width) / original_height;
        }
        new_width = (int) Math.floor(new_width);
        new_height = (int) Math.floor(new_height);
        return new Dimension(new_width, new_height);
    }

    private static Rectangle centerDimension(Dimension dim, Dimension bounds) {
        return new Rectangle((bounds.width/2)-(dim.width/2),(bounds.height/2)-(dim.height/2),dim.width,dim.height);
    }
}
