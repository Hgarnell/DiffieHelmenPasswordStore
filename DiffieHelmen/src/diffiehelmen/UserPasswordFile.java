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
import java.util.Map;

/**
 *
 * @author $Bernie Garnell
 */
public class UserPasswordFile extends FileAb implements FileRead, FileWrite {

    ArrayList<Password> passArrayList;
    int passcount;

    public UserPasswordFile(String string, FileReader fR, BufferedReader bR, PrintWriter pW) {
        super(string, fR, bR, pW);
        super.filePath = new File(string);
        passArrayList = new ArrayList<>();
        populateElements();
    }

    public UserPasswordFile(String string) {
        super(string);
        super.filePath = new File(string);
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
        for (Password p : passArrayList) {
            pW.println(p);
        }

        pW.close();

    }

    //Populate the usermap with users from the file
    @Override
    public void populateElements() {
        String line = null;
        try {
            while ((line = bR.readLine()) != null) {
                String[] stringParts = line.split("::");
                Password add = new Password(stringParts[0], stringParts[1], stringParts[2]);
                passArrayList.add(add);

            }
            super.bR.close();
        } catch (IOException e) {
            System.out.println("Error with File");
        }
    }

    @Override
    public boolean addElement(Object e) {
        try {
            Password newPass = (Password) e;

            boolean exists = false;
            for (Password pass : passArrayList) {
                if (pass.getPassId().equals(newPass.getPassId())) {
                    exists = true;
                }
            }
            if (exists == true) {
                System.out.println("A password with the pass ID of " + newPass.getPassId() + " already exists, cannot add it to the list");
                return false;
            }
            this.passArrayList.add(newPass);
            populateFile();
            return true;
        } catch (Exception ex) {
            System.out.println("You did not insert a Password Object to add to the file");
            return false;
        }
    }

    @Override
    public boolean removeElement(Object e) {

        try {
            Password removingPass = (Password) e;
            if (passArrayList.size() == 0) {
                System.out.println("No passwords to remove");
                return false;

            }
            for (int i = 0; i < passArrayList.size(); i++) {
                if (this.passArrayList.get(i).getPassId().equalsIgnoreCase(removingPass.getPassId())) {
                    this.passArrayList.remove(i);
                    System.out.println("Removed: " + removingPass);
                    populateFile();
                    return true;

                } else {
                }
            }
                System.out.println(removingPass + " not removed");
                return false;
            

        } catch (Exception l) {
            System.out.println("You did not insert a Password Object to remove from the file");

            return false;
        }
    }

    @Override
    public HashMap getHashMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getArrayList() {
        return this.passArrayList;
    }

    @Override
    public String toString() {
        String passString = "";
        for (Password p : passArrayList) {
            passString += p.toString() + "\n";
        }
        return passString;
    }

}
