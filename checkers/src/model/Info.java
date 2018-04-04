package model;

public class Info {
    public Info(int t, String n){
        this.target = t; // is the user a client or server
        this.name = n;   // user name
    }
    private int target;
    private String name = "Player";

    public void setTarget(int target){
        this.target = target;
    }
    public int getTarget(){
        return this.target;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
