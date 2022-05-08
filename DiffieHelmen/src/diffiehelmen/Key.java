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
public class Key {

    BigInteger key;

    public Key(BigInteger a, BigInteger b, BigInteger c) {
        key = a.modPow(b, c);
    }

    public Key(String string)
    {
          this.key = new BigInteger(Integer.toString(Integer.valueOf(string)));
    }
    /**
     * @return the key
     */
    public BigInteger getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return this.key.toString();

    }
    
    @Override
    public boolean equals(Object o)
    {
        boolean k = (this.key.toString().equals(o.toString()));
        return k;
    }
}
