/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import diffiehelmen.*;
import java.util.Observable;

/**
 *
 * @author hanna
 */
public class diffieModel extends Observable {

    public diffieDatabase db;
    public userData data;
    public User user,adding,removing;
    public Password addPass,remPass;
    
    public diffieModel() {
        this.db = new diffieDatabase();
        this.db.dbsetup();
    }

    public void checkUser(String username, int masterpin) {
        this.data = this.db.checkUser(username, masterpin);
        if (data.loginFlag) {
           if(data.currentUser.getIsAdmin())
           {
                this.setChanged();
        this.notifyObservers(this.data);
           }
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void addUser(){
        
    }
    
    public void quitGame(){
        this.data.quitFlag = true;
        this.setChanged();
    }
    
}
