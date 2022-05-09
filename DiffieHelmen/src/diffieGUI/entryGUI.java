/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author hanna
 */
public class entryGUI extends JFrame implements ActionListener {

    private JButton loginOpt, createUserOpt;
    private JLabel welcome;
    private JPanel buttons;

    public entryGUI() {
        super();
        super.setLayout(new GridLayout(2, 1));

        //setting the frame
        this.setTitle("Diffie Helmen Password Store");
        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //welcome text
        this.welcome = new JLabel("<html> Welcome to the Diffie Hellman password Vault!<br> "
                + "User Pin numbers are created and stored using a "
                + "Diffie Hellman Key exchange. To get started"
                + " please select one of the following options:</html>");
        this.welcome.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        this.add(welcome, 0, 0);

        //adding the buttons
        this.buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        this.loginOpt = new JButton("Login");
        buttons.add(this.loginOpt);
        this.createUserOpt = new JButton("createUserOpt");
        buttons.add(this.createUserOpt);
        this.add(buttons);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
               Object source = e.getSource();
               if(source ==loginOpt)
               {
                   loginGUI login = new loginGUI();
               }

    }

    public static void main(String[] args) {
        entryGUI test = new entryGUI();
    }
}
