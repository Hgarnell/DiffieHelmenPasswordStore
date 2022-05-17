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
public class adminActivitiesGUI extends JFrame implements ActionListener {

    private JPanel buttonPanel, tablePanel;
    private JTable jTable1, jTable2;
    private JLabel jlabel, jlabel2,jlable3;
    private JButton add, remove, logout, delUser;
    private JScrollPane scrollPane, scrollPane2;

    adminActivitiesGUI() {
        super();
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.jlabel = new JLabel("Passwords");
        this.jlabel2 = new JLabel("Current Users");
        this.jlable3 = new JLabel("CTRL+CLICK to deselect a row");
        this.tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(this.tablePanel, BoxLayout.PAGE_AXIS));
        String data[][] = {{"101", "hi", "670000"},
        {"102", "hi", "780000"},
        {"101", "hi", "700000"}};
        String column[] = {"PASSID", "username", "password"};

        this.jTable1 = new JTable(data, column);
        jTable1.setBounds(30, 40, 100, 200);
        jTable1.setDefaultEditor(Object.class, null);

        String column2[] = {"isAdmin?", "username"};
        this.jTable2 = new JTable(data, column2);
        jTable2.setBounds(30, 40, 100, 200);
        jTable2.setDefaultEditor(Object.class, null);

        this.scrollPane2 = new JScrollPane(jTable2);
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.scrollPane = new JScrollPane(jTable1);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        adminActivitiesGUI k = new adminActivitiesGUI();
    }

}
