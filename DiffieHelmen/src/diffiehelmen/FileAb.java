/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiehelmen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author $Bernie Garnell
 */
abstract public class FileAb implements FileRead, FileWrite {

    protected String fileString;
    protected File filePath;
    protected FileReader fR;
    protected BufferedReader bR;
    protected PrintWriter pW;

    //Constructor
    public FileAb(String string, FileReader fR, BufferedReader bR, PrintWriter pW) {
        this.fR = fR;
        this.bR = bR;
        this.pW = pW;
        this.fileString = string;
    }

    public FileAb(String string) {

    }

    public boolean addElement(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removeElement(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
}
