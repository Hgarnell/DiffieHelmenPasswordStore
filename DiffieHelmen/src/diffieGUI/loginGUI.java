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
public class loginGUI extends JPanel  {

    public JLabel jUsername;

    public JLabel jPassword;
    public JLabel jError;
    public JButton jButton1;
    private JPasswordField jPasswordField1;
    private JTextField jUserField;
    private JFrame frame;

    public loginGUI() {
        super();
        super.setLayout(null);

        //setting the frame
        this.setSize(500, 200);

        //adding the username login label and text box
        this.jUsername = new JLabel("Username");
        this.jUserField = new JTextField();
        jUsername.setBounds(80, 10, 100, 20);
        jUserField.setBounds(80, 30, 100, 20);
        this.add(jUsername);
        this.add(jUserField);
        this.setVisible(true);

        //adding the password login label and text box
        this.jPassword = new JLabel("Password");
        this.jPasswordField1 = new JPasswordField();
        jPassword.setBounds(80, 70, 100, 20);
        jPasswordField1.setBounds(80, 90, 100, 20);
        this.add(jPassword);
        this.add(jPasswordField1);
        this.setVisible(true);

        //adding login button
        this.jButton1 = new JButton("Login");
        this.jButton1.setBounds(300, 130, 100, 20);
        this.add(jButton1);
        this.setVisible(true);

        //formating the errormessage
        this.jError = new JLabel(" oh a no!");
        jError.setForeground(Color.red);
        this.jError.setBounds(300, 40, 100, 20);
        jError.setVisible(false);
        this.add(jError);
        //this.setVisible(true);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String inputUsername = jUserField.getText();
//        String inputPassword = jPassword.getText();
//
//        //test parameters
//        if (inputUsername.equals("test") && inputPassword.equals("test")) {
//            JOptionPane.showMessageDialog(null, "Login Successful");
//
//        } else {
//            //JOptionPane.showMessageDialog(null, "Login bad");
//            this.jError.setVisible(true);
//            this.setVisible(true);
//
//        }
//
//    }

    public static void main(String[] args) {
        loginGUI login = new loginGUI();
        //   login.setFrame(this.frame);

    }
}
