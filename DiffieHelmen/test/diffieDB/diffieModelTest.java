/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package diffieDB;

import diffiehelmen.AdminUser;
import diffiehelmen.GeneralUser;
import diffiehelmen.Key;
import diffiehelmen.User;
import diffiehelmen.UserKey;
import java.math.BigInteger;
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
public class diffieModelTest {

    private diffieModelTest diffieModelTest;
    public diffieModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        diffieModelTest = new diffieModelTest();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkUser method, of class diffieModel.
     */
    @Test
    public void testCheckUser() {
        System.out.println("checkUser");
        String username = "";
        Integer masterpin = 2222;
        diffieModel instance = new diffieModel();
        boolean expResult = false;
        boolean result = instance.checkUser(username, masterpin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    } 

    @Test
    public void testBadPinUser() {
        System.out.println("addUser");
        String username = "testAdmin";
        String secret = "test";
        Boolean isAdmin = true;
        diffieModel instance = new diffieModel();
        boolean expResult = false;
        boolean result = instance.addUser(username, secret, isAdmin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addPass method, of class diffieModel.
     */
    @Test
    public void testAddPass() {
        System.out.println("addPass");
        User user = testUserGen();
        String passID = "test";
        String passUsername = "test";
        String password = "test";
        diffieModel instance = new diffieModel();
        boolean expResult = false;
        boolean result = instance.addPass(user, passID, passUsername, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testAddBadPass() {
        System.out.println("addPass");
        User user = testUserGen();
        String passID = " ";
        String passUsername = " ";
        String password = "test";
        diffieModel instance = new diffieModel();
        boolean expResult = false;
        boolean result = instance.addPass(user, passID, passUsername, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testAddDouble() {
        System.out.println("addPass");
        User user = testUserGen();
        String passID = "test";
        String passUsername = "test";
        String password = "test";
        diffieModel instance = new diffieModel();
        boolean expResult = false;
        instance.addPass(user, passID, passUsername, password);
        boolean result = instance.addPass(user, passID, passUsername, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

//    /**
//     * Test of updateTables method, of class diffieModel.
//     */
//    @Test
//    public void testUpdateTables() {
//        System.out.println("updateTables");
//        diffieModel instance = new diffieModel();
//        instance.updateTables();
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of quitGame method, of class diffieModel.
//     */
//    @Test
//    public void testQuitGame() {
//        System.out.println("quitGame");
//        diffieModel instance = new diffieModel();
//        instance.quitGame();
//        // TODO review the generated test code and remove the default call to fail.
//    }
//    
    public User testUserGen() {
        Key k = new Key(new BigInteger("2"), new BigInteger("2"), new BigInteger("2"));
        return (new GeneralUser("test", new UserKey(k, k, k)));

    }

}
