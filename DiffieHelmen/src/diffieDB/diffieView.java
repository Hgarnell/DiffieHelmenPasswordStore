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
        this.setSize(600, 200);;
        this.add(entryGUI);
        this.setVisible(true);

    }

    public void addActionListner(ActionListener listener) {

        this.entryGUI.createUserOpt.addActionListener(listener);
        this.entryGUI.loginOpt.addActionListener(listener);

        this.loginGUI.jButton1.addActionListener(listener);

        this.passwordGUI.jButton1.addActionListener(listener);

        this.adminActivities.delUser.addActionListener(listener);
        this.userActivitiesGUI.add.addActionListener(listener);
        this.userActivitiesGUI.remove.addActionListener(listener);
        this.userActivitiesGUI.logout.addActionListener(listener);
        
        this.userActivitiesGUI.add.addActionListener(listener);
        this.userActivitiesGUI.remove.addActionListener(listener);
        this.userActivitiesGUI.logout.addActionListener(listener);

        this.createUserGUI.jButton1.addActionListener(listener);

    }

    @Override
    public void update(Observable o, Object arg) {
        userData data = (userData) arg;
        if (!data.loginFlag) {
            this.loginGUI.jError.setVisible(true);

        } else if (!data.currentUser.getIsAdmin()) {
            this.genUserStart();
            this.started = true;
            this.setQuestion(data.num1, data.num2);
        } else if (data.quitFlag) {
            this.quitGame(data.currentScore);
        } else {
            this.setQuestion(data.num1, data.num2);
        }

    }

    void genUserStart() {
        this.getContentPane().removeAll();
        this.add(userActivitiesGUI);
    }

    public static void main(String[] args) {
        diffieView df = new diffieView();
    }
}
