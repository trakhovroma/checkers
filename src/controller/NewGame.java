package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame {

    private view.NewGame startGame;

    public NewGame(view.NewGame startGame) {
        this.startGame = startGame;

        //add listeners to frame
        this.startGame.addstartGame1(new StartGameServerAction());
        this.startGame.addstartGame2(new StartGameClientAction());
    }

    private class StartGameServerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startGame.getString().equals("")){
                startGame.openFrame1();
            }
            else {
                startGame.openFrame2();
                startGame.dispose();
                model.Game game = new model.Game(startGame.getString(), true);
                startGame.openFrame4();
                view.GameFrame gf = new view.GameFrame(game);
                controller.Game cg = new controller.Game(game, gf);
            }
        }
    }

    private class StartGameClientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startGame.getString().equals("")){
                startGame.openFrame1();
            }
            else {
                model.Game game = new model.Game(startGame.getString(), false);
                startGame.dispose();
                startGame.openFrame3();
                view.GameFrame gf = new view.GameFrame(game);
                controller.Game cg = new controller.Game(game, gf);
            }
        }
    }
}
