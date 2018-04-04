package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends model.NewGame {
    model.NewGame startGame;

    public NewGame(model.NewGame startGame) {
        this.startGame = startGame;

        //add listeners to frame
        this.startGame.addstartGame1(new StartGameServerAction());
        this.startGame.addstartGame2(new StartGameClientAction());
        dispose();      //dispose view frame without listeners
    }

    private class StartGameServerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame.serverStart();
        }
    }

    private class StartGameClientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame.clientStart();
        }
    }
}
