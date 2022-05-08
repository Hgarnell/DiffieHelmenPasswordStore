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
public class AdminUser extends User{

    public AdminUser(String username, UserKey key) {
        super(username, key);
       
        this.isAdmin = true;
    }

}
