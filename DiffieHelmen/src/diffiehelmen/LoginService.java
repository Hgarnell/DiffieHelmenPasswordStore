/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import static diffiehelmen.UserIntializer.getBigInt;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author $Bernie Garnell
 */
public class LoginService {

    Map<String, UserKey> storedUsers;
    ArrayList<String> adminList;
    FileAb userFile;
    FileAb adminFile;
    User currentUser;
    Scanner scan;

    /*
    Initializer for the loginService
     */
    public LoginService(FileAb userFileName, FileAb isadmin, Scanner scan) {
        userFile = userFileName;
        adminFile = isadmin;
        storedUsers = userFile.getHashMap();
        adminList = adminFile.getArrayList();
        this.scan = scan;
    }

    /*
    Method for logging in the user by taking in a user name and checking if it exists in the userListFile or adminList file. 
    Regardless if user exists or not it asks for a master pin number. This is on purpose to not disclose if the username
    is an actual username which could then lead to a brute force attack trying to guess an authenticated users password.
     */
    public User userLogin(String Username) {

        if (storedUsers.containsKey(Username)) {
            if (adminList.contains(Username)) {
                currentUser = new AdminUser(Username, storedUsers.get(Username));
            } else {
                currentUser = new GeneralUser(Username, storedUsers.get(Username));
            }
            if (validationProcess()) {
                System.out.println("Success");

                return currentUser;
            }
        } else {
            System.out.print("Master Pin: ");
            String temp = scan.next();
        }
        System.out.println("Incorrect Username or Password");
        return null;
    }

    /*
    Method for the validation proces. takes in a bigInt as the pin loops until a valid int is entered
    Returns true if matches the diffie hellman keyexchange shared key
    returns false if invalid
     */
    public boolean validationProcess() {
        boolean valid = false;
        int scanInput = 0;

        while (!(Pattern.matches("\\d{4}", String.valueOf(scanInput)))) {
            System.out.println("Enter a Maximum 4 digit pin number");
            System.out.print("Master Pin: ");

            try {
                scanInput = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please only enter a 4 digit number, try again");
                String temp = scan.nextLine();
            }

        }
        //testing
        return currentUser.getUserKeys().checkKey(getBigInt(scanInput));
    }
}
