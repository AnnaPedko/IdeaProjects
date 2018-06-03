package com.annakhorolets.programm.UI;

import com.annakhorolets.programm.model.Contact;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
    public Controller(UI ui)
    {
        ui_ = ui;
        bind();
    }

    private void bind()
    {
        ui_.setOnAddClicked((ActionEvent e) ->
        {
            JOptionPane.showMessageDialog(null, "Add clicked");

        });

        ui_.setOnEditClicked((ActionEvent e) ->
        {
            JOptionPane.showMessageDialog(null, "Edit clicked");

        });

        ui_.setOnRemoveClicked((ActionEvent e) ->
        {
            JOptionPane.showMessageDialog(null, "Remove clicked");

        });

        Integer[][] data = {{1,2,3}, {4,5,6}};
        String[] columnNames = {"Id", "Name","Age"};
        ui_.setTableData(data, columnNames);
    }


    private UI ui_;
}
