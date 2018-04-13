package controller;

public class StartApplication {
    public static void main(String[] args) {
        /*
        view.Menu menu = new view.Menu();
        controller.Menu m = new controller.Menu(menu);
        */

        model.Game game = new model.Game("Test1", "Test2");
        view.GameFrame gf = new view.GameFrame(game);
        controller.Game g = new controller.Game(game,gf);

    }
}
