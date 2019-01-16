/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**  write msg.properties file.
 *   save data in key=value format.
 *   ex)
 *   hi=hello;
 *   bye=good bye!
 *   
 *   Server gets message from clientGUI,server transmits msg.properties
 *   to client, pritn in jTextARea.
 * 
 * @author younghoonkim
 */
public class Exam_ServerSocketDemo {
    private ServerSocket ss;
    
    public Exam_ServerSocketDemo(int port){
        try {
            //Creates serversocket in designated port. 
            ss=new ServerSocket(port);
            executeService();
            System.out.println("server running");
        } catch (IOException ex) {
            System.out.println("port is already being used");
            Logger.getLogger(Exam_ServerSocketDemo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(!ss.isClosed()){
                try {
                    ss.close();
                } catch (IOException ex) {
                    Logger.getLogger(Exam_ServerSocketDemo.class.getName()).log(Level.SEVERE, null, ex);
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
            //get stream from client's socket
            InputStream is=s.getInputStream();
            //BufferedRead can replace this part
            
            Scanner sc=new Scanner(is);
            String msg="";
            while(sc.hasNext()){
                //msg+=sc.nextLine();
                System.out.println("Client Message Log"+sc.nextLine());
            }
            System.out.println(isa);
            
            s.close();
            
            
            
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        new Exam_ServerSocketDemo(9999);
    }
}