/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.util.Scanner;

/**
 *
 * @author $Bernie Garnell
 */
public class PasswordGenerator {

    Scanner scan;
    
    //password generator constructor
    public PasswordGenerator(Scanner scan)
    {
        this.scan = scan;
    }
    
    //method for printing out password creation instructions and returns the password that the user created
    public Password createPassword() {
        Password created;
        System.out.print("Enter a Pass ID: ");
        String passid = scan.next();
        System.out.print("Enter a Username or Email: ");
        String username = scan.next();
        System.out.print("Enter a Password: ");
        String password = scan.next();
        return new Password(passid,username,password);
    }
    
    //method for printing a message instructing a user enter the password id which they wish to remove.
    public String deletePassword() {
        System.out.print("Enter a Pass ID for a password you wish to remove:");
        String removePass = scan.next();
       
        return removePass;
    }
}
