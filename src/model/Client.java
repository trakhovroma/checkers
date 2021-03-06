package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket fromserver;

    public Client(String ip, String port) throws IOException {

        fromserver = null;

        try {
            System.out.println(port);
            fromserver = new Socket(ip, Integer.valueOf(port));
        }
        catch(ConnectException e){
            e.printStackTrace();
        }
        out =new PrintWriter(fromserver.getOutputStream(),true);
        in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
    }

    public void closeSocket() throws IOException{
        fromserver.close();
        out.close();
        in.close();
    }
    public String clientReceive() throws IOException{
        String input = in.readLine();
        return input;
    }

    public String clientSend(String s) throws IOException {
        out.println(s);
        String input = in.readLine();
        return input;

    }
    public void clientSendLast(String s) throws IOException {
        out.println(s);
    }
    public String sendName(String name) throws IOException{
        String input = in.readLine();
        out.println(name);
        return input;
    }
}