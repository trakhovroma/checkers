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
        model.Game sg = new model.Game();
    }
}