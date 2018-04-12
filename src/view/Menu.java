package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    protected JFrame frame;
    private JMenuItem exit;
    private JMenuItem about;
    private JMenuItem rules;
    private JButton newgame;
    private JButton scores;
    private JButton exitbutton;

    public Menu() {
        frame = new JFrame("Checkers");
        frame.setResizable(false);
        frame.setSize(400, 600);
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu file = new JMenu("Menu");
        menubar.add(file);
        exit = new JMenuItem("Exit");
        file.add(exit);
        JMenu help = new JMenu("Help");
        menubar.add(help);
        about = new JMenuItem("About");
        rules = new JMenuItem("Rules");
        help.add(rules);
        help.add(about);

        Dimension dimension=new Dimension(300,100);
        Dimension dim1 = new Dimension(300, 50);

        JLabel battle = new JLabel(" ");
        battle.setPreferredSize(dim1);

        newgame = new JButton("New Game");
        newgame.setPreferredSize(dimension);
        newgame.setBackground(new Color(102, 51, 0));
        newgame.setForeground(Color.WHITE);

        scores = new JButton("Scores");
        scores.setPreferredSize(dimension);
        scores.setBackground(new Color(102, 51, 0));
        scores.setForeground(Color.WHITE);

        exitbutton = new JButton("Exit");
        exitbutton.setPreferredSize(dimension);
        exitbutton.setBackground(new Color(102, 51, 0));
        exitbutton.setForeground(Color.WHITE);

        newgame.setFont(new Font("Droid Sans Mono",Font.BOLD, 40));
        scores.setFont(new Font("Droid Sans Mono",Font.BOLD, 40));
        exitbutton.setFont(new Font("Droid Sans Mono",Font.BOLD, 40));

        frame.add(battle);
        frame.add(newgame);
        frame.add(scores);
        frame.add(exitbutton);
        frame.getContentPane().setBackground(new Color(204, 153, 0));


        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        pack();
    }

    //about action frame
    public void aboutAction(){
        JFrame frame = new JFrame("About");
        frame.setResizable(false);
        frame.setSize(400, 300);
        JLabel label = new JLabel("Created by Roman Trakhov");
        Font font = new Font("Arial", Font.ITALIC, 14);
        label.setFont(font);
        frame.add(label);
        frame.setBackground(new Color(204, 153, 0));
        frame.setVisible(true);
    }
    public void rulesAction(){
        JFrame frame = new JFrame("Rules");
        frame.setResizable(false);
        frame.setSize(400, 300);
        JLabel label = new JLabel("Here will be game rules");
        Font font = new Font("Arial", Font.ITALIC, 14);
        label.setFont(font);
        frame.add(label);
        frame.setBackground(new Color(204, 153, 0));
        frame.setVisible(true);
    }
    //getters
    public JMenuItem getExit(){
        return exit;
    }
    public JMenuItem getAbout(){
        return about;
    }
    public JMenuItem getRules(){
        return rules;
    }
    public JButton getNewgame(){
        return newgame;
    }
    public JButton getScores(){
        return scores;
    }
    public JButton getExitbutton(){
        return exitbutton;
    }
    public JFrame getFrame(){
        return frame;
    }

    //dispose that class
    public void dispose(){
        getFrame().dispose();
    }

    //add Listeners
    public void addButtonListener(ActionListener a, JButton button){
        button.addActionListener(a);
    }
    public void addMenuItemListener(ActionListener a, JMenuItem jMenuItem){
        jMenuItem.addActionListener(a);
    }
}
