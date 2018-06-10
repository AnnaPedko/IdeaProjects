package com.annakhorolets.programm.UI;

import com.annakhorolets.programm.Validator.ValidatorFactory;
import javafx.geometry.HorizontalDirection;

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

    JTextField idField = new JTextField(5);
    JTextField nameField = new JTextField(5);
    JTextField ageField = new javax.swing.JTextField(5);
    String message = "Enter Name and Age Values";
    JPanel addPanel = new JPanel();
    JPanel addWarningPanel = new JPanel();
    JPanel editWarningPanel = new JPanel();
    JPanel editPanel = new JPanel();

    public  JPanel createDialog()
    {

        if (null != addPanel)
        {
            addPanel.removeAll();
        }

        addPanel.add(new JLabel("Name:"));
        addPanel.add(nameField);
        nameField.setText("");
        addPanel.add(Box.createHorizontalStrut(15)); // a spacer
        addPanel.add(new JLabel("Age:"));
        addPanel.add(ageField);
        ageField.setText("");
        nameField.setHorizontalAlignment(SwingConstants.CENTER);

        return addPanel;
    }

    public  JPanel createWarningDialog()
    {

        if (null != addWarningPanel)
        {
            addWarningPanel.removeAll();
        }
        JLabel warningLabel = new JLabel("Name or Age are incorrect:");
        addWarningPanel.add(warningLabel);
        warningLabel.setHorizontalAlignment(SwingConstants.LEADING);
        warningLabel.setForeground(Color.red);
        addWarningPanel.add(new JLabel("Name:"));
        addWarningPanel.add(nameField);
        addWarningPanel.add(Box.createHorizontalStrut(15)); // a spacer
        addWarningPanel.add(new JLabel("Age:"));
        addWarningPanel.add(ageField);

        return addWarningPanel;
    }

    public  JPanel createEditWarningDialog()
    {
        if (null != editWarningPanel)
        {
            editWarningPanel.removeAll();
        }
        JLabel warningLabel = new JLabel("Name or Age are incorrect:");
        editWarningPanel.add(warningLabel);
        warningLabel.setHorizontalAlignment(SwingConstants.LEADING);
        warningLabel.setForeground(Color.red);
        editWarningPanel.add(new JLabel("Id"));
        editWarningPanel.add(idField);
        idField.setEditable(false);
        editWarningPanel.add(new JLabel("Name:"));
        editWarningPanel.add(nameField);
        editWarningPanel.add(Box.createHorizontalStrut(15)); // a spacer
        editWarningPanel.add(new JLabel("Age:"));
        editWarningPanel.add(ageField);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);

        return editWarningPanel;
    }

    public  JPanel createEditDialog()
    {
        if (null != editPanel)
        {
            editPanel.removeAll();
        }
        editPanel.add(new JLabel("Id"));
        editPanel.add(idField);
        idField.setEditable(false);
        editPanel.add(new JLabel("Name:"));
        editPanel.add(nameField);
        editPanel.add(Box.createHorizontalStrut(15)); // a spacer
        editPanel.add(new JLabel("Age:"));
        editPanel.add(ageField);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);

        return editPanel;
    }

   public void setId(String text)
   {
       idField.setText(text);
   }

   public void setName(String text)
   {
        nameField.setText(text);
   }

   public void setAge(String text)
   {
        ageField.setText(text);
   }

    public String getName()
    {
        return nameField.getText();
    }

    public String getAge()
    {
        return ageField.getText();
    }

    public int showDialog()
    {
        return JOptionPane.showConfirmDialog(null, createDialog(), message, JOptionPane.OK_CANCEL_OPTION);
    }

    public int showWarningDialog()
    {

        return JOptionPane.showConfirmDialog(null, createWarningDialog(),
                message, JOptionPane.OK_CANCEL_OPTION);
    }

    public int showEditDialog()
    {
        return JOptionPane.showConfirmDialog(null, createEditDialog(), message, JOptionPane.OK_CANCEL_OPTION);
    }

    public int showEditWarningDialog()
    {
        return JOptionPane.showConfirmDialog(null, createEditWarningDialog(), message, JOptionPane.OK_CANCEL_OPTION);
    }


    }
