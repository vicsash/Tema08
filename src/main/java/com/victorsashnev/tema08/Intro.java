package com.victorsashnev.tema08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro {
        public static void main(String args[]){

            Display display = new Display(800,600,"Hola swing",false);
            JPanel panel = new JPanel();
            //Since not specified is top left
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            //If comment line above the standart FlowLayout is top center horizontal

            ButtonListener buttonListener = new ButtonListener();

            //Not necessary
            //panel.setLayout(new FlowLayout());
            for (int i =0 ; i < 10;i++){
                //JLabel label1 = new JLabel("Hola Jlabel1" +i);
                //panel.add(label1);
                JButton button = new JButton("Jbutton" + i);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Click");
                    }
                });

                panel.add(button);
            }
            JLabel label2 = new JLabel("Hola Jlabel2");
            //Create lable at position x/y with set parameters
            //label1.setBounds(10,10,200,10);
            //display.getContentPane().add(label1);


            panel.add(label2);
            display.setContentPane(panel);



        }
}
