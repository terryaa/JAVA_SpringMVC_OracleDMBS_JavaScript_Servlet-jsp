/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Exam_ServerSocketDemo_2 {
    private ServerSocket ss;
    
    public Exam_ServerSocketDemo_2(int port){
        try {
            //Creates serversocket in designated port. 
            ss=new ServerSocket(port);
            System.out.println("server running");
            executeService();
            
        } catch (IOException ex) {
            System.out.println("port is already being used");
            Logger.getLogger(Exam_ServerSocketDemo_2.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(!ss.isClosed()){
                try {
                    ss.close();
                } catch (IOException ex) {
                    Logger.getLogger(Exam_ServerSocketDemo_2.class.getName()).log(Level.SEVERE, null, ex);
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
            OutputStream os=s.getOutputStream();
            //BufferedRead can replace this part
            Properties properties=new Properties();
            properties.load(new FileReader("/Users/younghoonkim/Documents/KO"
                    + "STA_Git/KOSTA_MAC/Java/NetBeans/day14"
                    + "_01_16/src/ex1/client_no00.properties"));
            
            PrintWriter pw=new PrintWriter(os);
            
            Scanner sc=new Scanner(is);
            String msg="";
            msg=sc.nextLine();
            System.out.println("Client Message Log:"+msg);
            System.out.println(isa);
            
            
            String value=properties.getProperty(msg);
            if(value==null){
                value="Unknow key value";
            }
            System.out.println("requested value:"+value);
            pw.println(value);
            pw.close();
            
            
            
            s.close();
            
            
            
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        new Exam_ServerSocketDemo_2(9999);
    }
}