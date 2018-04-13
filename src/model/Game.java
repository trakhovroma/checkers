package model;


import view.GameFrame;
import view.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;

public class Game {
    public static final int NUMBERROWS = 8;
    public static final int NUMBERCOLUMNS = 8;

    private Cell[][] cells;
    private Server server= null;
    private Client client =null;
    private boolean isServer;
    private String message = "no_mes";
    private String myname;
    private String opponentname;

    public Game(String my_name, boolean isServer1){
        isServer = isServer1;
        myname = my_name;
        cells = new Cell[NUMBERROWS][NUMBERCOLUMNS];
        fillcells();
        if (isServer){
            if (myname.equals("")){
                int num = ThreadLocalRandom.current().nextInt(1, 100);
                myname = "AnonymousStranger"+Integer.toString(num);
                setMessage("You haven't input your name, that's why you are AnonymousStranger" + Integer.toString(num));
            }
            else {
                try {
                    server = new Server();
                    opponentname = server.sendName(my_name);
                } catch (IOException e) {
                    e.printStackTrace();
                    setMessage("smth went wrong");
                    System.exit(255);
                }
            }
        }
        else if (isServer == false){
            if (my_name.equals("")){
                int num = ThreadLocalRandom.current().nextInt(1, 100);
                myname = "AnonymousStranger"+Integer.toString(num);
                setMessage("You haven't input your name, that's why you are AnonymousStranger" + Integer.toString(num));
            }
            else {
                try {
                    client = new Client("localhost", "4567");
                    opponentname = client.sendName(my_name);
                } catch (IOException e) {
                    e.printStackTrace();
                    setMessage("smth went wrong");
                    System.exit(255);
                }
            }
        }
        for (int i =0;i<8;i++){
            for (int j=0;j<8;j++){
                if (cells[i][j].getOpponentChecker()){
                    cells[i][j].setOpponentChecker(false);
                }
            }
        }

        cells[2][4].setOpponentChecker(true);
        cells[2][6].setOpponentChecker(true);
        cells[5][5].setOpponentChecker(true);
    }


    private void fillcells(){
        for(int i=0;i<NUMBERROWS;i++){
            for(int j=0;j<NUMBERCOLUMNS;j++){
                cells[i][j]= new Cell(i,j);
            }
        }
    }

    public void availableturns(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        if (cell.getMyChecker()) {
            if (eatmarker(x, y)) {
                if (cell.getKing()) {
                    if ((getnearestcheck1(x, y)[0] <= 6) & (getnearestcheck1(x, y)[1] <= 6)) {
                        if (cells[getnearestcheck1(x, y)[0] + 1][getnearestcheck1(x, y)[1] + 1].getEmpty() == true) {
                            cells[getnearestcheck1(x, y)[0] + 1][getnearestcheck1(x, y)[1] + 1].setColored(true);
                        }
                    } else if ((getnearestcheck2(x, y)[0] <= 6) & (getnearestcheck2(x, y)[1] <= 7) & (getnearestcheck2(x, y)[1] > 0)) {
                        if (cells[getnearestcheck2(x, y)[0] + 1][getnearestcheck2(x, y)[1] - 1].getEmpty() == true) {
                            cells[getnearestcheck2(x, y)[0] + 1][getnearestcheck2(x, y)[1] - 1].setColored(true);
                        }
                    } else if ((getnearestcheck3(x, y)[1] <= 6) & (getnearestcheck3(x, y)[0] <= 7) & (getnearestcheck3(x, y)[0] > 0)) {
                        if (cells[getnearestcheck3(x, y)[0] - 1][getnearestcheck3(x, y)[1] + 1].getEmpty() == true) {
                            cells[getnearestcheck3(x, y)[0] - 1][getnearestcheck3(x, y)[1] + 1].setColored(true);
                        }
                    } else if ((getnearestcheck4(x, y)[0] <= 7) & (getnearestcheck4(x, y)[0] > 0) & (getnearestcheck4(x, y)[1] <= 7) & (getnearestcheck4(x, y)[1] > 0)) {
                        if (cells[getnearestcheck4(x, y)[0] - 1][getnearestcheck4(x, y)[1] - 1].getEmpty() == true) {
                            cells[getnearestcheck4(x, y)[0] - 1][getnearestcheck4(x, y)[1] - 1].setColored(true);
                        }
                    }
                }
                else if (cell.getKing()==false){
                    if ((x + 2 <= 7) & (y + 2) <= 7) {

                        if ((cells[x + 1][y + 1].getOpponentChecker() == true) & (cells[x + 2][y + 2]).getEmpty() == true) {
                            cells[x + 2][y + 2].setColored(true);
                        }
                    }
                    if ((x + 2 <= 7) & (y - 2) >= 0) {

                        if ((cells[x + 1][y - 1].getOpponentChecker() == true) & (cells[x + 2][y - 2]).getEmpty() == true) {
                            cells[x + 2][y - 2].setColored(true);
                        }
                    }
                    if ((x - 2 >= 0) & (y + 2) <= 7) {

                        if ((cells[x - 1][y + 1].getOpponentChecker() == true) & (cells[x - 2][y + 2]).getEmpty() == true) {
                            cells[x - 2][y + 2].setColored(true);
                        }
                    }
                    if ((x - 2 >= 0) & (y - 2) >= 0) {

                        if ((cells[x - 1][y - 1].getOpponentChecker() == true) & (cells[x - 2][y - 2]).getEmpty() == true) {
                            cells[x - 2][y - 2].setColored(true);
                        }
                    }
                }
            } else if (eatmarker(x, y) == false) {

                if (cell.getKing() == false) {
                    if ((x <= 6) & (y <= 6)) {
                        if (cells[x + 1][y + 1].getEmpty()) {
                            cells[x + 1][y + 1].setColored(true);
                        }
                    }
                    if ((x > 0) & (y <= 6)) {
                        if (cells[x - 1][y + 1].getEmpty()) {
                            cells[x - 1][y + 1].setColored(true);
                        }
                    }

                } else if (cell.getKing() == true) {
                    int i = cell.getX();
                    int j = cell.getY();
                    while ((i <= 6) & (j <= 6)) {
                        if (cells[i + 1][j + 1].getEmpty()) {
                            cells[i + 1][j + 1].setColored(true);
                            i++;
                            j++;
                        }
                        else{
                            i+=100;
                            y+=100;
                        }
                    }
                    i = cell.getX();
                    j = cell.getY();

                    while ((i >= 1) & (j <= 6)) {
                        if (cells[i - 1][j + 1].getEmpty()) {
                            cells[i - 1][j + 1].setColored(true);
                            i--;
                            j++;
                        }
                        else {
                            i-=100;
                            j+=100;
                        }
                    }
                    i = cell.getX();
                    j = cell.getY();
                    while ((i <= 6) & (j >= 1)) {
                        if (cells[i + 1][j - 1].getEmpty()) {
                            cells[i + 1][j - 1].setColored(true);
                            i++;
                            j--;
                        }
                        else{
                            i+=100;
                            j-=100;
                        }
                    }
                    i = cell.getX();
                    j = cell.getY();
                    while ((i >= 1) & (j >= 1)) {
                        if (cells[i - 1][j - 1].getEmpty()) {
                            cells[i - 1][j - 1].setColored(true);
                            i--;
                            j--;
                        }
                        else {
                            i-=100;
                            j-=100;
                        }
                    }
                }
            }
        }
        else{
            setMessage("Select your own checker");
            System.out.println("Select your own checker");
        }
    }



    public boolean eatmarker(int i,int j){

        if (cells[i][j].getMyChecker() == true) {
            if (cells[i][j].getKing() == true) {
                if ((getnearestcheck1(i, j)[0] <= 6) & (getnearestcheck1(i, j)[1] <= 6)) {
                    if (cells[getnearestcheck1(i, j)[0] + 1][getnearestcheck1(i, j)[1] + 1].getEmpty() == true) {
                        return true;
                    }
                } else if ((getnearestcheck2(i, j)[0] <= 6) & (getnearestcheck2(i, j)[1] <= 7) & (getnearestcheck2(i, j)[1] > 0)) {
                    if (cells[getnearestcheck2(i, j)[0] + 1][getnearestcheck2(i, j)[1] - 1].getEmpty() == true) {
                        return true;
                    }
                } else if ((getnearestcheck3(i, j)[1] <= 6) & (getnearestcheck3(i, j)[0] <= 7) & (getnearestcheck3(i, j)[0] > 0)) {
                    if (cells[getnearestcheck3(i, j)[0] - 1][getnearestcheck3(i, j)[1] + 1].getEmpty() == true) {
                        return true;
                    }
                } else if ((getnearestcheck4(i, j)[0] <= 7) & (getnearestcheck4(i, j)[0] > 0) & (getnearestcheck4(i, j)[1] <= 7) & (getnearestcheck4(i, j)[1] > 0)) {
                    if (cells[getnearestcheck4(i, j)[0] - 1][getnearestcheck4(i, j)[1] - 1].getEmpty() == true) {
                        return true;
                    }
                }

            } else if (cells[i][j].getKing() == false) {
                if ((i + 2 <= 7) & (j + 2) <= 7) {

                    if ((cells[i + 1][j + 1].getOpponentChecker() == true) & (cells[i + 2][j + 2]).getEmpty() == true) {
                        return true;
                    }
                }
                if ((i + 2 <= 7) & (j - 2) >= 0) {

                    if ((cells[i + 1][j - 1].getOpponentChecker() == true) & (cells[i + 2][j - 2]).getEmpty() == true) {
                        return true;
                    }
                }
                if ((i - 2 >= 0) & (j + 2) <= 7) {

                    if ((cells[i - 1][j + 1].getOpponentChecker() == true) & (cells[i - 2][j + 2]).getEmpty() == true) {
                        return true;
                    }
                }
                if ((i - 2 >= 0) & (j - 2) >= 0) {

                    if ((cells[i - 1][j - 1].getOpponentChecker() == true) & (cells[i - 2][j - 2]).getEmpty() == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getMyname() {
        return myname;
    }

    public String getOpponentname() {
        return opponentname;
    }

    public int[] getnearestcheck1(int x, int y){
        while ((x <=6) &(y <=6)){
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
        while ((x <=6) &(y >0)){
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
        while ((x >0) &(y <=6)){
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
        while ((x > 0) & (y > 0)){
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
    public void startServer(){

    }

    public void startClient(){

    }

    public void serverTurn(){
        System.out.println("Your turn");
    }

    public void ClientTurn(){
    }

    public void setStatus(String s) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (s.charAt(8*i+j)=='2'){
                    cells[i][j].setOpponentChecker(false);
                    cells[i][j].setMyChecker(true);

                }
                else if (s.charAt(8*i+j)=='1'){
                    cells[i][j].setMyChecker(false);
                    cells[i][j].setOpponentChecker(true);
                }
                else if (s.charAt(8*i+j)=='0'){
                    cells[i][j].setEmpty(true);
                }
                else {
                    System.out.println("HELLO, MY FRIEND");
                }
            }
        }
    }

    public String getStatus(){
        String s = "";
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (cells[i][j].getMyChecker()){
                    s+='1';
                }
                else if (cells[i][j].getOpponentChecker()){
                    s+='2';
                }
                else{
                    s+='0';
                }
            }
        }
        return s;
    }

    public void setOffColored(){
        for (int i=0;i<8;i++){
            for(int j = 0;j<8;j++) {
                cells[i][j].setColored(false);
                cells[i][j].setTurned(false);
                cells[i][j].setChecked(false);
                cells[i][j].setTurned(false);
            }
            }
    }

    public Cell[][] getCells() {
        return cells;
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


    public boolean checkeat(){
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
        return eat;
    }

    public void eat(int i,int j){
        if (eatmarker(i,j)){
            setOffColored();
            availableturns(cells[i][j]);
            cells[i][j].setChecked(true);
            metamorphosis();
        }
        else {
            System.out.println("nothing to eat");
        }
    }

    public void metamorphosis(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((cells[i][j].getMyChecker())&(j ==7)){
                    cells[i][j].setKing(true);
                }
            }
        }
    }

    public void actionButton(int i,int j){
        if (isServer == true) {

            action(i, j);
        }
        else if (isServer ==false){

        }
    }


    public void action(int i, int j){
        setMessage("no_mes");
        if (checkeat()){
            if (cells[7 - i][7 - j].isColored() == false){
                if (eatmarker(7-i,7-j) ==true){
                    setOffColored();
                    availableturns(cells[7 - i][7 - j]);
                    cells[7-i][7-j].setChecked(true);
                    metamorphosis();
                }
                else{
                    setMessage("You need to eat");
            }
            }
            else{
                if (cells[getChecked()[0]][getChecked()[1]].getKing()){
                    cells[7-i][7-j].setKing(true);
                }
                cells[getChecked()[0]][getChecked()[1]].setMyChecker(false);
                cells[7-i -(7-i-getChecked()[0])/abs(7-i-getChecked()[0])][7-j -(7-j-getChecked()[1])/abs(7-j-getChecked()[1])].setOpponentChecker(false);
                cells[7-i][7-j].setMyChecker(true);
                setOffColored();
                metamorphosis();
                eat(7-i,7-j);
            }

        }
        else {
            if (cells[7 - i][7 - j].isColored() == false) {
                setOffColored();
                availableturns(cells[7 - i][7 - j]);
                cells[7-i][7-j].setChecked(true);
                metamorphosis();
            } else if (cells[7 - i][7 - j].isColored()) {
                if (cells[getChecked()[0]][getChecked()[1]].getKing()){
                    cells[7-i][7-j].setKing(true);
                }
                cells[getChecked()[0]][getChecked()[1]].setMyChecker(false);
                cells[7-i][7-j].setMyChecker(true);

                setOffColored();
                metamorphosis();
            }
        }
}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
