/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex1_FileReWriteMain {
    private Ex1_FileReWrDemo efr;
    public Ex1_FileReWriteMain(){
        efr=new Ex1_FileReWrDemo();
    }
    
    public void execWriter(String memo){
        efr.writeMemo(memo);
    }
    public void execReader(){
        try {
            ArrayList<String> aryList=efr.getMemo();
            for(String e  : aryList){
                System.out.println(e);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Ex1_FileReWriteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("memo:");
        Ex1_FileReWriteMain mains=new Ex1_FileReWriteMain();
        String memo=sc.nextLine();
        mains.execWriter(memo);
        mains.execReader();
    }
    
}
