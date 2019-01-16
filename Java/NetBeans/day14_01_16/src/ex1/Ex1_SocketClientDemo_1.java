/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex1_SocketClientDemo_1 {
    private Socket s;
    public Ex1_SocketClientDemo_1(String host,int port){
        try {
            s=new Socket(host,port);
            System.out.println("succeed");
        } catch (IOException ex) {
            System.out.println("server connection error");
            Logger.getLogger(Ex1_SocketClientDemo_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new Ex1_SocketClientDemo_1("192.168.0.110", 9999);
    }
    
}
