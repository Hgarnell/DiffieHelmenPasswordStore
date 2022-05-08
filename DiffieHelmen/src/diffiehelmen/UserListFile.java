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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $Bernie Garnell
 */
public class UserListFile extends FileAb implements FileRead, FileWrite {

    private Map<String, UserKey> userMap;

    public UserListFile(String string, FileReader fR, BufferedReader bR, PrintWriter pW) {
        super(string, fR, bR, pW);
        userMap = new HashMap<>();
        filePath = new File(string);

        populateElements();

    }

    public UserListFile(String string) {

        super(string);
        filePath = new File(string);

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
        for (Map.Entry<String, UserKey> entry : userMap.entrySet()) {
            super.pW.println(entry.getKey() + ":" + entry.getValue().getPROG_PUBLIC() + ":" + entry.getValue().getUSER_PUBLIC() + ":" + entry.getValue().getSHARED_KEY());
        }
        super.pW.close();

    }

    //Populate the usermap with users from the file
    @Override
    public void populateElements() {
        String line = "";
        try {
            while ((line = bR.readLine()) != null) {
                String[] stringParts = line.split(":");
                UserKey keys = new UserKey(new Key(stringParts[1]), new Key(stringParts[2]), new Key(stringParts[3]));
                userMap.put(stringParts[0], keys);
            }
            super.bR.close();
        } catch (IOException e) {
            System.out.println("Error with File");
        }

    }

    public boolean addUser(User e) {

        try {
            User adding = (User) e;
            if (!userMap.containsKey(e.getUsername())) {
                userMap.put(adding.getUsername(), adding.getUserKeys());
                populateFile();
                return true;
            } else {
                System.out.println("This user already exists, cannot be added ");
                return false;
            }
        } catch (Exception x) {
            System.out.println("Error with input of the user");
        }
        return false;
    }

    @Override
    public boolean removeElement(Object e) {
        String line = null;
        try {
            if (userMap.containsKey(e)) {
                userMap.remove(e);
                System.out.println("Removed: " + e);
                this.populateFile();
                return true;
            } else {
                System.out.println(e + " not removed");
                return false;
            }
        } catch (Exception d) {
            System.out.println("User " + e + " not found");
            return false;

        }

    }

    @Override
    public ArrayList getArrayList() {
        ArrayList<User> userArray;
        userArray = new ArrayList<>();

        userMap.forEach(
                (key, value)
                -> userArray.add(new GeneralUser(key, value)));
        return userArray;
    }

    @Override
    public Map<String, UserKey> getHashMap() {
        return this.userMap;
    }

    // not supported by this class
    @Override
    public boolean addElement(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
