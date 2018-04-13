package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExtraFrames extends JFrame {
    private JButton yes;
    private JButton no;
    private JFrame frame;

    public void Concede() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(300, 180);
        JLabel label = new JLabel("Concede?");
        label.setBounds(100,20,200,50);
        Font font = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 22);
        label.setFont(font);
        yes = new JButton("Yes");
        yes.setBounds(30,80,100,40);
        no = new JButton("No");
        no.setBounds(170,80,100,40);

        frame.add(label);
        frame.add(yes);
        frame.add(no);
        frame.setBackground(Color.BLUE);
        frame.setLayout(null);

        yes.addActionListener(new ExtraFrames.CloseGame());
        no.addActionListener(new ExtraFrames.DoNothing());

        frame.setVisible(true);
    }
    private class CloseGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private class DoNothing implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
}
