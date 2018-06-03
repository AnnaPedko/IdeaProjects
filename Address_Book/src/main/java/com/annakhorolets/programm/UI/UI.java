package com.annakhorolets.programm.UI;

import java.awt.*;
import javax.swing.*;

public class UI
    {
        public static void createPanelUI(Container container)
        {
            JButton button;
            JTable table;
            
            container.setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();

            constraints.fill = GridBagConstraints.VERTICAL;
            constraints.weightx = 0.5;
            constraints.gridy   = 1  ;

            table = new JTable();

            constraints.gridx     = 0;
            constraints.gridy     = 0;

            container.add(new JScrollPane(table), constraints);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

            button = new JButton("Add");
            buttonPanel.add(button);

            button = new JButton("Edit");
            buttonPanel.add(button);

            button = new JButton("Delete");
            buttonPanel.add(button);

            constraints.gridx     = 1;
            constraints.gridy     = 0;

            container.add(buttonPanel, constraints);
        }

        public static void main(String[] args)
        {
            JFrame frame = new JFrame("UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            createPanelUI(frame.getContentPane());

            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }


