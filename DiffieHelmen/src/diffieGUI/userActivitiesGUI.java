/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieGUI;

import java.awt.BorderLayout;
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
public class userActivitiesGUI extends JPanel implements ActionListener {

    private JPanel buttonPanel;
    public JTable passTable;
    private JLabel jlabel, jlabel2;
    public JButton add, remove, logout;
    private JScrollPane scrollPane;
    public String[][] dataPass;
    public DefaultTableModel passModel;
    public userActivitiesGUI() {
        super();
        this.setSize(500, 250);
        this.setLayout(new BorderLayout());
        this.jlabel = new JLabel("Passwords");
        this.jlabel2 = new JLabel("CTRL+CLICK to deselect a row");
        this.add(jlabel, BorderLayout.NORTH);
        this.add(jlabel2, BorderLayout.SOUTH);

       dataPass = new String[1][3];
        String columnPass[] = {"PASSID", "username", "password"};
        this.passModel = new DefaultTableModel(dataPass, columnPass);
        this.passTable = new JTable(passModel);
        passTable.setBounds(30, 40, 100, 200);
        passTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        passTable.setDefaultEditor(Object.class, null);

        this.scrollPane = new JScrollPane(passTable);
        this.scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
        this.add(scrollPane, BorderLayout.CENTER);

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        this.add = new JButton("Add");
        this.remove = new JButton("Remove");
        this.logout = new JButton("Logout");

        this.buttonPanel.add(logout);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        this.buttonPanel.add(add);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        this.buttonPanel.add(remove);

        this.buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(buttonPanel, BorderLayout.EAST);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        userActivitiesGUI k = new userActivitiesGUI();
    }

}
