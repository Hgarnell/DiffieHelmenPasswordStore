/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

import diffiehelmen.*;
import java.math.BigInteger;
import java.util.Observable;
import java.util.regex.Pattern;

/**
 *
 * @author hanna
 */
public class diffieModel extends Observable {

    public diffieDatabase db;
    public userData data;
    public Password addPass, remPass;

    public diffieModel() {
        this.db = new diffieDatabase();
        this.db.dbsetup();
    }

    //notify observers that data for current user has been changed if succesfully logged in return true
    public boolean checkUser(String username, Integer masterpin) {
        System.out.println("Check User notified");
        this.data = this.db.checkUser(username, masterpin);
        this.setChanged();
        this.notifyObservers(this.data);
        return this.data.loginFlag;
    }

    //notify observers that a new user has been added succesfully also ensure that pattern of secret string is 4 integers
    public boolean addUser(String username, String secret, Boolean isAdmin) {
        boolean succ = false;
        
        UserKeyGenerator k = new UserKeyGenerator();
        System.out.println("addUser notified");
        
        if (Pattern.matches("\\d{4}", String.valueOf(secret))) {
            UserKey v = k.userKeyGenerator(new BigInteger(secret));
            if (isAdmin) {
              succ =  this.db.addUser(new AdminUser(username, k.userKeyGenerator(new BigInteger(secret))));
            } else {
               succ  =  this.db.addUser(new GeneralUser(username, k.userKeyGenerator(new BigInteger(secret))));
            }
            this.setChanged();
            this.notifyObservers(this.data);

           
        }
        return succ;
    }

    //Notify the observers that data has been changed after password added to the database succesfully
    public boolean addPass(User user, String passID, String passUsername, String password) {

        System.out.println("addPass notified");
        Password newPass = new Password(passID, passUsername, password);

        if (this.db.addPassword(newPass, user.getUsername())) {
            System.out.println("added succesfully");
            this.data.passArrayList = this.db.getPasswords(user);
            this.setChanged();
            this.notifyObservers(this.data);
            return true;

        }
        return false;

    }

    //notify data usermap the userlist has been changed and observers that data has been changed
    public boolean removeUser(String username) {

        if (this.db.removeUser(username)) {
            this.data.userMap = this.db.getUserList();
            this.setChanged();
            this.notifyObservers(this.data);
            return true;
        }

        return false;

    }
    
    //attempt to remove password from db wheree passID matches passowrd passID of data's current user.
    //notify observers if true and update data
    public boolean removePassword(String passID) {

        if (this.db.removePassword(passID, data.currentUser.getUsername())) {
            this.data.passArrayList = this.db.getPasswords(data.currentUser);
            this.setChanged();
            this.notifyObservers(this.data);
            return true;
        }

        return false;

    }

    //update tables and notify observers
    public void updateTables() {

        this.data.passArrayList = this.db.getPasswords(data.currentUser);
        this.data.userMap = this.db.getUserList();
        this.setChanged();
        this.notifyObservers(this.data);

    }

    //notify Observers game has been quit
    public void quitGame() {
        this.data.currentUser = null;
        this.data.loginFlag = false;
        this.notifyObservers(this.data);
        this.setChanged();
    }

}
