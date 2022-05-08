/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.math.BigInteger;

/**
 *
 * @author $Bernie Garnell
 */
public class UserKey {

    final private Key PROG_PUBLIC;
    final private Key USER_PUBLIC;
    final private Key SHARED_KEY;
    final private BigInteger p;

    public UserKey(Key pP, Key uP, Key sK) {
        this.PROG_PUBLIC = pP;
        this.USER_PUBLIC = uP;
        this.SHARED_KEY = sK;
        this.p = new BigInteger("541");
    }

    public Key getPROG_PUBLIC() {
        return PROG_PUBLIC;
    }

    public Key getUSER_PUBLIC() {
        return USER_PUBLIC;
    }

    public Key getSHARED_KEY() {
        return SHARED_KEY;
    }

    /*Checks if the secret BigInteger is the valid Key for this UserKey set
    by performing the diffie helman key exchange, when the user inputs their secret pin 
    progpublic ^ usersecret % p should return the same value as userpublic ^ programsecret %p
     */
    public boolean checkKey(BigInteger secret) {
        Key temp = new Key((PROG_PUBLIC.getKey()), secret, p);
        return this.SHARED_KEY.equals(temp);
    }
}
