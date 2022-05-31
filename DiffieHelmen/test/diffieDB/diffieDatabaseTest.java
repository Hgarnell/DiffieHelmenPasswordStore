/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package diffieDB;

import diffiehelmen.Password;
import diffiehelmen.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hanna
 */
public class diffieDatabaseTest {
    
    private diffieDatabaseTest diffieDatabaseTest;
    
    public diffieDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        diffieDatabaseTest = new diffieDatabaseTest();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dbsetup method, of class diffieDatabase.
     */
    @Test
    public void testDbsetup() {
        System.out.println("dbsetup");
        diffieDatabase instance = new diffieDatabase();
        instance.dbsetup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class diffieDatabase.
     */
    @Test
    public void testCheckUser() {
        System.out.println("checkUser");
        String username = "";
        Integer password = null;
        diffieDatabase instance = new diffieDatabase();
        userData expResult = null;
        userData result = instance.checkUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class diffieDatabase.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User newUser = null;
        diffieDatabase instance = new diffieDatabase();
        instance.addUser(newUser);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeUser method, of class diffieDatabase.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String k = "test";
        diffieDatabase instance = new diffieDatabase();
        boolean expResult = false;
        boolean result = instance.removeUser(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPasswords method, of class diffieDatabase.
     */
    @Test
    public void testGetPasswords() {
        System.out.println("getPasswords");
        User user = null;
        diffieDatabase instance = new diffieDatabase();
        String[][] expResult = null;
        String[][] result = instance.getPasswords(user);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserList method, of class diffieDatabase.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        diffieDatabase instance = new diffieDatabase();
        String[][] expResult = null;
        String[][] result = instance.getUserList();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePassword method, of class diffieDatabase.
     */
    @Test
    public void testRemovePassword() {
        System.out.println("removePassword");
        String string = "";
        String username = "";
        diffieDatabase instance = new diffieDatabase();
        boolean expResult = false;
        boolean result = instance.removePassword(string, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPassword method, of class diffieDatabase.
     */
    @Test
    public void testAddPassword() {
        System.out.println("addPassword");
        Password password = null;
        String username = "";
        diffieDatabase instance = new diffieDatabase();
        boolean expResult = false;
        boolean result = instance.addPassword(password, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
