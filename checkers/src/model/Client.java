package model;

import javax.swing.*;
import java.awt.*;
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

    public Client(JFrame frame, String ip, String port) throws IOException {

        System.out.println("Welcome to Client side");
        fromserver = null;
        System.out.println("Connecting to... "+"localhost");
        try {
            System.out.println(port);
            fromserver = new Socket(ip, Integer.valueOf(port));
        }
        catch(ConnectException e){
            JOptionPane.showMessageDialog(frame, "There is no such server");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(frame, "You are connected to server");
        out =new PrintWriter(fromserver.getOutputStream(),true);
        in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
    }

    public void closeSocket() throws IOException{
        fromserver.close();
        out.close();
        in.close();
    }
    public int clientReceive() throws IOException{
        String input = in.readLine();
        return Integer.parseInt(input);
    }

    public int clientSend(int coord) throws IOException {
        out.println(Integer.toString(coord));
        String input = in.readLine();
        return Integer.parseInt(input);

    }
    public void clientSendLast(int coord) throws IOException {
        out.println(Integer.toString(coord));
    }
    public String sendName(String name) throws IOException{
        String input = in.readLine();
        out.println(name);
        return input;
    }
}