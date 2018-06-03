package com.annakhorolets.programm.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UI extends JPanel
    {
        private JButton removeButton = new JButton("Delete");
        private JButton editButton = new JButton("Edit");
        private JButton addButton = new JButton("Add");

        private JTable  addressBookTable = new JTable();

        public UI()
        {
            setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();

            constraints.fill = GridBagConstraints.VERTICAL;

            constraints.gridx     = 0;
            constraints.gridy     = 0;

            add(new JScrollPane(addressBookTable), constraints);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

            buttonPanel.add(addButton);
            buttonPanel.add(editButton);
            buttonPanel.add(removeButton);

            constraints.gridx     = 1;
            constraints.gridy     = 0;

            add(buttonPanel, constraints);
        }

        public void setOnAddClicked(ActionListener listener)
        {
            addButton.addActionListener(listener);
        }

        public void setOnRemoveClicked(ActionListener listener)
        {
            removeButton.addActionListener(listener);
        }

        public void setOnEditClicked(ActionListener listener)
        {
            editButton.addActionListener(listener);
        }

        public void setTableData(Object[][] data, Object[] columnNames)
        {
            addressBookTable.setModel(new DefaultTableModel(data, columnNames));
        }

        public int getSelectedRow()
        {
            return addressBookTable.getSelectedRow();
        }

        public Object getValue(int row, int column)
        {
            return addressBookTable.getValueAt(row, column);
        }

        public void update()
        {
            ((DefaultTableModel)addressBookTable.getModel()).fireTableDataChanged();
        }
    }


