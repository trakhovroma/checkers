package model;


import view.GameFrame;
import view.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Game {
    public static final int NUMBERROWS = 8;
    public static final int NUMBERCOLUMNS = 8;

    private view.GameFrame gf;
    private Cell[][] cells;
    private String myname;
    private String opponentname;

    public Game(String my_name, String opponent_name){
        myname = my_name;
        opponentname = opponent_name;
        gf = new view.GameFrame(myname, opponentname);
        cells = new Cell[NUMBERROWS][NUMBERCOLUMNS];
        fillcells();
    }


    private void fillcells(){
        for(int i=0;i<NUMBERROWS;i++){
            for(int j=0;j<NUMBERCOLUMNS;j++){
                cells[i][j]= new Cell(i,j);
            }
        }
    }

    public void availableturns(Cell cell){
        int x = cell.getX();
        int y = cell.getY();
        if (cell.getMyChecker() == true){
            if (eatmarker(x , y) == true){
                if (cell.getKing() == true){
                    if ((getnearestcheck1(x,y)[0] <=6) & (getnearestcheck1(x,y)[1] <=6)){
                        if (cells[getnearestcheck1(x,y)[0]+1][getnearestcheck1(x,y)[1]+1].getEmpty() == true){
                            cells[getnearestcheck1(x,y)[0]+1][getnearestcheck1(x,y)[1]+1].setColored(true);
                        }
                    }
                    else if ((getnearestcheck2(x,y)[0] <=6) & (getnearestcheck2(x,y)[1] <=7) & (getnearestcheck2(x,y)[1] >0)){
                        if (cells[getnearestcheck2(x,y)[0]+1][getnearestcheck2(x,y)[1]-1].getEmpty() == true){
                            cells[getnearestcheck2(x,y)[0]+1][getnearestcheck2(x,y)[1]-1].setColored(true);
                        }
                    }
                    else if ((getnearestcheck3(x,y)[1] <=6) & (getnearestcheck3(x,y)[0] <=7) & (getnearestcheck3(x,y)[0] >0)){
                        if (cells[getnearestcheck3(x,y)[0]-1][getnearestcheck3(x,y)[1]+1].getEmpty() == true){
                            cells[getnearestcheck3(x,y)[0]-1][getnearestcheck3(x,y)[1]+1].setColored(true);
                        }
                    }
                    else if ((getnearestcheck4(x,y)[0] <=7) & (getnearestcheck4(x,y)[0] >0) & (getnearestcheck4(x,y)[1] <=7) & (getnearestcheck4(x,y)[1] >0)){
                        if (cells[getnearestcheck4(x,y)[0]-1][getnearestcheck4(y,x)[1]-1].getEmpty() == true){
                            cells[getnearestcheck4(x,y)[0]-1][getnearestcheck4(y,x)[1]-1].setColored(true);
                        }
                    }
                }
            }
            else{
                if (cell.getKing() == false){
                    System.out.println("notKing");
                    if ((x <=6) & (y <=6)){
                        if (cells[x+1][y+1].getEmpty()) {
                            cells[x + 1][y + 1].setColored(true);
                        }
                    }
                    if ((x >0) & (y<=6)) {
                        if (cells[x-1][y+1].getEmpty()) {
                        System.out.println("left");
                        cells[x - 1][y + 1].setColored(true);
                    }
                    }

                }
                else if (cell.getKing() == true){
                    int i = x;
                    int j = y;
                    while ((i<7) & (j<7) & (cells[i+1][j+1].getEmpty())){
                        cells[i+1][j+1].setColored(true);
                        i++;
                        j++;
                    }
                    i = x;
                    j = y;
                    while ((i>0) &(j<7)&(cells[i-1][j+1].getEmpty())){
                        cells[i-1][j+1].setColored(true);
                        i--;
                        j++;
                    }
                    i = x;
                    j = y;
                    while ((i<7) &(j>0)&(cells[i+1][j-1].getEmpty())){
                        cells[i+1][j-1].setColored(true);
                        i++;
                        j--;
                    }
                    i = x;
                    j = y;
                    while ((i>0) &(j>0)&(cells[i-1][j-1].getEmpty())){
                        cells[i-1][j-1].setColored(true);
                        i--;
                        j--;
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(gf, "Select your own checker");
        }
    }



    public boolean eatmarker(int i,int j){

        if (cells[i][j].getMyChecker() == true){
            if (cells[i][j].getKing()==true){
                        if ((getnearestcheck1(i,j)[0] <=6) & (getnearestcheck1(i,j)[1] <=6)){
                            if (cells[getnearestcheck1(i,j)[0]+1][getnearestcheck1(i,j)[1]+1].getEmpty() == true){
                                return true;
                            }
                        }
                        else if ((getnearestcheck2(i,j)[0] <=6) & (getnearestcheck2(i,j)[1] <=7) & (getnearestcheck2(i,j)[1] >0)){
                            if (cells[getnearestcheck2(i,j)[0]+1][getnearestcheck2(i,j)[1]-1].getEmpty() == true){
                                return true;
                            }
                        }
                        else if ((getnearestcheck3(i,j)[1] <=6) & (getnearestcheck3(i,j)[0] <=7) & (getnearestcheck3(i,j)[0] >0)){
                            if (cells[getnearestcheck3(i,j)[0]-1][getnearestcheck3(i,j)[1]+1].getEmpty() == true){
                                return true;
                            }
                        }
                        else if ((getnearestcheck4(i,j)[0] <=7) & (getnearestcheck4(i,j)[0] >0) & (getnearestcheck4(i,j)[1] <=7) & (getnearestcheck4(i,j)[1] >0)){
                            if (cells[getnearestcheck4(i,j)[0]-1][getnearestcheck4(i,j)[1]-1].getEmpty() == true){
                                return true;
                            }
                }

            }
        }
        else if (cells[i][j].getKing() == false){
            if ((i+2<=7) &(j+2)<=7){
                if ((cells[i+1][j+1].getOpponentChecker() == true) & (cells[i+2][j+2]).getEmpty() == true){
                    return true;
                }
            }
            if ((i+2<=7) &(j-2)>=0){
                if ((cells[i+1][j-1].getOpponentChecker() == true) & (cells[i+2][j-2]).getEmpty() == true){
                    return true;
                }
            }
            if ((i-2>=0) &(j+2)<=7){
                if ((cells[i-1][j+1].getOpponentChecker() == true) & (cells[i-2][j+2]).getEmpty() == true){
                    return true;
                }
            }
            if ((i-2>=0) &(j-2)>=0){
                if ((cells[i-1][j-1].getOpponentChecker() == true) & (cells[i-2][j-2]).getEmpty() == true){
                    return true;
                }
            }
        }
        return false;
    }



    public boolean findturns(){
        for(int i=0;i<NUMBERROWS;i++){
            for(int j=0;j<NUMBERCOLUMNS;j++){
                    if (eatmarker(i,j) == true){
                        return true;
                    }
                }
                }
        return false;
    }



    public int[] getnearestcheck1(int x, int y){
        while ((x <=7) &(y <=7)){
            if (cells[x+1][y+1].getOpponentChecker() == true){
                return new int[] {x+1, y+1} ;
            }
            else if (cells[x+1][y+1].getMyChecker()==true){
                return new int[] {99, 99} ;
            }
            else {
                x++;
                y++;
            }
        }
        return new int[] {99,99};
    }
    public int[] getnearestcheck2(int x, int y){
        while ((x <=7) &(y >=0)){
            if (cells[x+1][y-1].getOpponentChecker() == true){
                return new int[] {x+1, y-1} ;
            }
            else if (cells[x+1][y-1].getMyChecker()==true) {
                return new int[]{99, 99};
            }
            else {
                x++;
                y--;
            }

        }
        return new int[] {99,99};
    }

    public int[] getnearestcheck3(int x, int y){
        while ((x >=0) &(y <=7)){
            if (cells[x-1][y+1].getOpponentChecker() == true){
                return new int[] {x-1, y+1} ;
            }
            else if (cells[x-1][y+1].getMyChecker()==true) {
                return new int[] {99, 99};
            }
            else {
                x--;
                y++;
            }
        }
        return new int[] {99,99};
    }

    public int[] getnearestcheck4(int x, int y){
        while ((x >= 0) &(y >= 0)){
            if (cells[x-1][y-1].getOpponentChecker() == true){
                return new int[] {x-1, y-1} ;
            }
            else if (cells[x-1][y-1].getMyChecker()==true) {
                return new int[] {99, 99};
            }
            else {
                x--;
                y--;
            }
        }
        return new int[] {99,99};
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

    public void addListener(ActionListener a, int i, int j) {
        gf.getButtons()[i][j].addActionListener(a);
    }

    public void addListenerConcede(ActionListener a) {
        gf.getConcedeButton().addActionListener(a);
    }

    public void addListenerDraw(ActionListener a){
        gf.getDrawButton().addActionListener(a);
    }

    public void setColoredYellow(){
        for (int i=0;i<8;i++){
            for(int j = 0;j<8;j++){
                if (cells[i][j].isColored()){
                    gf.setYellow(i,j);
                }
                else {
                }
            }
        }
    }

    public void setCheckers(){
        for (int i=0;i<8;i++){
            for(int j = 0;j<8;j++){
                if (cells[i][j].getMyChecker()){
                    gf.setMyChecker(i,7-j);
                }
                else if (cells[i][j].getOpponentChecker()){
                    gf.setOpponentCHecker(i,7-j);
                }
            }
        }
    }

    public int[] getChecked(){
        for (int k=0;k<8;k++) {
            for (int l = 0; l < 8; l++) {
                if (cells[k][l].isChecked()){
                    return new int[] {k,l};
                }
            }
        }
        return new int[] {99,99};
    }

    public void draw(){
        gf.setBasicColors();
        setColoredYellow();
        setCheckers();
    }

    public void actionButton(int i, int j){
        boolean eat = false;
        for (int k=0;k<8;k++){
            for (int l=0;l<8;l++){
                if (eatmarker(l,k)){
                    System.out.println(k);
                    System.out.println(l);
                    eat = true;
                }
            }
        }

        if (eat){
            System.out.println("Hello");
        }
        else {
            if (cells[7 - i][7 - j].getTurned() == false) {
                availableturns(cells[7 - i][7 - j]);
                cells[7-i][7-j].setChecked(true);
                draw();
            } else if (cells[7 - i][7 - j].getTurned()) {
                if (cells[7 - i][7 - j].isColored()) {
                    System.out.println("He");
                    cells[getChecked()[0]][getChecked()[1]].setEmpty(true);
                    cells[7-i][7-j].setMyChecker(true);
                    draw();
                }
            }
        }
}
}
