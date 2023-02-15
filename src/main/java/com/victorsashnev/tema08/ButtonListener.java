package com.victorsashnev.tema08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Seha hecho click, en boton" + e.getSource());
    }
}
