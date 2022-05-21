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
public class Password {

    private String passId;
    private String username;
    private String password;

    public Password(String passID, String username, String password) {
        this.passId = passID;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        String string;
        string = getPassId() + "::" + getUsername() + "::" + getPassword();
        return string;
    }

    /**
     * @return the passId
     */
    public String getPassId() {
        return passId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

}
