/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex2_FileOutputStreamDemo {
    public static void main(String[] args) {
        String path="/Users/younghoonkim/Documents/JavaTest.txt";
            FileOutputStream fos=null;
        try {
            
            fos=new FileOutputStream(path,false);
            try {
                fos.write(66);
                fos.write(65);
            } catch (IOException ex) {
                Logger.getLogger(Ex2_FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex2_FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }finally{
            if(fos!=null)
                try {
                    fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Ex2_FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
    }
}
