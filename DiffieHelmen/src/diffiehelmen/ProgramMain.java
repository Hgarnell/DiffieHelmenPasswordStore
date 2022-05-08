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
public class ProgramMain {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========== Diffie Hellman Password Vault =============");
        System.out.println("Welcome to the Diffie Hellman password Vault!");
        System.out.println("User Pin numbers are created and stored using a ");
        System.out.println("Diffie Hellman Key exchange. To get started");
        System.out.println("Please select one of the following options:");
        ProgramEntry entry = new ProgramEntry(scan);

    }
}
