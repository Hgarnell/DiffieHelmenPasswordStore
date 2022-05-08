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
public interface UserActivites {

    //Logic for Creating a new User
    public AdminUser createAdminUser(UserIntializer ui);

    //Logic for deleting User
    public boolean deleteUser(String user);

    //logic for creating deleting and viewing stored passwords.
    public boolean createPassword();

    //logic for deleting a password, returns true if deleted succesfully
    public boolean deletePassword();

    //logic for viewing users password file
    public void viewPassword();
    
    //loop for running user options on what they want to display
    public void userOptions();

}
