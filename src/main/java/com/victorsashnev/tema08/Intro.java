package com.victorsashnev.tema08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Intro {
        public static void main(String args[]){

            Display display = new Display(800,600,"Hola swing",false);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3,3));

            for(int i = 1; i<=9; i++){
                JButton button = new JButton("Jbutton" + i );
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                panel.add(button);
            }

            display.setContentPane(panel);

        }
}
