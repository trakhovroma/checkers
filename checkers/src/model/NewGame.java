package model;

import java.awt.event.ActionListener;
import java.io.IOException;

public class NewGame {
    private view.NewGame st;
    private Server server = null;
    private Client client = null;
    private String opponent_name;

    public NewGame(){
        st = new view.NewGame();
    }

    public void serverStart(){
        if (st.getString().equals("")) {
            st.showmessage("You have to input name");
        }
        else {
            model.Info tr = new model.Info(1,st.getString());

            try {
                server = new Server(st);
                opponent_name = server.sendName(tr.getName());

            }
            catch(IOException e){
                e.printStackTrace();
                st.showmessage("smth went wrong");
                System.exit(255);
            }
            st.dispose();
            model.Game game = new model.Game(st.getString(),opponent_name);
        }
    }


    public void clientStart(){
        if (st.getString().equals("")) {
            st.showmessage("You have to input name");
        } else {
            model.Info tr = new model.Info(0, st.getString());

            try {
                client = new Client(st,"localhost","4567");
                opponent_name = client.sendName(tr.getName());
            }
            catch(IOException e){
                e.printStackTrace();
                st.showmessage("smth went wrong");
                System.exit(255);
            }
            st.dispose();
            model.Game game = new model.Game(st.getString(),opponent_name);
        }
    }
    public void dispose(){ st.dispose(); }
    public void addstartGame2(ActionListener a){
        st.addstartGame2(a);
    }
    public void addstartGame1(ActionListener a){
        st.addstartGame1(a);
    }

}
