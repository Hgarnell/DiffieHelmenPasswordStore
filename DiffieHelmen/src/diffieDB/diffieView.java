/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import diffieGUI.*;
import DiffieHelmen.*;
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

    adminActivitiesGUI adminActivities = new adminActivitiesGUI();
    userActivitiesGUI userActivitiesGUI = new userActivitiesGUI();
    createUserGUI createUserGUI = new createUserGUI();
    entryGUI entryGUI = new entryGUI();
    loginGUI loginGUI = new loginGUI();
    passwordGUI passwordGUI = new passwordGUI();

    private boolean started = false;

    public diffieView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.add(entryGUI);
        this.add(loginGUI);
        this.loginGUI.setVisible(false);
        this.add(createUserGUI);
        this.createUserGUI.setVisible(false);

        this.add(userActivitiesGUI);
        this.userActivitiesGUI.setVisible(false);

        this.add(adminActivities);
        this.adminActivities.setVisible(false);

        this.add(passwordGUI);
        this.passwordGUI.setVisible(false);

        this.setVisible(true);

    }

    public void addActionListner(ActionListener listener) {

        this.entryGUI.createUserOpt.addActionListener(listener);
        this.entryGUI.loginOpt.addActionListener(listener);

        this.loginGUI.jButton1.addActionListener(listener);

        this.passwordGUI.jButton1.addActionListener(listener);

        this.adminActivities.delUser.addActionListener(listener);
        this.adminActivities.add.addActionListener(listener);
        this.adminActivities.remove.addActionListener(listener);
        this.adminActivities.logout.addActionListener(listener);

        this.userActivitiesGUI.add.addActionListener(listener);
        this.userActivitiesGUI.remove.addActionListener(listener);
        this.userActivitiesGUI.logout.addActionListener(listener);

        this.createUserGUI.checkAdmin.addActionListener(listener);
        this.createUserGUI.jButton1.addActionListener(listener);

    }

    public void updateTable(userData data) {
        if (data.currentUser.getIsAdmin()) {
            this.adminActivities.userModel.setRowCount(0);
            this.adminActivities.passModel.setRowCount(0);

            this.adminActivities.dataPass = data.passArrayList;
            this.adminActivities.dataUser = data.userMap;

            for (String[] k : this.adminActivities.dataUser) {
                this.adminActivities.userModel.addRow(k);
            }

            for (String[] j : this.adminActivities.dataPass) {
                this.adminActivities.passModel.addRow(j);
            }
            this.adminActivities.passModel.fireTableDataChanged();
            this.adminActivities.userModel.fireTableDataChanged();

            this.adminActivities.userTable.revalidate();
            this.adminActivities.passTable.revalidate();

            this.adminActivities.repaint();
        } else {
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
       if (data.loginFlag) {

            this.loginGUI.setVisible(false);
            if (!data.currentUser.getIsAdmin()) {
                updateTable(data);
                this.started = true;

            } else {

                updateTable(data);
                this.started = true;

            }
        } else {

        }
    }
}

//            this.setQuestion(dataPass.num1, dataPass.num2);
//        }

