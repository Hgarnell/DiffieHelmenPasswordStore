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
import javax.swing.border.EmptyBorder;

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
    public String[][] dataPass;
    public String[][] dataUser;

    public adminActivitiesGUI() {
        super();
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.jlabel = new JLabel("Passwords");
        this.jlabel2 = new JLabel("Current Users");
        this.jlable3 = new JLabel("CTRL+CLICK to deselect a row");
        this.tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(this.tablePanel, BoxLayout.PAGE_AXIS));
        String data2[][] = {{" ", " ", " "}, {" ", " ", " "}};
        dataPass = data2;
        String column[] = {"PASSID", "username", "password"};

        this.passTable = new JTable(dataPass, column);
        passTable.setBounds(30, 40, 100, 200);
        passTable.setDefaultEditor(Object.class, null);
        dataUser = data2;
        String column2[] = {"Admin?", "username"};

        this.userTable = new JTable(dataUser, column2);
        userTable.setBounds(30, 40, 100, 200);
        userTable.setDefaultEditor(Object.class, null);

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
