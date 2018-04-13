package view;

import model.Cell;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameFrame extends JFrame {

    public static final String PROJECT_DIRECTORY = System.getProperty("user.dir");
    public static final String BLUECHECKER = PROJECT_DIRECTORY + "/images/BLUECHECKER.png";
    public static final String GREENCHECKER = PROJECT_DIRECTORY + "/images/GREENCHECKER.png";
    public static final String GREENKING = PROJECT_DIRECTORY + "/images/greenking.png";
    public static final String BLUEKING = PROJECT_DIRECTORY + "/images/blueking.png";


    private JFrame gameframe;
    private JButton[][] buttons;
    private JLabel myname;
    private JLabel opponentname;
    private JButton concede;
    private JButton draw;
    private Cell[][] cells;
    private model.Game g;
    private String myn;
    private String opn;

    public GameFrame(model.Game game) {

        myn = game.getMyname();
        opn = game.getOpponentname();
        gameframe = new JFrame("Checkers Game");
        gameframe.setSize(1080, 780);
        g = game;
        cells = game.getCells();
        buttons = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBounds(60 + i * 80, 80 + j * 80, 80, 80);
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(new Color(192, 192, 192));
                } else {
                    buttons[i][j].setBackground(new Color(128, 128, 128));
                }
                gameframe.add(buttons[i][j]);
            }
        }

        myname = new JLabel(myn);
        opponentname = new JLabel(opn);
        opponentname.setBounds(780, 60, 380, 80);
        myname.setBounds(780, 660, 380, 80);
        concede = new JButton("Concede");
        draw = new JButton("Draw");

        concede.setBounds(780, 200, 220, 80);
        draw.setBounds(780, 320, 220, 80);

        gameframe.add(draw);
        gameframe.add(concede);
        gameframe.add(myname);
        gameframe.add(opponentname);
        gameframe.setLayout(null);
        gameframe.setVisible(true);
        draw();
    }

    private void setCheckers(){
        for (int i=0;i<8;i++){
            for(int j = 0;j<8;j++){
                if ((cells[i][j].getMyChecker()) & (cells[i][j].getKing())){
                    setMyKing(i,7-j);
                }
                else if (cells[i][j].getMyChecker()){
                    setMyChecker(i,7-j);
                }
                if ((cells[i][j].getOpponentChecker()) & (cells[i][j].getKing())){
                    setOpponentKing(i,7-j);
                }
                else if (cells[i][j].getOpponentChecker()){
                    setOpponentChecker(i,7-j);
                }
            }
        }
    }

    private void setColoredYellow(){
        for (int i=0;i<8;i++){
            for(int j = 0;j<8;j++){
                if (cells[i][j].isColored()){
                    setYellow(i,j);
                }
                else {
                }
            }
        }
    }

    public void draw(){
        if (g.getMessage() == "no_mes") {
            setBasicColors();
            setColoredYellow();
            setCheckers();
        }
        else {
            JOptionPane.showMessageDialog(gameframe, g.getMessage());
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public JButton getConcedeButton() {
        return concede;
    }

    public JButton getDrawButton() {
        return draw;
    }

    public void dispose() {
        gameframe.dispose();
    }

    public void setYellow(int i, int j) {
        buttons[i][7 - j].setBackground(new Color(226, 213, 65));
    }


    public void setEnabledButtons(boolean b) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setEnabled(b);
            }
        }
    }

    public void setMyChecker(int i, int j) {
        buttons[i][j].setIcon(new ImageIcon(GREENCHECKER));
    }

    public void setMyKing(int i, int j) {
        buttons[i][j].setIcon(new ImageIcon(GREENKING));
    }

    public void setOpponentKing(int i, int j) {
        buttons[i][j].setIcon(new ImageIcon(BLUEKING));
    }

    public void setOpponentChecker(int i, int j) {
        buttons[i][j].setIcon(new ImageIcon(BLUECHECKER));
    }

    public JButton getConcede() {
        return concede;
    }

    public JButton getDraw() {
        return draw;
    }

    public void setBasicColors() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(new Color(192, 192, 192));
                    buttons[i][j].setIcon(null);
                } else {
                    buttons[i][j].setBackground(new Color(128, 128, 128));
                    buttons[i][j].setIcon(null);
                }
            }
        }
    }

    public void addButtonListener(ActionListener a, JButton button) {
        button.addActionListener(a);
    }
    public void addListener(ActionListener a, int i, int j) {
        buttons[i][j].addActionListener(a);
    }
}