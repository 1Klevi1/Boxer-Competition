package bcompetition.View;

import bcompetition.Model.KABoxer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserDetails extends JPanel {

    // Table for user data
    private JTable userTable;
    // table column
    private String[] userTableColumn = {"FIRST NAME", "LAST NAME"};

    // back button
    private JButton backButton;

    public UserDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        userTable = new JTable();
        // scroll bar for table
        JScrollPane userTableScroll = new JScrollPane(userTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);
    }

    // gets users from database and loads to table
    public void getUsers(ArrayList<KABoxer> participants) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) userTable.getModel();
        defaultTableModel.setColumnIdentifiers(userTableColumn);
        System.out.println("getUsers");

        int i = 0;
        while(i < participants.size()) {
            String row = participants.get(i).toString().trim();
            System.out.println(row);
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
