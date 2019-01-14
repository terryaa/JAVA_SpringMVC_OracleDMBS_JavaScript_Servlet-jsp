/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex3_ObjectStream {
    public static void main(String[] args) {
        String path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/ex3_obj.txt";
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
            Ex3_Member v=new Ex3_Member();
            v.setId("xman");
            v.setPwd("1");
            v.setAge(30);
            v.setName("Gildong");
            v.setPay(2000);
            oos.writeObject(v);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex3_ObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex3_ObjectStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
