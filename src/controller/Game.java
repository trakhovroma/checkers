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

       this.vg.addListener(new A2(),1,0);
       this.vg.addListener(new A4(),3,0);
       this.vg.addListener(new A6(),5,0);
       this.vg.addListener(new A8(),7,0);

       this.vg.addListener(new B1(),0,1);
       this.vg.addListener(new B3(),2,1);
       this.vg.addListener(new B5(),4,1);
       this.vg.addListener(new B7(),6,1);

       this.vg.addListener(new C2(),1,2);
       this.vg.addListener(new C4(),3,2);
       this.vg.addListener(new C6(),5,2);
       this.vg.addListener(new C8(),7,2);

        this.vg.addListener(new D1(),0,3);
        this.vg.addListener(new D3(),2,3);
        this.vg.addListener(new D5(),4,3);
        this.vg.addListener(new D7(),6,3);

        this.vg.addListener(new E2(),1,4);
        this.vg.addListener(new E4(),3,4);
        this.vg.addListener(new E6(),5,4);
        this.vg.addListener(new E8(),7,4);

        this.vg.addListener(new F1(),0,5);
        this.vg.addListener(new F3(),2,5);
        this.vg.addListener(new F5(),4,5);
        this.vg.addListener(new F7(),6,5);

        this.vg.addListener(new G2(),1,6);
        this.vg.addListener(new G4(),3,6);
        this.vg.addListener(new G6(),5,6);
        this.vg.addListener(new G8(),7,6);

        this.vg.addListener(new H1(),0,7);
        this.vg.addListener(new H3(),2,7);
        this.vg.addListener(new H5(),4,7);
        this.vg.addListener(new H7(),6,7);



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
    private class A2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,0);
            vg.draw();
        }
    }
    private class A4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,0);
            vg.draw();
        }
    }
    private class A6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,0);
            vg.draw();
        }
    }
    private class A8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,0);
            vg.draw();
        }
    }

    private class B1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,1);
            vg.draw();
        }
    }
    private class B3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,1);
            vg.draw();
        }
    }
    private class B5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,1);
            vg.draw();
        }
    }
    private class B7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,1);
            vg.draw();
        }
    }

    private class C2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,2);
            vg.draw();
        }
    }

    private class C4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,2);
            vg.draw();
        }
    }

    private class C6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,2);
            vg.draw();
        }
    }

    private class C8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,2);
            vg.draw();
        }
    }

    private class D1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,3);
            vg.draw();
        }
    }

    private class D3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,3);
            vg.draw();
        }
    }

    private class D5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,3);
            vg.draw();
        }
    }

    private class D7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,3);
            vg.draw();
        }
    }


    private class E2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,4);
            vg.draw();
        }
    }

    private class E4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,4);
            vg.draw();
        }
    }

    private class E6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,4);
            vg.draw();
        }
    }

    private class E8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,4);
            vg.draw();
        }
    }

    private class F1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,5);
            vg.draw();
        }
    }

    private class F3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,5);
            vg.draw();
        }
    }

    private class F5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,5);
            vg.draw();
        }
    }

    private class F7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,5);
            vg.draw();
        }
    }

    private class G2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(6,6);
            vg.draw();
        }
    }

    private class G4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(4,6);
            vg.draw();
        }
    }

    private class G6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(2,6);
            vg.draw();
        }
    }

    private class G8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(0,6);
            vg.draw();
        }
    }

    private class H1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(7,7);
            vg.draw();
        }
    }

    private class H3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(5,7);
            vg.draw();
        }
    }

    private class H5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(3,7);
            vg.draw();
        }
    }

    private class H7 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.actionButton(1,7);
            vg.draw();
        }
    }
}