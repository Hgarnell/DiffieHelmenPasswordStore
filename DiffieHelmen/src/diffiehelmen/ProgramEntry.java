/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author $Bernie Garnell
 */
public class ProgramEntry {
    Scanner scan;
    User current;
    boolean running;
    UserListFile ulf;
    LoginService lS;
    PasswordGenerator pG;
    UserActivites uA;
    isAdminFile iAF;
    UserIntializer uI;
    FileInitialzer fI;
    File filePath;
    String userAction;

    public ProgramEntry(Scanner scan) {
        this.scan = scan;
        fI = new FileInitialzer();
        uI = new UserIntializer(scan);
        pG = new PasswordGenerator(scan);
        userAction = null;
        ulf = fI.createUserListFile("./userList.txt");
        iAF = fI.createIsAdminFile("./adminlist.txt");

        current = null;
        running = true;

        lS = new LoginService(ulf, iAF, scan);

        if (iAF.isAdminList.isEmpty()) {
            System.out.println("========ERROR: No ADMIN users======");
            System.out.println("There are no admin users.");
            System.out.println("Please create an Admin account before continuing!");
            System.out.println("Note: your master pin cannot be changed or recovered at any point or time.");

            this.current = this.uI.createAdmin();
            this.iAF.addElement(current.getUsername());
            if (ulf.addUser(current)) {

                System.out.println(current.getUsername() + " created succesfully");
                System.out.println("========================");
            } else {
                System.out.println("Error in creating a new Admin User");
                System.out.println("========================");

            }
        }

        while (running) {
            running = userOptions();
        }

    }

    public boolean userOptions() {
        System.out.println("========================");
        System.out.println("");
        System.out.println("L - Login");

        System.out.println("C - Create New User");
        System.out.println("X - Exit");
        System.out.print("-> ");

        userAction = scan.next().toUpperCase();;
        while (!userAction.equals("L") && !userAction.equals("C") && !userAction.equals("X")) {
            System.out.println("Invalid Input, please only input \'L\',\'C\' or \'X\'");
            System.out.print("-> ");
            userAction = scan.next().toUpperCase();;

        }
        System.out.flush();
        switch (userAction) {
            case "L":
                System.out.println("");
                //input later for login
                System.out.print("Username: ");
                //scan.nextLine();
                String tempUsername = scan.next();

                current = lS.userLogin(tempUsername);

                if (current != null) {
                    System.out.flush();

                    if (current.getIsAdmin()) {
                        uA = new AdminUserActivities(current, pG, iAF, uI, ulf, scan, fI);
                        uA.userOptions();
                    } else {
                        uA = new GeneralUserActivities(current, pG, scan, fI);
                        uA.userOptions();
                    }
                }
                break;
            case "C":
                //input later for create
                System.out.println("You Have chosen to Create an New Account");
                System.out.println("Note: your master pin cannot be changed or recovered at any point or time.");
                if (iAF.getArrayList().isEmpty()) {
                    this.current = this.uI.createAdmin();
                    this.iAF.addElement(current.getUsername());

                } else {
                    this.current = this.uI.createGenUser();
                }
                if (ulf.addUser(current)) {
                    System.out.println(current.getUsername() + " created succesfully");
                    System.out.println("========================");
                } else {
                    System.out.println("Error in creating a new User");
                    System.out.println("========================");

                }
                break;
            default:
                System.out.println("Exiting the Diffie Hellman Password Program");
        }

        if (userAction.equals("X")) {
            return false;
        } else {
            return true;
        }

    }
}
