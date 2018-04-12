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

    public Server() throws IOException {

        System.out.println("Welcome to Server side");
        in = null;
        out = null;

        servers = null;
        fromclient = null;

        // create server socket
        try

        {servers = create(new int[] {4567,7654,8904,8765,1234,4321,2345});
        } catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("smth went wrong");
        }

        try
        {
            System.out.println("Server runned, waiting your opponent");
            System.out.println("listening on port: " + servers.getLocalPort());
            fromclient = servers.accept();
            System.out.println("Opponent connected");
        } catch(IOException e)

        {
            System.out.println("Can't accept");
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

    public String serverSend(String s) throws IOException {
        out.println(s);
        String input = in.readLine();
        return input;
    }
    public void serverSendLast(String s) throws IOException {
        out.println(s);
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