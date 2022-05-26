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
import javax.swing.border.EmptyBorder;

/**
 *
 * @author hanna
 */
public class userActivitiesGUI extends JPanel implements ActionListener {

    private JPanel buttonPanel;
    private JTable jTable1;
    private JLabel jlabel, jlabel2;
    public JButton add, remove, logout;
    private JScrollPane scrollPane;
    public String[][] dataPass;

    public userActivitiesGUI() {
        super();
        this.setSize(500, 250);
        this.setLayout(new BorderLayout());
        this.jlabel = new JLabel("Passwords");
        this.jlabel2 = new JLabel("CTRL+CLICK to deselect a row");
        this.add(jlabel, BorderLayout.NORTH);
        this.add(jlabel2, BorderLayout.SOUTH);

       String data2[][] =   {{" "," "," "},{" "," "," "}};
       dataPass =  data2;
        String column[] = {"PASSID", "username", "password"};
        this.jTable1 = new JTable(dataPass, column);
        jTable1.setBounds(30, 40, 200, 300);
        jTable1.setDefaultEditor(Object.class, null);

        this.scrollPane = new JScrollPane(jTable1);
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
