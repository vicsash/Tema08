package com.victorsashnev.tema08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator {
    //JTextField
    public static void main(String [] args){
        //Making the display
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        JFrame display = new JFrame();
        display.setLayout(new BorderLayout());

        String[] calculator={"Ce","Off","Sqrt","/",
                "7","8","9","*",
                "4","5","6","-",
                "1","2","3","+",
                "#","0","C","="};

        //Making the screen panel and centering it
        JPanel screen = new JPanel();
        screen.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Making the numbers for the calculator screen
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(5,4));

        JLabel button = new JLabel("SCREEN");
        final StringBuilder[] sb = {new StringBuilder()};
        screen.add(button);
        //display.add(screen);
        //display.add(keys);
        for(int i = 0; i< calculator.length;i++){
            JButton button2 = new JButton(calculator[i]);
            keys.add(button2);


            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button2 =(JButton) e.getSource();
                    System.out.println(button2.getText());
                   sb[0] =sb[0].append(button2.getText());
                    button.setText(Arrays.toString(sb));

                }

            });

        }

        display.getContentPane().add(screen,BorderLayout.NORTH);
        display.getContentPane().add(keys,BorderLayout.CENTER);

        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);
    }
}
