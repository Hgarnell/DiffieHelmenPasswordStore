
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author $Bernie Garnell
 */
public class UserIntializer extends UserKeyGenerator {

    Scanner scan;

    public UserIntializer(Scanner scan) {
        this.scan = scan;
    }

    public AdminUser createAdmin() {
        String username;
        BigInteger secret;
        int scanInput = 0;

        AdminUser newUser;

        boolean valid = false;

        //Getting User username
        System.out.println("");
        System.out.print("Enter a Username: ");
        username = scan.next();
        //Now asking user for a 4 digit master pin
        secret = getBigInt(getPin());

        newUser = new AdminUser(username, this.userKeyGenerator(secret));

        return newUser;
    }

    public GeneralUser createGenUser() {
        String username;
        BigInteger secret;

        GeneralUser newUser;

        boolean valid = false;

        System.out.println("");

        //Getting User username
        System.out.print("Enter a Username: ");
        username = scan.next();

        //Now asking user for a 4 digit master pin
        secret = getBigInt(getPin());

        newUser = new GeneralUser(username, this.userKeyGenerator(secret));
        return newUser;
    }

    public static BigInteger getBigInt(int scanInput) {

        BigInteger x = new BigInteger(Integer.toString(scanInput));
        return x;
    }
    
    public static BigInteger getBigInt(Integer scanInput) {

        BigInteger x = new BigInteger(Integer.toString(scanInput));
        return x;
    }

    public int getPin() {
        int scanInput = 0;

        while (!(Pattern.matches("\\d{4}", String.valueOf(scanInput)))) {
            System.out.print("Enter a Maximum 4 digit pin number:");

            try {
                scanInput = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please only enter a 4 digit number, try again");
                String temp = scan.nextLine();
            }

        }
        return scanInput;
    }
}
