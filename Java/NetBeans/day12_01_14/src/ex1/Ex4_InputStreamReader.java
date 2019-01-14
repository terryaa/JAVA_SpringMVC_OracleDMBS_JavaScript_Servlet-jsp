/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex4_InputStreamReader {
    
    public static void main(String[] args) {
        BufferedReader br=null;
           String path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/memo.txt";
           String path2="https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EB%9D%BC%EC%9D%B4%ED%84%B0";
        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            Scanner sc;
            //There's need to read ByteStream in form of String stream.
            //In this case we use BridgeStream to change bytestream to stringstream.
            //**Practice : use  Scanner API and create class Ex5_ScannerDemo, which
            //has same functions as this class.
            String str=null;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex4_InputStreamReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex4_InputStreamReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        URL url;
        try {
            url = new URL(path2);
            br=new BufferedReader(new InputStreamReader(url.openStream(),"euc-kr"));
            PrintWriter prit;
            String str=null;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ex4_InputStreamReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ex4_InputStreamReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    
    }
 
    
}
