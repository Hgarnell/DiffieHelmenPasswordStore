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
            setGuiVisFalse();
            this.view.passwordGUI.setVisible(true);

            System.out.println("Add Password CLicked");
            this.view.repaint();

            this.model.updateTables();

            this.view.updateTable(this.model.data);
        } else if (source == this.view.adminActivities.delUser) {
            System.out.println("Del User clicked");
            int column = 1;
            int row = this.view.adminActivities.userTable.getSelectedRow();
            System.out.println(row);
            System.out.println(this.view.adminActivities.userModel.getValueAt(row, column).toString());
            this.model.removeUser(this.view.adminActivities.userModel.getValueAt(row, column).toString());
            this.model.updateTables();

            this.view.updateTable(this.model.data);
            this.view.repaint();

        } else if (source == this.view.adminActivities.remove) {

            System.out.println("Del Pass clicked");
            Object output = this.view.adminActivities.passModel.getValueAt(this.view.adminActivities.passTable.getSelectedRow(), 0);
            this.model.removePassword((output != null) ? output.toString() : "null");
            this.view.updateTable(this.model.data);
            this.view.repaint();
        } else if (source == this.view.adminActivities.logout) {
            refreshFields();

            setGuiVisFalse();
            System.out.println("create logout  pressed");
            this.view.entryGUI.setVisible(true);
            this.model.quitGame();
            this.view.repaint();
        } //user activity gui listeners 
        //add Password
        else if (source == this.view.userActivitiesGUI.add) {
            setGuiVisFalse();

            System.out.println("Add Password CLicked");
            this.view.passwordGUI.setVisible(true);
            this.model.updateTables();

            this.view.updateTable(this.model.data);
            this.view.repaint();
        } //Delete Password
        else if (source == this.view.userActivitiesGUI.remove) {
            System.out.println("Del Pass clicked");
            Object output = this.view.userActivitiesGUI.passModel.getValueAt(this.view.userActivitiesGUI.passTable.getSelectedRow(), 0);
            this.model.removePassword((output != null) ? output.toString() : "null");
            this.model.updateTables();
            this.view.updateTable(this.model.data);
            this.view.repaint();
        } else if (source == this.view.userActivitiesGUI.logout) {
            setGuiVisFalse();
            this.view.entryGUI.setVisible(true);
            this.model.quitGame();
        } // entry gui listeners
        else if (source == this.view.entryGUI.createUserOpt) {
            setGuiVisFalse();
            System.out.println("create User option pressed");
            this.view.createUserGUI.setVisible(true);
            this.view.repaint();

        } else if (source == this.view.entryGUI.loginOpt) {
            setGuiVisFalse();
            System.out.println("Login option pressed");
            this.view.loginGUI.setVisible(true);

            this.view.repaint();
        } //login gui listeners
        else if (source == this.view.loginGUI.jButton1) {
            try {
                System.out.println("Login User option pressed");
                System.out.println(this.view.loginGUI.jUserField.getText());
                System.out.println(this.view.loginGUI.jPasswordField1.getText());
                Integer l = parseInt(this.view.loginGUI.jPasswordField1.getText());

                System.out.println(l);

                if (this.model.checkUser(this.view.loginGUI.jUserField.getText(), l)) {
                    refreshFields();

                    if (userIsAdmin()) {
                        this.view.adminActivities.setVisible(true);
                    } else {
                        this.view.userActivitiesGUI.setVisible(true);
                    }

                    this.view.repaint();
                } else {
                    this.view.loginGUI.jError.setVisible(true);
                    this.view.repaint();

                }
            } catch (NumberFormatException k) {
                this.view.loginGUI.jError.setVisible(true);
                this.view.repaint();
            }

        } //create user gui listeners
        else if (source == this.view.createUserGUI.jButton1) {
            System.out.println("create User option pressed");

            String username = this.view.createUserGUI.jUserField.getText();
            if (this.model.addUser(this.view.createUserGUI.jUserField.getText(), this.view.createUserGUI.jPasswordField1.getText(), this.view.createUserGUI.checkAdmin.isSelected())) {
                setGuiVisFalse();
                this.view.entryGUI.setVisible(true);
                this.view.repaint();
                refreshFields();

            } else {
                this.view.createUserGUI.jInfo.setVisible(false);
                this.view.createUserGUI.errorMessage.setVisible(true);
            }
        } else if (source == this.view.passwordGUI.jButton1) {

            System.out.println("create Password option pressed");

            if (this.model.addPass(this.model.data.currentUser, this.view.passwordGUI.jPassIdField.getText(), this.view.passwordGUI.jUserField.getText(), this.view.passwordGUI.jPasswordField1.getText())) {
                refreshFields();
                setGuiVisFalse();

                this.view.repaint();
                if (userIsAdmin()) {
                    this.view.adminActivities.setVisible(true);

                } else {
                    this.view.userActivitiesGUI.setVisible(true);
                }
            } else {
                this.view.passwordGUI.jInfo.setVisible(false);
                this.view.passwordGUI.jError.setVisible(true);
                //refreshFields();
            }
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

    public boolean userIsAdmin() {
        return this.model.data.currentUser.getIsAdmin();
    }

    public void setGuiVisFalse() {
        this.view.adminActivities.setVisible(false);
        this.view.createUserGUI.setVisible(false);

        this.view.entryGUI.setVisible(false);

        this.view.loginGUI.setVisible(false);
        this.view.userActivitiesGUI.setVisible(false);

        this.view.passwordGUI.setVisible(false);

    }

    public void refreshFields() {
        this.view.createUserGUI.jPasswordField1.setText("");
        this.view.createUserGUI.jUserField.setText("");
        this.view.createUserGUI.errorMessage.setVisible(false);
        this.view.createUserGUI.jInfo.setVisible(true);
        this.view.passwordGUI.jPasswordField1.setText("");
        this.view.passwordGUI.jPassIdField.setText("");
        this.view.passwordGUI.jUserField.setText("");
        this.view.loginGUI.jPasswordField1.setText("");
        this.view.loginGUI.jUserField.setText("");
        this.view.passwordGUI.jInfo.setVisible(true);
        this.view.passwordGUI.jError.setVisible(false);
        this.view.loginGUI.jError.setVisible(false);
        this.view.createUserGUI.errorMessage.setVisible(false);

    }
}
