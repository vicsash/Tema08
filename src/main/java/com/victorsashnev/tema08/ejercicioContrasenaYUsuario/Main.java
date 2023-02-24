package com.victorsashnev.tema08.ejercicioContrasenaYUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setSize(700,400);
        frame.setLayout(new BorderLayout());

        JPanel screen = new JPanel();
        screen.setLayout( new FlowLayout());

        JPanel inputData = new JPanel();
        inputData.setLayout(new GridLayout(2,2));

        JPanel pressButon = new JPanel();

        JLabel userName = new JLabel("User name");
        JTextField tfUserName = new JTextField(30);
        JLabel password = new JLabel("Password");
        JPasswordField tfPassword = new JPasswordField(30);
        screen.add(inputData);
        inputData.add(userName);
        inputData.add(tfUserName);
        inputData.add(password);
        inputData.add(tfPassword);

        JButton button = new JButton("Log in ");
        screen.add(pressButon);
        pressButon.add(button);
        frame.setContentPane(screen);




        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyWords = new String(tfPassword.getPassword());
                JOptionPane.showMessageDialog(screen,"You have logged in " + keyWords);
            }
        });


        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
