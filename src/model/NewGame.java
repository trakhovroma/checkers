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

            try {
                server = new Server();
                opponent_name = server.sendName(st.getString());

            }
            catch(IOException e){
                e.printStackTrace();
                st.showmessage("smth went wrong");
                System.exit(255);
            }
            st.dispose();
            model.Game game = new model.Game(st.getString(),opponent_name);
            view.GameFrame gf = new view.GameFrame(game);
            controller.Game g = new controller.Game(game,gf);
            game.startServer();
        }
    }


    public void clientStart(){
        if (st.getString().equals("")) {
            st.showmessage("You have to input name");
        } else {

            try {
                client = new Client("localhost","4567");
                opponent_name = client.sendName(st.getString());
            }
            catch(IOException e){
                e.printStackTrace();
                st.showmessage("smth went wrong");
                System.exit(255);
            }
            st.dispose();
            model.Game game = new model.Game(st.getString(),opponent_name);
            view.GameFrame gf = new view.GameFrame(game);
            controller.Game g = new controller.Game(game,gf);
            game.startClient();
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
