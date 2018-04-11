package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {

    private model.Game game;

    public Game(model.Game game) {
       this.game = game;

       this.game.addListenerConcede(new Concede());
       this.game.addListenerDraw(new Draw());

       this.game.addListener(new A1(),0,0);
       this.game.addListener(new A2(),1,0);
       this.game.addListener(new A3(),2,0);
       this.game.addListener(new A4(),3,0);
       this.game.addListener(new A5(),4,0);
       this.game.addListener(new A6(),5,0);
       this.game.addListener(new A7(),6,0);
       this.game.addListener(new A8(),7,0);

       this.game.addListener(new B1(),0,1);
       this.game.addListener(new B2(),1,1);
       this.game.addListener(new B3(),2,1);
       this.game.addListener(new B4(),3,1);
       this.game.addListener(new B5(),4,1);
       this.game.addListener(new B6(),5,1);
       this.game.addListener(new B7(),6,1);
       this.game.addListener(new B8(),7,1);

       this.game.addListener(new C1(),0,2);
       this.game.addListener(new C2(),1,2);
       this.game.addListener(new C3(),2,2);
       this.game.addListener(new C4(),3,2);
       this.game.addListener(new C5(),4,2);
       this.game.addListener(new C6(),5,2);
       this.game.addListener(new C7(),6,2);
       this.game.addListener(new C8(),7,2);

        this.game.addListener(new D1(),0,3);
        this.game.addListener(new D2(),1,3);
        this.game.addListener(new D3(),2,3);
        this.game.addListener(new D4(),3,3);
        this.game.addListener(new D5(),4,3);
        this.game.addListener(new D6(),5,3);
        this.game.addListener(new D7(),6,3);
        this.game.addListener(new D8(),7,3);

        this.game.addListener(new E1(),0,4);
        this.game.addListener(new E2(),1,4);
        this.game.addListener(new E3(),2,4);
        this.game.addListener(new E4(),3,4);
        this.game.addListener(new E5(),4,4);
        this.game.addListener(new E6(),5,4);
        this.game.addListener(new E7(),6,4);
        this.game.addListener(new E8(),7,4);

        this.game.addListener(new F1(),0,5);
        this.game.addListener(new F2(),1,5);
        this.game.addListener(new F3(),2,5);
        this.game.addListener(new F4(),3,5);
        this.game.addListener(new F5(),4,5);
        this.game.addListener(new F6(),5,5);
        this.game.addListener(new F7(),6,5);
        this.game.addListener(new F8(),7,5);

        this.game.addListener(new G1(),0,6);
        this.game.addListener(new G2(),1,6);
        this.game.addListener(new G3(),2,6);
        this.game.addListener(new G4(),3,6);
        this.game.addListener(new G5(),4,6);
        this.game.addListener(new G6(),5,6);
        this.game.addListener(new G7(),6,6);
        this.game.addListener(new G8(),7,6);

        this.game.addListener(new H1(),0,7);
        this.game.addListener(new H2(),1,7);
        this.game.addListener(new H3(),2,7);
        this.game.addListener(new H4(),3,7);
        this.game.addListener(new H5(),4,7);
        this.game.addListener(new H6(),5,7);
        this.game.addListener(new H7(),6,7);
        this.game.addListener(new H8(),7,7);



    }

    private class Concede implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class Draw implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.draw();
        }
    }
    private class A1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,0);
        }
    }
    private class A2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,0);
        }
    }
    private class A3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,0);
        }
    }
    private class A4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,0);
        }
    }
    private class A5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,0);
        }
    }
    private class A6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,0);
        }
    }
    private class A7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,0);
        }
    }
    private class A8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,0);
        }
    }

    private class B1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,1);
        }
    }
    private class B2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,1);
        }
    }
    private class B3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,1);
        }
    }
    private class B4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,1);
        }
    }
    private class B5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,1);
        }
    }
    private class B6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,1);
        }
    }
    private class B7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,1);
        }
    }
    private class B8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,1);
        }
    }
    private class C1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,2);
        }
    }
    private class C2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,2);
        }
    }
    private class C3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,2);
        }
    }
    private class C4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,2);
        }
    }
    private class C5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,2);
        }
    }
    private class C6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,2);
        }
    }
    private class C7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,2);
        }
    }
    private class C8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,2);
        }
    }

    private class D1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,3);
        }
    }
    private class D2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,3);
        }
    }
    private class D3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,3);
        }
    }
    private class D4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,3);
        }
    }
    private class D5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,3);
        }
    }
    private class D6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,3);
        }
    }
    private class D7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,3);
        }
    }
    private class D8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,3);
        }
    }

    private class E1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,4);
        }
    }
    private class E2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,4);
        }
    }
    private class E3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,4);
        }
    }
    private class E4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,4);
        }
    }
    private class E5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,4);
        }
    }
    private class E6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,4);
        }
    }
    private class E7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,4);
        }
    }
    private class E8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,4);
        }
    }

    private class F1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,5);
        }
    }
    private class F2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,5);
        }
    }
    private class F3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,5);
        }
    }
    private class F4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,5);
        }
    }
    private class F5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,5);
        }
    }
    private class F6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,5);
        }
    }
    private class F7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,5);
        }
    }
    private class F8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,5);
        }
    }

    private class G1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,6);
        }
    }
    private class G2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,6);
        }
    }
    private class G3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,6);
        }
    }
    private class G4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,6);
        }
    }
    private class G5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,6);
        }
    }
    private class G6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,6);
        }
    }
    private class G7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,6);
        }
    }
    private class G8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,6);
        }
    }

    private class H1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,7);
        }
    }
    private class H2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,7);
        }
    }
    private class H3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,7);
        }
    }
    private class H4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,7);
        }
    }
    private class H5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,7);
        }
    }
    private class H6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,7);
        }
    }
    private class H7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,7);
        }
    }
    private class H8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,7);
        }
    }
}
