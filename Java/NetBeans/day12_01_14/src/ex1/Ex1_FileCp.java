/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author younghoonkim
 */
public class Ex1_FileCp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        long start=System.currentTimeMillis();
        String path1="/Users/younghoonkim/Documents/jdk-8u191-macosx-x64.dmg";
        String path2="/Users/younghoonkim/Documents/jdk-8u191-macosx-x64_my.dmg";
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try{
            int readV=0;
            
            while((readV=fis.read())!=-1){
                fos.write(readV);
            }
        }catch(FileNotFoundException ex){
        }
            catch(IOException ex){
            }
        finally{
            if(fis!=null) fis.close();
            if(fos!=null) fos.close();
                            
                            }
    }
    
}
