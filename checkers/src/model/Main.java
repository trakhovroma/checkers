package model;

import javax.swing.text.View;

public class Main {
    public static void main(String[] args) {
        /*model.Menu menu = new model.Menu();
        controller.Menu m = new controller.Menu(menu);*/

        /*view.GameFrame gf = new view.GameFrame("Test1", "Test2");*/

        model.Game game = new model.Game("TEst1","TEst2");
        controller.Game g = new controller.Game(game);
    }
}