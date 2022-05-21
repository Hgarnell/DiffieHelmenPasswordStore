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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanna
 */
public class diffieDatabase {

    Connection conn = null;
    String url = "jdbc:derby:DiffieDB   ;create=true";  //url of the DB host

    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";   //your DB password

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            try ( Statement statement = conn.createStatement()) {
                String userTableName = "Users";
                String passwordTableName = "Password";

                if (!checkTableExisting(userTableName)) {
                    statement.executeUpdate("CREATE TABLE " + userTableName + " (userID VARCHAR(12), username VARCHAR(32), ProgPublic INT ,UserPublic INT,Shared INT, isAdmin BOOLEAN)");
                }
                if (!checkTableExisting(passwordTableName)) {
                    statement.executeUpdate("CREATE TABLE " + passwordTableName + statement.executeUpdate("CREATE TABLE " + tableName + " (userID VARCHAR(32), PassID VARCHAR(32) ,Username VARCHAR(32),Password VARCHAR(60))"));
                }
                //statement.executeUpdate("INSERT INTO " + userTableName + " VALUES('Fiction',0),('Non-fiction',10),('Textbook',20)");
            }

        } catch (SQLException e) {
            System.out.println("error");

        }
    }

    public userData checkUser(String username, int password) {
        userData data = new userData();
        User tempUser;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, ProgPublic  ,UserPublic ,ProgPrivate , isAdmin FROM Users "
                    + "WHERE username = '" + username + "'");
            if (rs.next()) {
                //creating a userkey from keys stored
                UserKey uK = new UserKey((new Key(rs.getString("ProgPublic"))), (new Key(rs.getString("UserPublic"))), (new Key(rs.getString("ProgPrivate"))));
                //checking if isadmin boolean is true
                if (rs.getBoolean("isAdmin") == true) {
                    tempUser = new AdminUser(rs.getString("username"), uK);
                } else {
                    tempUser = new GeneralUser(rs.getString("username"), uK);
                }

                if (tempUser.getUserKeys().checkKey(getBigInt(password))) {

                    data.currentUser = tempUser;
                    data.loginFlag = true;
                } else {
                    data.loginFlag = false;
                }
            } else {
                System.out.println("no such user");
//              
                data.loginFlag = false;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProgramMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }

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
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    void logOut(int score, String username) {

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + score + " WHERE userid='" + username + "'");

        } catch (SQLException ex) {
        }

    }

    void addUser(User newUser) {

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Users "
                    + "VALUES('" + newUser.getUsername() + "', '" + newUser.getUserKeys().getPROG_PUBLIC() + "', '" + newUser.getUserKeys().getUSER_PUBLIC() + "', '" + newUser.getUserKeys().getSHARED_KEY() + "', '" + newUser.getIsAdmin() + "', 0)");
        } catch (SQLException ex) {
        }

    }

    void removeUser(User newUser) {

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM Users WHERE username ='" + newUser.getUsername() + "';");
            statement.executeUpdate("DELETE FROM Passwords WHERE username ='" + newUser.getUsername() + "';");

        } catch (SQLException ex) {
        }

    }

    public ArrayList<Password> getPasswords(User user) {
        ArrayList<Password> passwords = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT passID, passUser  ,Pass FROM Passwords "
                    + "WHERE username = '" + user.getUsername() + "'");
            if (rs.next()) {
                passwords.add(new Password(rs.getString("passID"),rs.getString("passUser"),rs.getString("Pass")));
            } else {
                System.out.println("User Has no Passwords");
            }
        } catch (SQLException ex) {
        }
        return passwords;
    }

}
