/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex3_ObjectInputStream {
    String path;
    public Ex3_ObjectInputStream(){
        path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/ex3_obj.txt";
    }
    public void printObjectStream(){
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
            Ex3_Member mem= (Ex3_Member) ois.readObject();
            System.out.println(mem.getId());
            System.out.println(mem.getPwd());
            System.out.println(mem.getAge());
            System.out.println(mem.getName());
            System.out.println(mem.getPay());
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex3_ObjectInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex3_ObjectInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ex3_ObjectInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public static void main(String[] args) {
        new Ex3_ObjectInputStream().printObjectStream();
    }
    
}
