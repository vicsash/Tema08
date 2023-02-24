package com.victorsashnev.tema08.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main {
    //JTextField
    public static void main(String [] args){
        //Making the display
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        JFrame display = new JFrame();
        display.setSize(500,500);
        display.setLayout(new BorderLayout());

        Calculator calculator = new Calculator();
        //Making the screen panel and centering it
        JPanel screen = new JPanel();
        screen.setLayout(new FlowLayout(FlowLayout.RIGHT));
        screen.setPreferredSize(new Dimension(50,50));


        //Making the numbers for the calculator screen
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(5,4));

        JLabel calculatorScreen = new JLabel("SCREEN",JLabel.RIGHT);
        final StringBuilder[] sb = {new StringBuilder()};
        screen.add(calculatorScreen);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button =(JButton) e.getSource();
                calculatorScreen.setText(calculator.addSymbol(button.getText().charAt(0)));
            }
        };

        final String[] textButtons= new String[]{"Off","On","CE","/",
                "7","8","9","x",
                "4","5","6","-",
                "1","2","3","+",
                "0",".","%","="};





        for(int i = 0; i< textButtons.length;i++){
            JButton button2 = new JButton(textButtons[i]);
            keys.add(button2);
            button2.addActionListener(listener);
        }

        display.getContentPane().add(screen,BorderLayout.NORTH);
        display.getContentPane().add(keys,BorderLayout.CENTER);

        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);
    }

}
