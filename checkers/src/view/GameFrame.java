package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {


    private JFrame gameframe;
    private JButton[][] buttons;
    private JLabel myname;
    private JLabel opponentname;
    private JButton concede;
    private JButton draw;

    public GameFrame() {
        gameframe = new JFrame("Checkers Game");
        gameframe.setSize(1080, 780);
        buttons = new JButton[8][8];
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                buttons[i][j] = new JButton("SHAHKA");
                buttons[i][j].setBounds(60+i*80,80 +j*80, 80,80);
                gameframe.add(buttons[i][j]);
            }
        }
        myname = new JLabel("My_name");
        opponentname = new JLabel("Opponent_name");
        opponentname.setBounds(780,60,380,80);
        myname.setBounds(780,660,380,80);
        concede = new JButton("Concede");
        draw = new JButton("Draw");

        concede.setBounds(780,200, 220, 80);
        draw.setBounds(780,320, 220, 80);

        gameframe.add(draw);
        gameframe.add(concede);
        gameframe.add(myname);
        gameframe.add(opponentname);
        gameframe.setLayout(null);
        gameframe.setVisible(true);
    }

    public void initializeButtons(){

    }
}