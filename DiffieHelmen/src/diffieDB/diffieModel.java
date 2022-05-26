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
    public User user, adding, removing;
    public Password addPass, remPass;

    public diffieModel() {
        this.db = new diffieDatabase();
        this.db.dbsetup();
    }

    public void checkUser(String username, Integer masterpin) {
        System.out.println("Check User notified");

        this.data = this.db.checkUser(username, masterpin);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public boolean addUser(String username, String secret, Boolean isAdmin) {
        UserKeyGenerator k = new UserKeyGenerator();
        System.out.println("addUser notified");
        if (Pattern.matches("\\d{4}", String.valueOf(secret))) {
            UserKey v = k.userKeyGenerator(new BigInteger(secret));
            if (isAdmin) {
                this.db.addUser(new AdminUser(username, k.userKeyGenerator(new BigInteger(secret))));
            } else {
                this.db.addUser(new GeneralUser(username, k.userKeyGenerator(new BigInteger(secret))));
            }
            return true;
        } else {
            return false;
        }
    }

    public void quitGame() {
        this.data.quitFlag = true;
        this.setChanged();
    }

}
