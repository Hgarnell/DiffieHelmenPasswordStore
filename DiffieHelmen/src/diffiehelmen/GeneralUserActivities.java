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
public class GeneralUserActivities implements UserActivites {

    GeneralUser currentUser;
    UserPasswordFile file;
    PasswordGenerator passGen;
    Scanner scan;
    String userAction;

    boolean running;

    public GeneralUserActivities(User user, PasswordGenerator passGen, Scanner scan, FileInitialzer fI) {
        this.currentUser = (GeneralUser) user;
        this.file = fI.createUserPassWordFile(user.getUsername() + ".txt");
        this.passGen = passGen;
        this.scan = scan;
        running = true;
        userAction = null;
    }

    /* 
    Not suported for general users
     */
    @Override
    public AdminUser createAdminUser(UserIntializer ui) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* 
    Not suported for general users
     */
    @Override
    public boolean deleteUser(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Calls password generator to create a new password to add the the user file. returns true if added succesfully
     */
    @Override
    public boolean createPassword() {
        Password creating = passGen.createPassword();
        boolean added = file.addElement(creating);
        if (added) {
            file.populateFile();
        }
        return added;
    }

    /*
    returns true if users password is deleted succesfully from the password list
     */
    @Override
    public boolean deletePassword() {
        String removingPassID = passGen.deletePassword();
        Password removing = null;

        for (Password p : file.passArrayList) {
            if (p.passId.equals(removingPassID)) {
                removing = p;
            } else {
            }
        }
        boolean removed = file.removeElement(removing);
        file.populateFile();
        return removed;
    }

    /*
    Prints out the user passwords from their password file
     */
    @Override
    public void viewPassword() {
        System.out.println("");
        System.out.println("=========== Password List =============");
        System.out.println("PassID : Username : Password");
        System.out.println((UserPasswordFile) file);
        System.out.println("=========== Password List =============");
        System.out.println("");

    }

    /* 
    Displays options user has forf user activities. 
    Continues running until user enters x to exit
     */
    public void userOptions() {

        while (running) {
            viewPassword();
            System.out.println("C - Create New Password");
            System.out.println("R - Remove Old Password");
            System.out.println("X - Exit");
            System.out.print("-> ");

            userAction = scan.next().toUpperCase();
            while (!userAction.equals("R") && !userAction.equals("C") && !userAction.equals("X")) {
                System.out.println("Invalid Input, please only input \'C\',\'R\' or \'X\'");
                System.out.print("-> ");
                userAction = scan.next().toUpperCase();;

            }
            switch (userAction) {
                case "C":
                    System.out.println("");
                    System.out.println("=========== Password Creation =============");
                    System.out.println("Pass ID: This can be the website name, or a ");
                    System.out.println("code to remember the password by. It should be");
                    System.out.println("Unique and not repeated");
                    System.out.println("Username/Email: Your username or email for the password.");
                    System.out.println("This can be repeated and not unique");
                    System.out.println("Password: The desired passwords. We reconmend that your password");
                    System.out.println("is eight or more characters long, unique and has different");
                    System.out.println("character types.");
                    System.out.println("");

                    createPassword();
                    break;
                case "R":
                    deletePassword();
                    break;
                default:
                    System.out.println("Exiting!");
            }
            if (userAction.equals("X")) {
                running = false;

            }
        }
    }
}
