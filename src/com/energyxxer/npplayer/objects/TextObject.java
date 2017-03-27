package com.energyxxer.npplayer.objects;

import com.energyxxer.npplayer.state.VisualState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Created by User on 3/26/2017.
 */
public class TextObject extends VisualObject {
    public enum TextAlignment {
        LEFT, CENTER, RIGHT
    }
    private static final Font DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 20);
    private static final TextAlignment DEFAULT_ALIGNMENT = TextAlignment.LEFT;

    private String text;
    private Font font;
    private TextAlignment alignment;

    public TextObject(int start, int end, Point pos, Dimension size, String text) {
        this(start, end, pos, size, text, Color.BLACK);
    }
    public TextObject(int start, int end, Point pos, Dimension size, String text, TextAlignment alignment) {
        this(start, end, pos, size, text, Color.BLACK, alignment);
    }
    public TextObject(int start, int end, Point pos, Dimension size, String text, Color color) {
        this(start, end, pos, size, text, DEFAULT_FONT, color);
    }
    public TextObject(int start, int end, Point pos, Dimension size, String text, Color color, TextAlignment alignment) {
        this(start, end, pos, size, text, DEFAULT_FONT, color, alignment);
    }
    public TextObject(int start, int end, Point pos, Dimension size, String text, Font font, Color color) {
        this(start, end, pos, size, text, font, color, DEFAULT_ALIGNMENT);
    }
    public TextObject(int start, int end, Point pos, Dimension size, String text, Font font, Color color, TextAlignment alignment) {
        super(start, end, new VisualState(pos, size, color));
        this.text = text;
        this.font = font;
        this.alignment = alignment;
    }

    @Override
    protected boolean drawObject(Graphics2D g, VisualState s) {
        Point pos = s.getPosition();
        Dimension size = s.getSize();

        Color newColor = new Color(s.getColor().getRed(),s.getColor().getGreen(),s.getColor().getBlue(),(int) (s.getColor().getAlpha() * s.getOpacity()));
        g.setColor(newColor);
        g.setFont(font);

        int y = pos.y;
        FontMetrics metrics = g.getFontMetrics(font);
        y += metrics.getAscent();
        int lineHeight = font.getSize() + metrics.getDescent();
        int maxWidth = size.width;

        String[] lines = text.split("\n");

        for(String l : lines) {
            String[] words = l.split(" ");
            String line = "";

            for(String word : words) {
                String testLine = line + word + ' ';
                int testWidth = metrics.stringWidth(testLine);
                if(testWidth > maxWidth) {
                    g.drawString(line, pos.x, y);
                    line = word + ' ';
                    y += lineHeight;
                } else {
                    line = testLine;
                }
            }

            int x = pos.x;
            if(alignment == TextAlignment.CENTER) {
                x += (size.width/2) - (metrics.stringWidth(line)/2);
            } else if(alignment == TextAlignment.RIGHT) {
                x += size.width;
                x -= metrics.stringWidth(line);
            }
            g.drawString(line, x, y);
            y += lineHeight;
        }

        return true;
    }
}
