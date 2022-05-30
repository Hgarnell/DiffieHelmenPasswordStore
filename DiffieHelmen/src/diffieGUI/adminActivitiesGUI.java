/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanna
 */
public class adminActivitiesGUI extends JPanel {

    private JPanel buttonPanel, tablePanel;
    public JTable passTable, userTable;
    private JLabel jlabel, jlabel2, jlable3;
    public JButton add, remove, logout, delUser;
    private JScrollPane scrollPane, scrollPane2;
    public String[][] dataPass, dataUser;
    public String[] column, column2;
    public DefaultTableModel userModel, passModel;

    public adminActivitiesGUI() {
        super();
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.jlabel = new JLabel("Passwords");
        this.jlabel2 = new JLabel("Current Users");
        this.jlable3 = new JLabel("CTRL+CLICK to deselect a row");
        this.tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(this.tablePanel, BoxLayout.PAGE_AXIS));

        dataPass = new String[2][3];
        String columnPass[] = {"PASSID", "username", "password"};
        column = columnPass;
        this.passModel = new DefaultTableModel(dataPass, column);
        this.passTable = new JTable(passModel);
        passTable.setBounds(30, 40, 100, 200);
        passTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        passTable.setDefaultEditor(Object.class, null);

        dataUser = new String[1][2];
        String[] userColumns = {"Admin?", "username"};
        column2 = userColumns;
        this.userModel = new DefaultTableModel(dataUser, column2);
        this.userTable = new JTable(userModel);
        userTable.setBounds(30, 40, 100, 200);
        userTable.setDefaultEditor(Object.class, null);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.scrollPane2 = new JScrollPane(userTable);
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.scrollPane = new JScrollPane(passTable);
        this.scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.tablePanel.add(jlabel);
        this.tablePanel.add(scrollPane);
        this.tablePanel.add(jlabel2);

        this.tablePanel.add(scrollPane2);
        this.tablePanel.add(jlable3);
        this.add(tablePanel, BorderLayout.CENTER);

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        this.add = new JButton("Add Password");
        this.remove = new JButton("Remove Password");
        this.delUser = new JButton("Remove User");

        this.logout = new JButton("Logout");

        this.buttonPanel.add(logout);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        this.buttonPanel.add(add);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        this.buttonPanel.add(remove);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        this.buttonPanel.add(delUser);

        this.buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttonPanel, BorderLayout.EAST);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        adminActivitiesGUI k = new adminActivitiesGUI();
        k.setVisible(true);
    }

}
