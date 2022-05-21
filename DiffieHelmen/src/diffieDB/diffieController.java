/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.xml.transform.Source;

/**
 *
 * @author hanna
 */
public class diffieController implements ActionListener {

    public diffieModel model;
    public diffieView view;

    public diffieController(diffieModel model, diffieView view) {
        this.view = view;
        this.model = model;
        this.view.addActionListner(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        //admin activity gui listeners
        if (source == this.view.adminActivities.add) {
        }
        else if(source == this.view.adminActivities.delUser){
        }
        else if(source == this.view.adminActivities.logout){
        }
        else if(source == this.view.adminActivities.remove){
        }
        
        //user activity gui listeners
        else if(source == this.view.userActivitiesGUI.add) {
        }
         else if(source == this.view.userActivitiesGUI.remove) {
        }
        else if(source == this.view.userActivitiesGUI.logout) {
        }
        
        // entry gui listeners
        else if(source == this.view.entryGUI.createUserOpt){
            this.view.entryGUI.setVisible(false);
            this.view.createUserGUI.setVisible(true);
        }
        else if(source == this.view.entryGUI.loginOpt){
        }
        
        //login gui listeners
        else if(source == this.view.loginGUI.jButton1){
        }
        
        //create user gui listeners
        else if(source == this.view.createUserGUI.jButton1){
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
