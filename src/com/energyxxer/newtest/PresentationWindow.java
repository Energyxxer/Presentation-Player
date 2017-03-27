package com.energyxxer.newtest;

import com.energyxxer.npplayer.Presentation;
import com.energyxxer.npplayer.PresentationPlayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by User on 3/26/2017.
 */
public class PresentationWindow {
    public static JPanel background;
    public static PresentationPlayer player;

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Presentation Player");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.getContentPane().add(background = new JPanel(new GridBagLayout()));
        background.setBackground(Color.BLACK);
        background.add(player = new PresentationPlayer());
        player.setPresentation(new BusinessPresentation());
        jframe.setUndecorated(true);
        jframe.setVisible(true);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);

        jframe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.forward();
                } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.back();
                } else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    player.togglePause();
                }
            }
        });
    }
}
