package model;

public class Menu extends view.Menu {

    public void aboutAct(){
        aboutAction();
    }
    public void rulesAct(){
        rulesAction();
    }
    public void newGame(){
        getFrame().dispose();
        model.NewGame ng = new model.NewGame();
        controller.NewGame sg = new controller.NewGame(ng);
    }
}