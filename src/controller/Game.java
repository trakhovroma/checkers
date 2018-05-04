package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {

    private model.Game game;
    private view.GameFrame vg;

    public Game(model.Game game, view.GameFrame vg) {
       this.game = game;
       this.vg = vg;


       this.vg.addButtonListener(new Concede(),vg.getConcede());
       this.vg.addButtonListener(new Draw(), vg.getDraw());

       for (int i=0;i<8;i++){
           for (int j=0;j<8;j++){
               if ((i+j)%2 == 0){
                   this.vg.addListener(new Action(i,j),7-i,j);
               }
           }
       }




    }

    private class Concede implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Concede");
        }
    }

    private class Draw implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Draw");
            vg.draw();
        }
    }


    private class Action implements ActionListener {
        private int x;
        private int y;
        public Action (int i, int j){
            x=i;
            y=j;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            game.action(x,y);
            vg.draw();
            game.actionButton(x,y);

        }
    }
}