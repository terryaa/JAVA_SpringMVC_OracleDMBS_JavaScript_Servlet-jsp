/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex1_ServerSocketDemo {
    private ServerSocket ss;
    
    public Ex1_ServerSocketDemo(int port){
        try {
            //Creates serversocket in designated port. 
            ss=new ServerSocket(port);
            executeService();
            System.out.println("server running");
        } catch (IOException ex) {
            System.out.println("port is already being used");
            Logger.getLogger(Ex1_ServerSocketDemo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(!ss.isClosed()){
                try {
                    ss.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ex1_ServerSocketDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void executeService() throws IOException {
        while(true){
            //Socket s object's address is user's address.
            //this method keeps getting input connection from client
            //and create socket to connect client to that socket.
            Socket s = ss.accept();
            //check client's IP
            InetSocketAddress isa=(InetSocketAddress) s.getRemoteSocketAddress();
            System.out.println(isa);
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        new Ex1_ServerSocketDemo(9999);
    }
}