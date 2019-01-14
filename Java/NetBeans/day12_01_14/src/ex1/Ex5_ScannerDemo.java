/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex5_ScannerDemo {
    public static void main(String[] args) {
        String path2="https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EB%9D%BC%EC%9D%B4%ED%84%B0";
     
     
     URL url;
        try {
            url = new URL(path2);
            Scanner sc=new Scanner(url.openStream(),"UTF-8");
            String rdv=null;
            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ex5_ScannerDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex5_ScannerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
     
    
}
