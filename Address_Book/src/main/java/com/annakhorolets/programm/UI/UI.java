package com.annakhorolets.programm.UI;

import com.annakhorolets.programm.Validator.ValidatorFactory;

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

    private JTable addressBookTable = new JTable();

    public UI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.VERTICAL;

        constraints.gridx = 0;
        constraints.gridy = 0;

        add(new JScrollPane(addressBookTable), constraints);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);

        constraints.gridx = 1;
        constraints.gridy = 0;

        add(buttonPanel, constraints);
    }

    public void setOnAddClicked(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void setOnRemoveClicked(ActionListener listener) {
        removeButton.addActionListener(listener);
    }

    public void setOnEditClicked(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void setTableData(Object[][] data, Object[] columnNames) {
        addressBookTable.setModel(new DefaultTableModel(data, columnNames));
    }

    public int getSelectedRow() {
        return addressBookTable.getSelectedRow();
    }

    public Object getValue(int row, int column) {
        return addressBookTable.getValueAt(row, column);
    }


        private static JTextField nameField = new JTextField(5);
        private static JTextField ageField = new javax.swing.JTextField(5);

        public static JPanel createDialog()
        {
            JPanel addPanel = new JPanel();
            addPanel.add(new JLabel("Name:"));
            addPanel.add(nameField);
            addPanel.add(Box.createHorizontalStrut(15)); // a spacer
            addPanel.add(new JLabel("Age:"));
            addPanel.add(ageField);

            return addPanel;
        }

        public static JPanel createWarrningDialog()
        {
            JPanel addPanel = new JPanel();
            addPanel.add(new JLabel("Name or Age are incorrect:"));
            addPanel.add(new JLabel("Name:"));
            addPanel.add(nameField);
            addPanel.add(Box.createHorizontalStrut(15)); // a spacer
            addPanel.add(new JLabel("Age:"));
            addPanel.add(ageField);

            return addPanel;
        }
        public  boolean getContactFields() {
            boolean flag = false;

            int result = JOptionPane.showConfirmDialog(null, createDialog(),
                    "Please Enter Name and Age Values", JOptionPane.OK_CANCEL_OPTION);

            if( result == JOptionPane.OK_OPTION )
            {
                while( ! (validateAge() && validateName()))
                {
                    int res = JOptionPane.showConfirmDialog(null, createWarrningDialog(),
                            "Please Enter Name and Age Values", JOptionPane.OK_CANCEL_OPTION);
                    if (res == JOptionPane.CANCEL_OPTION)
                        return flag;
                }

            flag = true;

            }

         return flag;
        }

        public  boolean  validateName()
        {
            return ValidatorFactory.getValidator("name").validate(nameField.getText());
        }

        public  boolean  validateAge()
        {
            return ValidatorFactory.getValidator("age").validate(ageField.getText());
        }

        public  String getName()
        {
            String name = nameField.getText();

            return name;
        }

        public int getAge() {
            String age = ageField.getText();

            return Integer.parseInt(age);
        }
    }




