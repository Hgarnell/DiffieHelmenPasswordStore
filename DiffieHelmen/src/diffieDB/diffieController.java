/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

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
        if (source == this.view.adminActivitiesGUI.add) {
            setGuiVisFalse();
            this.view.passwordGUI.setVisible(true);

            this.view.repaint();

            this.model.updateTables();

            this.view.updateTable(this.model.data);
        } //Delete User selected by Admin
        else if (source == this.view.adminActivitiesGUI.delUser) {
            if (this.view.adminActivitiesGUI.userTable.getSelectedRow() > -1) {
                int column = 1;
                int row = this.view.adminActivitiesGUI.userTable.getSelectedRow();
                System.out.println(row);
                System.out.println(this.view.adminActivitiesGUI.userModel.getValueAt(row, column).toString());
                this.model.removeUser(this.view.adminActivitiesGUI.userModel.getValueAt(row, column).toString());
                this.model.updateTables();
            }
            this.view.updateTable(this.model.data);
            this.view.repaint();
        } //Remove Password
        else if (source == this.view.adminActivitiesGUI.remove) {
            if (this.view.adminActivitiesGUI.passTable.getSelectedRow() > -1) {
                Object output = this.view.adminActivitiesGUI.passModel.getValueAt(this.view.adminActivitiesGUI.passTable.getSelectedRow(), 0);
                this.model.removePassword((output != null) ? output.toString() : "null");
            }
            this.view.updateTable(this.model.data);
            this.view.repaint();
        } //log admin user out and quitGame
        else if (source == this.view.adminActivitiesGUI.logout) {
            refreshFields();
            setGuiVisFalse();
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
            if (this.view.userActivitiesGUI.passTable.getSelectedRow() > -1) {
                Object output = this.view.userActivitiesGUI.passModel.getValueAt(this.view.userActivitiesGUI.passTable.getSelectedRow(), 0);
                this.model.removePassword((output != null) ? output.toString() : "null");
                this.model.updateTables();
            }
            this.view.updateTable(this.model.data);
            this.view.repaint();
        } else if (source == this.view.userActivitiesGUI.logout) {
            setGuiVisFalse();
            this.view.entryGUI.setVisible(true);
            this.model.quitGame();
        } // entry gui listeners
        else if (source == this.view.entryGUI.createUserOpt) {
            setGuiVisFalse();
            this.view.createUserGUI.setVisible(true);
            this.view.repaint();

        } else if (source == this.view.entryGUI.loginOpt) {
            setGuiVisFalse();
            this.view.loginGUI.setVisible(true);

            this.view.repaint();
        } //login gui listeners
        else if (source == this.view.loginGUI.loginButton) {
            try {
                System.out.println(this.view.loginGUI.jUserField.getText());
                System.out.println(this.view.loginGUI.jPasswordField1.getText());
                Integer l = parseInt(this.view.loginGUI.jPasswordField1.getText());

                //check ig user exists, if true display activites panel
                if (this.model.checkUser(this.view.loginGUI.jUserField.getText(), l)) {

                    refreshFields();
                    if (userIsAdmin()) {
                        this.view.adminActivitiesGUI.setVisible(true);
                    } else {
                        this.view.userActivitiesGUI.setVisible(true);
                    }

                    this.view.repaint();
                } else {
                    //if password is incorrect Display error message
                    this.view.loginGUI.jError.setVisible(true);
                    this.view.repaint();

                }
            } //if incorrect format display error message
            catch (NumberFormatException k) {
                this.view.loginGUI.jError.setVisible(true);
                this.view.repaint();
            }

        } //create user gui listeners
        else if (source == this.view.createUserGUI.createButton) {

            String username = this.view.createUserGUI.jUserField.getText();
            Boolean isAdmin = this.view.createUserGUI.checkAdmin.isSelected();

            //if user is added succesfully return to entryGUI
            if (this.model.addUser(username, this.view.createUserGUI.jPasswordField1.getText(), isAdmin)) {
                setGuiVisFalse();
                this.view.entryGUI.setVisible(true);
                this.view.repaint();
                refreshFields();
            } //if not display error message
            else {
                this.view.createUserGUI.jInfo.setVisible(false);
                this.view.createUserGUI.errorMessage.setVisible(true);
            }
        } //Create password button on password GUI
        else if (source == this.view.passwordGUI.createPassButton) {
            //if Password is added succesfully return to suer panel
            if (this.model.addPass(this.model.data.currentUser, this.view.passwordGUI.jPassIdField.getText(), this.view.passwordGUI.jUserField.getText(), this.view.passwordGUI.jPasswordField1.getText())) {
                refreshFields();
                setGuiVisFalse();
                this.view.repaint();
                if (userIsAdmin()) {
                    this.view.adminActivitiesGUI.setVisible(true);
                } else {
                    this.view.userActivitiesGUI.setVisible(true);
                }
            } //if Password fields is incorrect display the error message
            else {
                this.view.passwordGUI.jInfo.setVisible(false);
                this.view.passwordGUI.jError.setVisible(true);
            }
        } //Back button to go back to userActivityPanel
        else if (source == this.view.passwordGUI.backButton) {
            setGuiVisFalse();
            if (userIsAdmin()) {
                this.view.adminActivitiesGUI.setVisible(true);
            } else {
                this.view.userActivitiesGUI.setVisible(true);
            }
            this.view.repaint();
        } //Back button for Create user gui to go back to entry
        else if (source == this.view.createUserGUI.backButton) {
            refreshFields();
            setGuiVisFalse();
            this.view.entryGUI.setVisible(true);
            this.view.repaint();
        } //Back button for the loginn GUI to go back to entry GUI
        else if (source == this.view.loginGUI.backButton) {
            refreshFields();
            setGuiVisFalse();
            this.view.entryGUI.setVisible(true);
            this.view.repaint();
        }
    }

    //return boolean if the current user in the data is an admin or not
    public boolean userIsAdmin() {
        return this.model.data.currentUser.getIsAdmin();
    }

    //set all gui visibility false
    public void setGuiVisFalse() {
        this.view.adminActivitiesGUI.setVisible(false);
        this.view.createUserGUI.setVisible(false);
        this.view.entryGUI.setVisible(false);
        this.view.loginGUI.setVisible(false);
        this.view.userActivitiesGUI.setVisible(false);
        this.view.passwordGUI.setVisible(false);
    }

    //set all fields and text messages to original state
    public void refreshFields() {
        this.view.createUserGUI.jPasswordField1.setText("");
        this.view.createUserGUI.jUserField.setText("");
        this.view.createUserGUI.errorMessage.setVisible(false);
        this.view.createUserGUI.jInfo.setVisible(true);
        this.view.createUserGUI.errorMessage.setVisible(false);

        this.view.passwordGUI.jPasswordField1.setText("");
        this.view.passwordGUI.jPassIdField.setText("");
        this.view.passwordGUI.jUserField.setText("");
        this.view.passwordGUI.jInfo.setVisible(true);
        this.view.passwordGUI.jError.setVisible(false);

        this.view.loginGUI.jPasswordField1.setText("");
        this.view.loginGUI.jUserField.setText("");
        this.view.loginGUI.jError.setVisible(false);
    }
}
