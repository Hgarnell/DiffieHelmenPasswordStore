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
public abstract class User {

    private String username;
    private UserKey keys;
    protected boolean isAdmin;

    public User(String username, UserKey key) {
        this.username = username;
        this.keys = key;
    }

    public String getUsername() {
        return this.username;
    }

    public UserKey getUserKeys() {
        return this.keys;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }
    
   
}
