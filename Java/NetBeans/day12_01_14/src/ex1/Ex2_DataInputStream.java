/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex2_DataInputStream {
    
    private String path;
    public Ex2_DataInputStream(){
        path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/ex2_memo.txt";
    }
    public void printDataStream(){
        try {
            DataInputStream dis=new DataInputStream(new FileInputStream(path));
            System.out.println("Integer : "+dis.readInt());
            System.out.println("Boolean : "+dis.readBoolean());
            System.out.println("Character : "+dis.readChar());
            System.out.println("Float : "+dis.readFloat());
            System.out.println("UTF : "+dis.readUTF());
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex2_DataInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex2_DataInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Ex2_DataInputStream().printDataStream();
    }
}
