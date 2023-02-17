package com.victorsashnev.tema08;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    //JTextField
    public static void main(String [] args){
        //Making the display
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        JFrame display = new JFrame();
        display.setLayout(new BorderLayout());

        //Making the screen panel and centering it
        JPanel screen = new JPanel();
        screen.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Making the numbers for the calculator screen
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(5,4));

        JLabel button = new JLabel("SCREEN");

        screen.add(button);
        //display.add(screen);
        //display.add(keys);
        for(int i = 0; i<20;i++){
            JButton button2 = new JButton("KeyButtons" + i);
            keys.add(button2);
        }

        display.getContentPane().add(screen,BorderLayout.NORTH);
        display.getContentPane().add(keys,BorderLayout.CENTER);

        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);
    }
}
