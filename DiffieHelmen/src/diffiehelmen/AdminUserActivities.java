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
public class AdminUserActivities implements UserActivites {

    AdminUser currentUser;
    FileAb uPF;
    PasswordGenerator passGen;
    FileAb iAF;
    FileAb userListFile;
    FileAb isAdminFile;
    UserIntializer uI;
    Scanner scan;
    boolean running;
    String userAction;

    /**
     * Constructor for the AdminUser activity class; Creates a new userPassword
     * creates password file with the admin users name as the file name
     *
     */
    public AdminUserActivities(User user, PasswordGenerator passGen, isAdminFile isAdmin, UserIntializer userInit, UserListFile userListFile, Scanner scan, FileInitialzer fI) {
        this.currentUser = (AdminUser) user;
        this.uPF = fI.createUserPassWordFile(user.getUsername() + ".txt");
        this.passGen = passGen;
        this.iAF = isAdmin;
        this.uI = userInit;
        this.userListFile = userListFile;
        running = true;
        this.scan = scan;
        userAction = null;

    }

    /*
    Creates a new admin user
     */
    @Override
    public AdminUser createAdminUser(UserIntializer ui) {
        return ui.createAdmin();
    }

    /*
    Deletes users from the user list file, and also removes from the admin file if they are an admin
     */
    @Override
    public boolean deleteUser(String user) {
        if (iAF.getArrayList().contains(user)) {
            iAF.removeElement(user);
        }
        return userListFile.removeElement(user);
    }

    /*
    Calls password generator to create a new password to add the the user file. returns true if added succesfully
     */
    @Override
    public boolean createPassword() {
        Password creating = passGen.createPassword();
        boolean added = uPF.addElement(creating);
        if (added) {
            uPF.populateFile();
        }
        return added;
    }

    /*
    Deletes password from admin users password file, returns true if deleted succesfully
     */
    @Override
    public boolean deletePassword() {
        String removingPassID = passGen.deletePassword();
        Password removing = null;

        for (Object p : uPF.getArrayList()) {
            if (((Password) p).getPassId().equals(removingPassID)) {
                removing = (Password) p;
            } else {
            }
        }
        boolean removed = uPF.removeElement(removing);
        uPF.populateFile();
        return removed;
    }

    /*
    Shows user password file
     */
    @Override
    public void viewPassword() {
        System.out.println("");
        System.out.println("=========== Password List =============");
        System.out.println("PassID : Username : Password");
        System.out.println((UserPasswordFile) uPF);
        System.out.println("=========== Password List =============");
        System.out.println("");

    }

    /* 
    Displays options user has for user activities. 
    Continues running until user enters x to exit
     */
    @Override
    public void userOptions() {
        String userAction;
        while (running) {

            //Show Admin User passwords
            viewPassword();
            //Show Admin User activity options
            System.out.println("A - Create New Admin User");
            System.out.println("U - Remove User");
            System.out.println("C - Create New Password");
            System.out.println("R - Remove Old Password");
            System.out.println("X - Exit");
            System.out.print("-> ");

            //scan in input and translate to upper so it matches switch cases
            userAction = scan.next().toUpperCase();

            //loop to scan through invalid input 
            while (!userAction.equals("A") && !userAction.equals("U") && !userAction.equals("R") && !userAction.equals("C") && !userAction.equals("X")) {
                System.out.println("Invalid Input, please only input \'A\',\'U\',\'C\', \'R\' or \'X\'");
                System.out.print("-> ");
                userAction = scan.next().toUpperCase();;

            }
            switch (userAction) {
                //if A call createAdminUser method and create a new admin user
                case "A":
                    User newUser = createAdminUser(uI);
                    if (userListFile.addUser(newUser)) {
                        iAF.addElement(newUser.getUsername());
                        System.out.println(newUser.getUsername() + " added succesfully");
                        System.out.println("========================");
                    } else {
                        System.out.println("Error in creating a new Admin User");
                        System.out.println("========================");

                    }
                    System.out.println("");
                    break;

                //if U print out current users usernames from userListFile and delete if admin inputed username matches
                case "U":
                    System.out.println("================================");
                    System.out.println("List of current Users");
                    userListFile.getHashMap().forEach(
                            (key, value) -> System.out.println(key));

                    System.out.println("");
                    System.out.println("Enter the username of the user you wish to remove");
                    String deleting = scan.next();
                    if (!(currentUser.getUsername().equalsIgnoreCase(deleting)) && deleteUser(deleting)) {
                        System.out.println("User removed Sucessfully");
                    } else {
                        System.out.println("User could not be deleted, make sure its a valid username and not yourself!");
                    }
                    break;

                //If C call createpassword method and say if password has been created succesfully
                case "C":
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
                    if (createPassword()) {
                        System.out.println("Password Created Succfully");
                    } else {
                        System.out.println("Password unable to be created");
                    }
                    break;

                // if R call delete password method and say if password has been deleted succesfully
                case "R":
                    if (deletePassword()) {
                        System.out.println("Password Deleted Succesfully");
                    } else {
                        System.out.println("Password unable to be Deleted");
                    }
                    break;

                // default but also output if user quits
                default:
                    System.out.println("Exiting Admin User Activities");
            }

            //Set run to false to stop the loop once user inputs X as input
            if (userAction.equals("X")) {
                running = false;

            }
        }
    }
}
