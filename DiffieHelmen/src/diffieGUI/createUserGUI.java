/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class createUserGUI extends JPanel implements ActionListener {

    public JLabel jUsername, jPassword, jInfo, errorMessage;
    public JButton createButton,backButton;
    public JPasswordField jPasswordField1;
    public JTextField jUserField;
    public JCheckBox checkAdmin;

    public createUserGUI() {
        super();
        super.setLayout(null);

        //creatingthe user area
        //setting the frame
        this.setSize(500, 200);

        //adding the username login label and text box
        this.jUsername = new JLabel("Enter a Username ");
        this.jUserField = new JTextField();
        jUsername.setBounds(80, 10, 150, 20);
        jUserField.setBounds(80, 30, 100, 20);

        this.add(jUsername);
        this.add(jUserField);
        this.setVisible(true);

        //adding the password login label and text box
        this.jPassword = new JLabel("Enter a Pin");
        this.jPasswordField1 = new JPasswordField();
        jPassword.setBounds(80, 70, 150, 20);
        jPasswordField1.setBounds(80, 90, 100, 20);
        this.add(jPassword);
        this.add(jPasswordField1);
        this.setVisible(true);

        //Adding a checkbox to check if admin or not
        this.checkAdmin = new JCheckBox("Admin?");
        this.checkAdmin.setBounds(80, 120, 100, 20);
        this.add(checkAdmin);

        //adding login button
        this.createButton = new JButton("Create");
        this.createButton.setBounds(300, 130, 100, 20);
        this.add(createButton);
        this.setVisible(true);

    
        //adding Back button
        this.backButton = new JButton("<- Go Back");
        this.backButton.setBounds(300, 0, 100, 20);
        this.add(backButton);
        this.setVisible(true);
        
        //formating the errormessage
        this.errorMessage = new JLabel("<html>Ensure all fields are filled, and that your pin number is a 4 digit integer.</html>");
        errorMessage.setForeground(Color.red);
        this.errorMessage.setBounds(250,10, 250, 100);
        errorMessage.setVisible(false);
        this.add(errorMessage);
        
        //Formatting for the info message on how to create a user
        String userInfoString = "<html>Your username can be anything you want, however make it something you can remember<br> Your pin number must be a 4 digit integer</html>";
        this.jInfo = new JLabel(userInfoString);
        jInfo.setForeground(Color.black);
        this.jInfo.setBounds(250, 10, 250, 100);
        jInfo.setVisible(true);
        this.add(jInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.errorMessage.setVisible(false);
        this.jInfo.setVisible(false);
        Object source = e.getSource();

        String inputUsername = jUserField.getText();
        String inputPassword = jPasswordField1.getText();
        if (source == createButton) {
            //test parameters
            if (inputUsername.equals("")) {
                this.jInfo.setVisible(true);
                this.setVisible(true);

            } else if (!(Pattern.matches("\\d{4}", inputPassword))) {
                this.errorMessage.setVisible(true);
                this.setVisible(true);
            } else {

                JOptionPane.showMessageDialog(null, "Success");
            }
        }

    }

    public static void main(String[] args) {
        createUserGUI login = new createUserGUI();
        //   login.setFrame(this.frame);

    }
}
