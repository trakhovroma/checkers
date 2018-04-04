package model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;


//class for making JTable and show your previous results

public class ReadFile extends AbstractTableModel {
    Vector data;
    Vector columns;

    public ReadFile() {
        String line;
        data = new Vector();
        columns = new Vector();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"/scores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            while (st1.hasMoreTokens())
                columns.addElement(st1.nextToken());
            while ((line = br.readLine()) != null) {
                StringTokenizer st2 = new StringTokenizer(line, " ");
                while (st2.hasMoreTokens())
                    data.addElement(st2.nextToken());
            }
            br.close();
        } catch (IOException e) {
            //create file or just say that file is empty
            e.printStackTrace();
            System.out.println("File is empty");
        }
    }

    public int getRowCount() {
        return data.size() / getColumnCount();
    }

    public int getColumnCount() {
        return columns.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String) data.elementAt((rowIndex * getColumnCount())
                + columnIndex);
    }
    public static void ChangeName(JTable table, int col_index, String col_name){
        table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
    }
    public void maketable(){
        ReadFile model = new ReadFile();
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scrollpane = new JScrollPane(table);
        ChangeName(table,0,"Your Name");
        ChangeName(table,1,"Opponent name");
        ChangeName(table,2,"Result");
        JPanel panel = new JPanel();
        panel.add(scrollpane);
        JFrame frame = new JFrame();
        frame.add(panel, "Center");
        frame.pack();
        frame.setVisible(true);
    }
}