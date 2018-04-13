package controller;

public class StartApplication {
    public static void main(String[] args) {
        view.Menu menu = new view.Menu();
        controller.Menu m = new controller.Menu(menu);
    }
}
