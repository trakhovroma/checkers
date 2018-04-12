package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends view.Menu {

    view.Menu frame;
    public Menu(view.Menu frame){
        this.frame = frame;
        this.frame.addMenuItemListener(new ExitAction(), getExit());
        this.frame.addMenuItemListener(new AboutAction(), getAbout());
        this.frame.addMenuItemListener(new RulesAction(), getRules());
        this.frame.addButtonListener(new ExitAction(), getExitbutton());
        this.frame.addButtonListener(new NewGameAction(), getNewgame());
        this.frame.addButtonListener(new ScoresAction(), getScores());
        this.frame.setVisible(true);
        this.frame.dispose();
    }

    private class AboutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            aboutAction();
        }
    }

    private class RulesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            rulesAction();
        }
    }

    private class NewGameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getFrame().dispose();
            model.NewGame ng = new model.NewGame();
            controller.NewGame sg = new controller.NewGame(ng);
        }
    }

    private class ScoresAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.ReadFile f = new model.ReadFile();
            f.maketable();
        }
    }

    private class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.Exit exit = new view.Exit();
        }
    }

}