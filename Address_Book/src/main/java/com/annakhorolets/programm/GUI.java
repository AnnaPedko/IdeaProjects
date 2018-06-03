package com.annakhorolets.programm;

import com.annakhorolets.programm.UI.Controller;
import com.annakhorolets.programm.UI.UI;

import javax.swing.*;

public class GUI
{
    public static void start()
    {
        JFrame frame = new JFrame("UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //new UI(frame.getContentPane());
        UI ui = new UI();
        frame.add(ui);
        Controller controller = new Controller(ui);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        start();
    }
}
