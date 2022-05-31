/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diffieDB;

/**
 *
 * @author hanna
 */
import diffiehelmen.*;
import static diffiehelmen.UserIntializer.getBigInt;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanna
 */
public class diffieDatabase {

    Connection conn = null;
    String url = "jdbc:derby:DiffieDB;create=true";  //url of the DB host

    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";   //your DB password

    //EMBEDDED db SETUP                                                                                                                                                                                
    public void dbsetup() {
        try {

            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();

            String userTableName = "Users";
            String passwordTableName = "Password";

            if (!checkTableExisting(userTableName)) {
                statement.executeUpdate("CREATE TABLE " + userTableName + " ( username VARCHAR(32), ProgPublic INT ,UserPublic INT,Shared INT, isAdmin BOOLEAN)");
            }
            if (!checkTableExisting(passwordTableName)) {
                statement.executeUpdate("CREATE TABLE " + passwordTableName + statement.executeUpdate("CREATE TABLE " + passwordTableName + " (username VARCHAR(32), passID VARCHAR(32) ,passUser VARCHAR(32),Pass VARCHAR(60))"));
            }
            //statement.executeUpdate("INSERT INTO " + userTableName + " VALUES('Fiction',0),('Non-fiction',10),('Textbook',20)");
            statement.close();

        } catch (Throwable e) {
            System.out.println("Issue with setting up the Database");

        }
    }

    //check if user exists with int password
    public userData checkUser(String username, Integer password) {
        System.out.println("entered check user data");
        userData data = new userData();
        User tempUser;

        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT username, ProgPublic  ,UserPublic ,Shared , isAdmin FROM Users "
                    + "WHERE username = '" + username + "'");
            if (rs.next()) {
                //creating a userkey from keys stored
                UserKey uK = new UserKey((new Key(rs.getString("ProgPublic"))), (new Key(rs.getString("UserPublic"))), (new Key(rs.getString("Shared"))));
                //checking if isadmin boolean is true
                if (rs.getBoolean("isAdmin") == true) {
                    tempUser = new AdminUser(rs.getString("username"), uK);
                    data.userMap = getUserList();
                } else {
                    tempUser = new GeneralUser(rs.getString("username"), uK);
                    data.userMap = null;
                }
                System.out.println(tempUser.getUserKeys().checkKey(getBigInt(password)));
                // System.out.println(data.userMap.toString());
                if (tempUser.getUserKeys().checkKey(getBigInt(password))) {
                    data.currentUser = tempUser;
                    data.passArrayList = getPasswords(tempUser);
                    data.userMap = getUserList();
                    data.loginFlag = true;
                } else {
                    data.loginFlag = false;
                }
            } else {
                System.out.println("no such user");
                data.loginFlag = false;
            }
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProgramMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }

    //check if the tables exist with a string new name
    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }

            rsDBMeta.close();

        } catch (SQLException ex) {
        }
        return flag;
    }

    //add a user to the database
    boolean addUser(User newUser) {

        try {
            if (!containsUser(newUser.getUsername())) {
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO Users VALUES('" + newUser.getUsername() + "', " + newUser.getUserKeys().getPROG_PUBLIC().getKey() + ", " + newUser.getUserKeys().getUSER_PUBLIC().getKey() + ", " + newUser.getUserKeys().getSHARED_KEY().getKey() + ", " + newUser.getIsAdmin() + ")");
                statement.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL error");
        }
        return false;
    }

    //remove user where username matches the string
    boolean removeUser(String k) {

        try {
            System.out.println("REMOVE USER");
            System.out.println(k);
            Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM Users WHERE username = '" + k + "'");
            statement.executeUpdate("DELETE FROM Password WHERE username = '" + k + "'");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }

    //returns list of passwords where the users username matches
    public String[][] getPasswords(User user) {
        ArrayList<Password> passwords = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT passID, passUser  ,Pass FROM Password "
                    + "WHERE username = '" + user.getUsername() + "'");
            while (rs.next()) {
                passwords.add(new Password(rs.getString("passID"), rs.getString("passUser"), rs.getString("Pass")));
            }
        } catch (SQLException ex) {
        }

        String[][] passArray = new String[passwords.size()][3];
        int k = 0;
        for (Password p : passwords) {
            passArray[k][0] = p.getPassId();
            passArray[k][1] = p.getUsername();
            passArray[k][2] = p.getPassword();
            k++;
        }
        return passArray;
    }

    //return list of users and if they are admin
    public String[][] getUserList() {
        Map<String, Boolean> users = new HashMap<>();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT username, isAdmin FROM Users");
            while (rs.next()) {
                users.put(rs.getString("username"), rs.getBoolean("isAdmin"));
            }
        } catch (SQLException ex) {
        }
        String[][] userArray = new String[users.size()][2];
        int k = 0;
        for (String usernames : users.keySet()) {
            userArray[k][0] = users.get(usernames).toString();

            userArray[k][1] = usernames;

            k++;
        }
        return userArray;
    }

    //remove password from the database through getting the passID
    boolean removePassword(String string, String username) {
        System.out.println("db remove pass entered");
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM Password WHERE passID ='" + string + "' AND username ='" + username + "'");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Check that pass ID Matches.......");
            return false;

        }

    }

    boolean addPassword(Password password, String username) {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT passID FROM Password WHERE passID ='" + password.getPassId() + "'");

            if (!rs.next()) {
                statement.executeUpdate("INSERT INTO Password "
                        + "VALUES('" + username + "','" + password.getPassId() + "', '" + password.getUsername() + "', '" + password.getPassword() + "')");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Check that pass ID Matches.......");
        }
        return false;
    }

    boolean containsUser(String username) {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Username FROM Users WHERE Username ='" + username + "'");

            return rs.next();

        } catch (SQLException ex) {

        }
        return false;
    }
}
