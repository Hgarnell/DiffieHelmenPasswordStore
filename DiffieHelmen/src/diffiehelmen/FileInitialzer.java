/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author $Bernie Garnell
 */
public class FileInitialzer {

    protected FileReader fR;
    protected BufferedReader bR;
    protected PrintWriter pW;

    public FileInitialzer() {
    }

    public UserPasswordFile createUserPassWordFile(String string) {
        File filePath = new File(string);
        FileAb temp = new UserListFile(string);

        try {
            this.fR = new FileReader(filePath);
            this.bR = new BufferedReader(fR);
        } catch (Exception e) {
            System.out.println("Sorry, error reading file!");
        }
        return new UserPasswordFile(string, fR, bR, pW);
    }

    public isAdminFile createIsAdminFile(String string) {
        File filePath = new File(string);
        FileAb temp = new isAdminFile(string);
        try {
            this.fR = new FileReader(filePath);
            this.bR = new BufferedReader(fR);
        } catch (Exception e) {
            System.out.println("Sorry, error reading file!");
        }
        return new isAdminFile(string, fR, bR, pW);
    }

    public UserListFile createUserListFile(String string) {
        File filePath = new File(string);
        FileAb temp = new UserListFile(string);

        try {
            this.fR = new FileReader(filePath);
            this.bR = new BufferedReader(fR);
        } catch (Exception e) {
            System.out.println("Sorry, error reading file!");
        }
        return new UserListFile(string, fR, bR, pW);
    }
}
