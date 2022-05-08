/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author $Bernie Garnell
 */
public class isAdminFile extends FileAb implements FileRead, FileWrite {

    ArrayList<String> isAdminList;

    public isAdminFile(String string, FileReader fR, BufferedReader bR, PrintWriter pW) {
        super(string, fR, bR, pW);
        filePath = new File(string);

        //initialize the isadminList
        isAdminList = new ArrayList<>();
        populateElements();

    }

    public isAdminFile(String string) {

        super(string);
        super.filePath = new File(string);
        //creates a new file with the inputted string

        readFile();
    }

    //Read file and check if empty, if it is then create a new file if not then read the file and load into file reader
    @Override
    public boolean readFile() {

        try {//checking if filepath does not exist
            if (filePath.length() == 0) {
                filePath.createNewFile();

                return false;
            } else {

                return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File  not found.");
        } catch (IOException e) {
            System.out.println("File  not found.");
        }
        return false;
    }

    //Update the file with the current map of users
    @Override
    public void populateFile() {
        try {
            this.pW = new PrintWriter(new FileOutputStream(filePath));
        } catch (Exception e) {
        }

        for (String s : isAdminList) {
            pW.println(s);
        }

        pW.close();

    }

    //Populate the usermap with users from the file
    @Override
    public void populateElements() {
        String line = "";

        try {
            while ((line = bR.readLine()) != null) {
                isAdminList.add(line);
            }
            super.bR.close();
        } catch (IOException e) {
            System.out.println("Error with File");
        }
    }

    @Override
    public boolean addElement(Object e) {
        try {
            String admin = (String) e;

            boolean exists = false;
            for (String s : isAdminList) {
                if (s.equals(e)) {
                    exists = true;
                }
            }
            if (exists == true) {
                System.out.println("Admin" + admin + " already exists, cannot add it to the list");
                return false;
            }
            this.isAdminList.add(admin);
            populateFile();
            return true;
        } catch (Exception ex) {
            System.out.println("You did not insert a String Object to add to the file");
            return false;
        }
    }

    @Override
    public boolean removeElement(Object e) {

        String line = null;
        boolean found;
        if (e instanceof String) {
            String removingAdmin = (String) e;
            if (isAdminList.size() == 0) {
                System.out.println("No Admins to remove");
                return false;

            }
            for (int i = 0; i < isAdminList.size(); i++) {
                if (isAdminList.get(i).equalsIgnoreCase(removingAdmin)) {
                    isAdminList.remove(i);
                    System.out.println("Removed: " + removingAdmin);
                    populateFile();
                    return true;

                } else {
                    System.out.println(removingAdmin + " not removed");
                    return false;

                }

            }

        } else {
            System.out.println("You did not insert a String Object to remove from the file");

            return false;
        }
        return false;
    }

    @Override
    public HashMap getHashMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getArrayList() {
        return this.isAdminList;
    }

    @Override
    public String toString() {
        String adminString = "";
        for (String s : isAdminList) {
            adminString += s + "\n";
        }
        return adminString;
    }

}
