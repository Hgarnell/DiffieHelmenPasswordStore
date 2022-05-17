/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author hanna
 */
public class passwordGUI extends JFrame implements ActionListener {

    private JLabel jPassId, jUsername, jPassword, jError, jInfo;
    private JButton jButton1;
    private JPasswordField jPasswordField1;
    private JTextField jUserField, jPassIdField;
    private JFrame frame;
    private String passInfoString;
    private JOptionPane confirmPass;
    public passwordGUI() {
        super();
        super.setLayout(null);

        //setting the frame
        this.setTitle("Create Password");
        this.setSize(550, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding the username login label and text box
        this.jUsername = new JLabel("Username");
        this.jUserField = new JTextField();
        jUsername.setBounds(80, 10, 100, 20);
        jUserField.setBounds(80, 30, 100, 20);
        this.add(jUsername);
        this.add(jUserField);

        //adding the password login label and text box
        this.jPassword = new JLabel("Password");
        this.jPasswordField1 = new JPasswordField();
        jPassword.setBounds(80, 70, 100, 20);
        jPasswordField1.setBounds(80, 90, 100, 20);
        this.add(jPassword);
        this.add(jPasswordField1);

        //adding the password login label and text box
        this.jPassId = new JLabel("PassID");
        this.jPassIdField = new JTextField();
        jPassId.setBounds(80, 120, 100, 20);
        jPassIdField.setBounds(80, 140, 100, 20);
        this.add(jPassId);
        this.add(jPassIdField);

        //adding login button
        this.jButton1 = new JButton("Create password");
        this.jButton1.setBounds(300, 130, 140, 20);
        this.jButton1.addActionListener(this);
        this.add(jButton1);

        this.passInfoString = "<html>PassID: an identifier for you to remember the password<br><br>Username: your username<br><br>Password: your password</html>";
        //formating the information message
        this.jInfo = new JLabel(passInfoString);
        this.jInfo.setVisible(true);
        this.jInfo.setBounds(200, 5, 250, 100);
        this.add(jInfo);
        //this.setVisible(true);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputUsername = jUserField.getText();
        String inputPassword = jPasswordField1.getText();
        String inputPassID = jPassIdField.getText();
        //Display message if any of the textfields are empty
        if (inputUsername.equals("") || inputPassword.equals("") || inputPassID.equals("")) {
            //if false then set the jinfo to show the error message
            this.jInfo.setText("<html>Please Ensure that all Fields are filled out</html>");
            jInfo.setForeground(Color.red);

        } else {
            jInfo.setForeground(Color.BLACK);

            this.jInfo.setText(passInfoString);
            int n = JOptionPane.showConfirmDialog(this,"Confirm Password Create");
        }

    }

    public static void main(String[] args) {
        passwordGUI login = new passwordGUI();
        //   login.setFrame(this.frame);

    }
}
