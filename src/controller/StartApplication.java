package controller;

import model.Game;

import java.io.IOException;

public class StartApplication {
    public static void main(String[] args) throws IOException {
        view.Menu menu = new view.Menu();
        controller.Menu m = new controller.Menu(menu);

    }
}
