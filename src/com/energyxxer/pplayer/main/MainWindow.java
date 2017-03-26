package com.energyxxer.pplayer.main;

import com.energyxxer.pplayer.presentations.MendiantsPresentation;
import com.energyxxer.pplayer.presentationutil.PresentationPlayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by User on 2/1/2017.
 */
public class MainWindow {

    public static JPanel background;
    public static PresentationPlayer player;

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Presentation Player");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.getContentPane().add(background = new JPanel(new FlowLayout(FlowLayout.CENTER)));
        background.setBackground(Color.BLACK);
        background.add(player = new PresentationPlayer());
        player.setPresentation(new MendiantsPresentation());
        //player.setAlignmentX(JComponent.CENTER_ALIGNMENT);
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
                }
            }
        });
    }
}
