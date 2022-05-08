/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author $Bernie Garnell
 */
interface FileRead {

    //method to read file
    public boolean readFile( );
    
    //populate class elements from file
    public void populateElements();

    //returns populated elements as a map
    public Map getHashMap();

    //returns populated elements as an arraylist
    public ArrayList getArrayList();

}
