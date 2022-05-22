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

    private JLabel jUsername, jPassword, jErrorNull, jErrorPin;
    public JButton jButton1;
    public JPasswordField jPasswordField1;
    public JTextField jUserField;

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

        //adding login button
        this.jButton1 = new JButton("Login");
        this.jButton1.setBounds(300, 130, 100, 20);
        this.add(jButton1);
        this.setVisible(true);

        //formating the errormessage
        this.jErrorPin = new JLabel("PIN NOT OKAY");
        jErrorPin.setForeground(Color.red);
        this.jErrorPin.setBounds(300, 40, 100, 20);
        jErrorPin.setVisible(false);
        this.add(jErrorPin);

        this.jErrorNull = new JLabel("FIELDNULL");
        jErrorNull.setForeground(Color.red);
        this.jErrorNull.setBounds(300, 40, 100, 20);
        jErrorNull.setVisible(false);
        this.add(jErrorNull);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jErrorPin.setVisible(false);
        this.jErrorNull.setVisible(false);
        Object source = e.getSource();

        String inputUsername = jUserField.getText();
        String inputPassword = jPasswordField1.getText();
        if (source == jButton1) {
            //test parameters
            if (inputUsername.equals("")) {
                this.jErrorNull.setVisible(true);
                this.setVisible(true);

            } else if (!(Pattern.matches("\\d{4}", inputPassword))) {
                this.jErrorPin.setVisible(true);
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
