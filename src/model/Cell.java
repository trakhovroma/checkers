package model;

public class Cell {
    private boolean checked;
    private boolean turned;
    private boolean colored;
    private boolean colored2;
    private boolean empty;
    private boolean opponent_checker;
    private boolean my_checker;
    private boolean active;
    private int x;
    private int y;
    private boolean king;

    public Cell(int x, int y){
        this.checked = false;
        this.turned = false;
        this.colored2 = false;
        this.colored = false;
        this.x = x;
        this.y = y;
        this.king = false;
        if((x+y) % 2 ==0){
            this.active = true;
        }
        else {
            this.active = false;
        }
        if ((this.active == true) &(this.y <=2)){
            this.my_checker = true;
        }
        else{
            this.my_checker=false;
        }

        if ((this.active == true) &(this.y >=5)){
            this.opponent_checker = true;
        }
        else{
            this.opponent_checker = false;
        }
        if ((this.active == true) &(this.y >=3) & (this.y <=4)){
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
    public void setKing(boolean king){
        this.king = king;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isColored() {
        return colored;
    }
    public void setChecked(boolean checked){
        this.checked = checked;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public boolean isChecked() {
        return checked;
    }
    public void setEmpty(boolean empty){
        this.empty=empty;
    }
    public void setMyChecker(boolean my_checker){
        if (my_checker==true) {
            this.my_checker = my_checker;
            this.empty = false;
        }
        else{
            this.my_checker = my_checker;
            this.king = my_checker;
            this.empty = true;
        }
    }
    public void setOpponentChecker(boolean opponent_checker){
        if (opponent_checker) {
            this.opponent_checker = opponent_checker;
            this.empty = false;
        }
        else{
            this.opponent_checker = opponent_checker;
            this.king = opponent_checker;
            this.empty = true;
        }
    }

    public void setTurned(boolean turned) {this.turned = turned;}
    public boolean getTurned(){ return turned;}
    public void setColored2(boolean colored2) {
        this.colored2 = colored2;
    }

}
