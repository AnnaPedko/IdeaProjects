package com.annakhorolets.programm;

import com.annakhorolets.programm.UI.Controller;
import com.annakhorolets.programm.UI.UI;
import com.annakhorolets.programm.dao.ContactDao;
import com.annakhorolets.programm.dao.impl.DBContactDao;
import com.annakhorolets.programm.services.ContactService;
import com.annakhorolets.programm.services.impl.ContactServiceImpl;

import javax.swing.*;

public class GUI
{
    public static void start()
    {
        ContactDao contactDao = new DBContactDao();
        ContactService contactService = new ContactServiceImpl(contactDao);

        JFrame frame = new JFrame("UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UI ui = new UI();
        frame.add(ui);

        Controller controller = new Controller(ui, contactService);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        start();
    }
}
