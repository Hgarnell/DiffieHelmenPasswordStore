/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.math.BigInteger;
import java.util.Random;

/**
 * Uses a Diffie Helmann key exchange equation to generate a new user key
 * @author $Bernie Garnell
 */
public class UserKeyGenerator {

    //Creates a new UserKey from a bigInteger
    public UserKey userKeyGenerator(BigInteger secret) {
        BigInteger p, g;
        
        Random rand = new Random();

        p = new BigInteger("541");
        g = new BigInteger("9");

        
        //generates program secret key
        BigInteger progSecret = new BigInteger((rand.nextInt(9999) + 1000) + "");
        
        Key userPublic = new Key(g, secret, p);
        Key progPublic = new Key(g, progSecret, p);
        Key SharedKey = new Key(userPublic.getKey(), progSecret, p);
                
        return  new UserKey(progPublic,userPublic,SharedKey);
    }
}
