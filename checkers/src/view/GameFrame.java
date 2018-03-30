package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {


    private JFrame gameframe;
    private JButton[][] buttons;

    public GameFrame() {
        gameframe = new JFrame("Checkers Game");
        gameframe.setResizable(false);
        gameframe.setSize(480, 480);
        Dimension dimension = new Dimension(640, 640);
        gameframe.setVisible(true);
    }

    public void initializeButtons(){

    }
}