package model;

public class Cell {
    private boolean empty;
    private boolean opponent_checker;
    private boolean my_checker;
    private boolean active;
    private int x;
    private int y;
    private boolean king;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.king = false;
        if((x+y) % 2 ==0){
            this.active = true;
        }
        else {
            this.active = false;
        }
        if ((this.active == true) &(this.y <=3)){
            this.my_checker = true;
        }
        else{
            this.my_checker=false;
        }

        if ((this.active == true) &(this.y >=6)){
            this.opponent_checker = true;
        }
        else{
            this.opponent_checker = false;
        }
        if ((this.active == true) &(this.y >=4) & (this.y <=5)){
            this.empty = true;
        }
        else{
            this.empty = false;
        }
    }

    public boolean getActive(){
        return active;
    }
    public boolean getEmpty(){
        return empty;
    }
    public boolean getMyChecker(){
        return my_checker;
    }
    public boolean getOpponentChecker(){
        return opponent_checker;
    }
    public boolean getKing(){
        return king;
    }
}
