/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex2_SocketClientDemo {
    private Socket s;
    public Ex2_SocketClientDemo(String host,int port){
        try {
            s=new Socket(host,port);
            System.out.println("succeed");
            
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            
           
            String msg="hihi";
            PrintWriter pw=new PrintWriter(os,true);
            pw.println(msg);
            
            Scanner sc=new Scanner(is);
            System.out.println("From server:"+sc.nextLine());
            
            if(!s.isClosed())
            {
                pw.close();
                s.close();
            }
        } catch (IOException ex) {
            System.out.println("server connection error");
            Logger.getLogger(Ex2_SocketClientDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new Ex2_SocketClientDemo("192.168.0.110", 9999);
    }
    
}
