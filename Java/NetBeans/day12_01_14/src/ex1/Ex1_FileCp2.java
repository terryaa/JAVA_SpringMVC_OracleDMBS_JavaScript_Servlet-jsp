/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex1_FileCp2 {
    public static void main(String[] args) {
        String path1="/Users/younghoonkim/Documents/jdk-8u191-macosx-x64.dmg";
        String path2="/Users/younghoonkim/Documents/jdk-8u191-macosx-x64_my.dmg";
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        
        
        try {
            bis=new BufferedInputStream(new FileInputStream(path1));
            bos=new BufferedOutputStream(new FileOutputStream(path2));
            int readV=0;
            while((readV=bis.read())!=-1){
            bos.write(readV);
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1_FileCp2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex1_FileCp2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
