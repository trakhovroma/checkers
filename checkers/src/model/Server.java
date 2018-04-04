package model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader inu;
    private ServerSocket servers;
    private Socket fromclient;

    public Server(JFrame frame) throws IOException {

        //System.out.println("Welcome to Server side");
        in = null;
        out = null;

        servers = null;
        fromclient = null;

        // create server socket
        try

        {servers = create(new int[] {4567,7654,8904,4567,8765});
        } catch(IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "smth went wrong");
        }

        try
        {
            JOptionPane.showMessageDialog(frame, "Server runned, waiting your opponent");
            System.out.println("listening on port: " + servers.getLocalPort());
            fromclient = servers.accept();
            JOptionPane.showMessageDialog(frame, "Opponent connected");
        } catch(IOException e)

        {
            JOptionPane.showMessageDialog(frame, "Can't accept");
        }
        in  = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
        out =new PrintWriter(fromclient.getOutputStream(),true);

    }
    public void closeSocket(){
        try {
            fromclient.close();
            servers.close();
            in.close();
            out.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("smth went wrong");
        }
    }

    public int serverSend(int coord) throws IOException {
        out.println(Integer.toString(coord));
        String input = in.readLine();
        return Integer.parseInt(input);
    }
    public void serverSendLast(int coord) throws IOException {
        out.println(Integer.toString(coord));
    }
    public String sendName(String name) throws IOException{
        out.println(name);
        String input = in.readLine();
        return input;
    }
    public ServerSocket create(int[] ports) throws IOException {
        for (int port : ports) {
            try {
                return new ServerSocket(port);
            } catch (IOException ex) {
                continue; // try next port
            }
        }

        // if the program gets here, no port in the range was found
        throw new IOException("no free port found");
    }
}