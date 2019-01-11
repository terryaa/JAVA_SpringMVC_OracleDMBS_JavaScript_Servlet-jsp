/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author younghoonkim
 */
public class Ex1_File {
    public static void main(String[] args) {
        //First case
        //this path doesn't apply in Windows.
        String path="/Users/younghoonkim/Documents/JavaTest.docx";
        //make an instance of File class
        //doesnt make an error even if file in "path" doesnt exist.
        File f=new File(path);
        System.out.println("JavaTest exists? "+f.exists());
        if(f.exists()){
            System.out.println("Yes");
        }
        System.out.println("is 'javatest' a file?"+f.isFile());
        System.out.println("is it executable?"+f.canExecute());
        System.out.println("can you write in it?"+f.canWrite());
        System.out.println("absoulte path:"+f.getAbsolutePath());
        System.out.println("file name"+f.getName());
        System.out.println("is it a directory?"+f.isDirectory());
        System.out.println("?"+f.isDirectory());
        
        
        //this path doens't apply in Windows system
        File f2=new File("/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day11_01_11/src/ex2/aa.txt");
        if(!f2.exists()){
            try{
                System.out.println("Make aa");
                f2.createNewFile();//make new file
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        else
            System.out.println("already exists!");
        
        File f3=new File("/Users/younghoo"
                + "nkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day11_01_11/"
                + "src/ex2/work");
        if(!f3.exists()){
            f3.mkdirs();
        }else
            System.out.println("alredy exists!!"+f3.getAbsolutePath());
       
        
        
    }
}
