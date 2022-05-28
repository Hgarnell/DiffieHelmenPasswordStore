/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.transform.Source;

/**
 *
 * @author hanna
 */
public class diffieController implements ActionListener {

    public diffieModel model;

    public diffieView view;

    public diffieController(diffieView view, diffieModel model) {
        this.view = view;
        this.model = model;
        this.view.addActionListner(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //admin activity gui listeners
        if (source == this.view.adminActivities.add) {
        } else if (source == this.view.adminActivities.delUser) {
            int column = 1;
            int row = this.view.adminActivities.userTable.getSelectedRow();
            this.model.removeUser(this.view.adminActivities.userTable.getValueAt(column, row).toString());
        } else if (source == this.view.adminActivities.logout) {
            System.out.println("create logout  pressed");
            this.view.entryGUI.setVisible(true);
            this.view.adminActivities.setVisible(false);
            this.model.quitGame();
            this.view.repaint();
        } else if (source == this.view.adminActivities.remove) {
        } //user activity gui listeners               
        else if (source == this.view.userActivitiesGUI.add) {
            System.out.println("create logout  pressed");
            this.view.entryGUI.setVisible(true);
            this.view.userActivitiesGUI.setVisible(false);
            this.view.repaint();
        } else if (source == this.view.userActivitiesGUI.remove) {
        } else if (source == this.view.userActivitiesGUI.logout) {
            this.view.entryGUI.setVisible(true);
            this.view.userActivitiesGUI.setVisible(true);
            this.model.quitGame();

        } // entry gui listeners
        else if (source == this.view.entryGUI.createUserOpt) {
            System.out.println("create User option pressed");
            this.view.entryGUI.setVisible(false);
            this.view.createUserGUI.setVisible(true);
            this.view.repaint();

        } else if (source == this.view.entryGUI.loginOpt) {
            System.out.println("Login option pressed");
            this.view.loginGUI.setVisible(true);
            this.view.entryGUI.setVisible(false);

            this.view.repaint();
        } //login gui listeners
        else if (source == this.view.loginGUI.jButton1) {
            try {
                System.out.println("Login User option pressed");
                System.out.println(this.view.loginGUI.jUserField.getText());
                System.out.println(this.view.loginGUI.jPasswordField1.getText());
                Integer l = parseInt(this.view.loginGUI.jPasswordField1.getText());
                System.out.println(l);

                this.model.checkUser(this.view.loginGUI.jUserField.getText(), l);
                this.view.repaint();

            } catch (Exception x) {
                System.out.println(x);
            }

        } //create user gui listeners
        else if (source == this.view.createUserGUI.jButton1) {
            System.out.println("create User option pressed");
            this.view.entryGUI.setVisible(true);
            this.view.createUserGUI.setVisible(false);
            this.view.repaint();
            String username = this.view.createUserGUI.jUserField.getText();
            this.model.addUser(this.view.createUserGUI.jUserField.getText(), this.view.createUserGUI.jPasswordField1.getText(), true);

        }

//            case ():
//                String username = this.view.unInput.getText();
//                String Password = this.view.pwInput.getText();
//                this.model.checkUser(username, Password);
//                break;
//            case "Next":
//                this.model.checkAnswer(this.view.calcSolution.getText());
//                break;
//            case "Quit":
//                this.model.quitGame();
//                break;
//            default:
//                break;
    }
}
