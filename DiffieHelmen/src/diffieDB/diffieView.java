/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import diffieGUI.*;
import DiffieHelmen.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author hanna
 */
public class diffieView extends JFrame implements Observer {

    adminActivitiesGUI adminActivitiesGUI = new adminActivitiesGUI();
    userActivitiesGUI userActivitiesGUI = new userActivitiesGUI();
    createUserGUI createUserGUI = new createUserGUI();
    entryGUI entryGUI = new entryGUI();
    loginGUI loginGUI = new loginGUI();
    passwordGUI passwordGUI = new passwordGUI();

    private boolean started = false;

    public diffieView() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));
        this.pack();
        this.setResizable(true);
        this.add(entryGUI);
        this.add(loginGUI);
        this.add(createUserGUI);
        this.add(userActivitiesGUI);
        this.add(adminActivitiesGUI);
        this.add(passwordGUI);

        this.loginGUI.setVisible(false);
        this.createUserGUI.setVisible(false);
        this.userActivitiesGUI.setVisible(false);
        this.adminActivitiesGUI.setVisible(false);
        this.passwordGUI.setVisible(false);

        this.setVisible(true);
    }

    public void addActionListner(ActionListener listener) {

        this.entryGUI.createUserOpt.addActionListener(listener);
        this.entryGUI.loginOpt.addActionListener(listener);

        this.loginGUI.loginButton.addActionListener(listener);
        this.loginGUI.backButton.addActionListener(listener);

        this.passwordGUI.createPassButton.addActionListener(listener);
        this.passwordGUI.backButton.addActionListener(listener);

        this.adminActivitiesGUI.delUser.addActionListener(listener);
        this.adminActivitiesGUI.add.addActionListener(listener);
        this.adminActivitiesGUI.remove.addActionListener(listener);
        this.adminActivitiesGUI.logout.addActionListener(listener);

        this.userActivitiesGUI.add.addActionListener(listener);
        this.userActivitiesGUI.remove.addActionListener(listener);
        this.userActivitiesGUI.logout.addActionListener(listener);

        this.createUserGUI.checkAdmin.addActionListener(listener);
        this.createUserGUI.createButton.addActionListener(listener);
        this.createUserGUI.backButton.addActionListener(listener);
    }

    //update jtable models
    public void updateTable(userData data) {
        //update table for admin user
        if (data.currentUser.getIsAdmin()) {
            this.adminActivitiesGUI.userModel.setRowCount(0);
            this.adminActivitiesGUI.passModel.setRowCount(0);

            this.adminActivitiesGUI.dataPass = data.passArrayList;
            this.adminActivitiesGUI.dataUser = data.userMap;

            for (String[] k : this.adminActivitiesGUI.dataUser) {
                this.adminActivitiesGUI.userModel.addRow(k);
            }

            for (String[] j : this.adminActivitiesGUI.dataPass) {
                this.adminActivitiesGUI.passModel.addRow(j);
            }
            
            this.adminActivitiesGUI.passModel.fireTableDataChanged();
            this.adminActivitiesGUI.userModel.fireTableDataChanged();

            this.adminActivitiesGUI.userTable.revalidate();
            this.adminActivitiesGUI.passTable.revalidate();

            this.adminActivitiesGUI.repaint();
        } 
        //jtables for GEn User
        else {
            this.userActivitiesGUI.passModel.setRowCount(0);
            this.userActivitiesGUI.dataPass = data.passArrayList;

            for (String[] j : this.userActivitiesGUI.dataPass) {
                this.userActivitiesGUI.passModel.addRow(j);
            }
            this.userActivitiesGUI.passModel.fireTableDataChanged();

            this.userActivitiesGUI.passTable.revalidate();

            this.userActivitiesGUI.repaint();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        userData data = (userData) arg;
        this.pack();
        if (data != null) 
        {
            if (data.loginFlag) {
                this.loginGUI.setVisible(false);
                if (!data.currentUser.getIsAdmin()) {
                    updateTable(data);
                    this.started = true;

                } else {

                    updateTable(data);
                    this.started = true;
                }
            } 
        }
        
    }
}


