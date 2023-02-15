package com.victorsashnev.tema08;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private static final int DEfAULT_WIDTH = 480;
    private static final int DEFAULT_HIEGHT = 320;
    /*public Display(){
        this("");
    }
    public Display(String title){
        this(0,0,title);
    }
    public Display(int x,int y,String title){
        this(x,y,title);
    }*/
    public Display(int x ,int y, String title, boolean maximized){
        this(x,y,DEfAULT_WIDTH,DEFAULT_HIEGHT, title,null,true, maximized);
    }


    public Display(int x ,int y, int width, int hieght, String title, String icon, boolean exitOnClose, boolean maximized){
        //Utilities
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        if(x < 0 && y < 0) {
            Dimension dimension = toolkit.getScreenSize();
            x = Math.round(dimension.width / 2f - width / 2f);
            y = Math.round(dimension.height / 2f - hieght / 2f);
        }
        //Title that appears at the top

        setBounds(x,y,width,hieght);
        if(maximized)
            setExtendedState(Frame.MAXIMIZED_BOTH);
        if(icon!=null) {
            Image IconImage = toolkit.getImage(icon);
            //window.setIconImage(IconImage);
            setIconImage(IconImage);
        }
        //To give a size
        //window.setSize(800,600);
        //window.setLocation(500,400);

        //Not similar to scanner close which is made to save resources
        //Done to close window, if not closed program continues to run
        if(exitOnClose) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
       setVisible(true);

        //Done to make sire that everything is in correct place and correct size

        //window.pack();
    }
}
