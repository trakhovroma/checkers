package model;


import view.GameFrame;
import view.Menu;

public class Game {
    public static final int NUMBERROWS = 8;
    public static final int NUMBERCOLUMNS = 8;

    private Cell[][] cells;

    public Game(){
        cells = new Cell[NUMBERROWS][NUMBERCOLUMNS];
        fillcells();
    }

    private void fillcells(){
        for(int i=1;i<NUMBERROWS+1;i++){
            for(int j=1;j<NUMBERCOLUMNS+1;j++){
                cells[i-1][j-1]= new Cell(i,j);
            }
        }
    }

    public int getNumberOfMyCheckers(){
        int number = 0;
        for(int i=0;i<NUMBERROWS;i++){
            for(int j=0;j<NUMBERCOLUMNS;j++){
                if (cells[i][j].getMyChecker() == true){
                    number+=1;
                }
            }
        }
        return number;
    }
    public int getNumberOfOpponentCheckers(){
        int number = 0;
        for(int i=0;i<NUMBERROWS;i++){
            for(int j=0;j<NUMBERCOLUMNS;j++){
                if (cells[i][j].getOpponentChecker() == true){
                    number+=1;
                }
            }
        }
        return number;
    }

        public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        Game g = new Game();
        Menu m= new Menu();
            System.out.println(g.getNumberOfMyCheckers());
            System.out.println(g.getNumberOfOpponentCheckers());
        System.out.print("Hellouuu");
    }
}
