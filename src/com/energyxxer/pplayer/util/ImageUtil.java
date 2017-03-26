package com.energyxxer.pplayer.util;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * Created by User on 2/1/2017.
 */
public class ImageUtil {
    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

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

    public static Rectangle centerDimension(Dimension dim, Dimension bounds) {
        return new Rectangle((bounds.width/2)-(dim.width/2),(bounds.height/2)-(dim.height/2),dim.width,dim.height);
    }
}
