/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex2_DataOutputStream {
    private String path;
    public Ex2_DataOutputStream(){
        path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/ex2_memo.txt";
    }
    
    public void dataWrite(){
        //without .close() and .flush()  runs fine with JDF 8 or after.
        //it automatically executes .close() to flush and delete stream. 
        try {
            DataOutputStream dos=new DataOutputStream(new FileOutputStream(path));
            //sequence is very important
            dos.writeInt(10);
            dos.writeBoolean(true);
            dos.writeChar('A');
            dos.writeFloat(10.5f);
            dos.writeUTF("MYTEST");
                    
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex2_DataOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex2_DataOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Ex2_DataOutputStream().dataWrite();
    }
}
