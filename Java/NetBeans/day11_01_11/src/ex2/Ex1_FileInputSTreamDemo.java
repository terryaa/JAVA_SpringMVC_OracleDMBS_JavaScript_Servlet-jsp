/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex1_FileInputSTreamDemo {
    
    public static void main(String[] args) {
        //InputStream actually reads information inside file, so 
        //wrong path gives out an error. 
        String path="/Users/younghoonkim/Documents/JavaTest.docx";
        
        
        //FileInputStrea is first-class stream/byte stream.
        //Why fis is defined outside try?
        FileInputStream fis=null;
        
       try {
             fis=new FileInputStream(path);
             int rdv=0;
             //while statment reads from a file's start to EOF 1byte by 1byte.
             //EOF returns -1
             while((rdv=fis.read())!=-1){
                 System.out.println((char)rdv);
             }
             //when file doens't exists
        } catch (FileNotFoundException ex) {
            System.out.println("File doens't exists!");
        } catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Error while reading contents of file");
        } finally{
           if(fis!=null){
               try {
                   fis.close();
               } catch (IOException ex) {
                  ex.printStackTrace();
               }
           }
       }
      
       
        
        
    }
    
}
