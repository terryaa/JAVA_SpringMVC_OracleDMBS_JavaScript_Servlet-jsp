/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex6_PrintWriter {
    public static void main(String[] args) {
        PrintWriter pw=null;
        
        String path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/memo3.txt";
        try {
            //Second parameter dictates that it autoflushes the buffer
            pw=new PrintWriter(new FileOutputStream(path),true);
            pw.println("Hi. Nice to meet you");
            //pw.flush();  //authflush options will do the same anyway.
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex6_PrintWriter.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            pw.close();// recommended to put close in finally 
        }
    }
    
}
