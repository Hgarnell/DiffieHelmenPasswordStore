/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diffiehelmen;

/**
 *
 * @author $Bernie Garnell
 */
public class Password{

    String passId;
    String username;
    String password;


    public Password(String passID, String username, String password) {
        this.passId = passID;
        this.username = username;
        this.password = password;
    }

    public String toString() {
        String string;
        string =  passId + "::" + username + "::" + password;
        return string;
    }
}
