/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

//Server : socket -> [bind() -> listen()] -> accept() -> Stream() ->close()

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

//bind() : allocates port socket information
//listen() : checks client's connection request
//accept() : creates client's socket


//Ex1_Server
//        1. creates ServerSocket
//2. calls accept() and returns socket
//2-1. uses ArrayList to handle multiple clients
//3. communicates through Streams provided by socket
//3-1. creates parts where deals with readLine() method


/**
 *
 * @author younghoonkim
 */
public class Ex1_Server {
    //1. declare ServerSocket
    private ServerSocket ss;
    // declaration for 2-1
    private ArrayList<ServerThread> cList;
    
    //Thread pool to manage Thread group. 
    private ExecutorService executorService;
    public Ex1_Server(){
        try {
            //port open
            ss=new ServerSocket(9999);
            System.out.println("Server running...");
            cList=new ArrayList<>();
            executorService=Executors.newFixedThreadPool(3);
            //ss=new ServerSocket();
            //ss.bind(new InetSocketAddress(9999));
        } catch (IOException ex) {
            System.out.println("Port is already being used");
            Logger.getLogger(Ex1_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void execute(){
        
        while(true){
            try {
                Socket s=ss.accept();
                ServerThread ct=new ServerThread(s,this);
                executorService.submit(ct);
                
//            These two comments does same thing as executorService.submit.
//            Need to know how to use both ways.
//            Thread t=new Thread(ct);
//            t.start();
                
                cList.add(ct);
                System.out.println("Current number of clients : "+cList.size());
            } catch (IOException ex) {
                Logger.getLogger(Ex1_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public static void main(String[] args) {
        Ex1_Server server=new Ex1_Server();
        server.execute();
    }
    public void sendMessage(String clientMsg){
        //All client's sockets are saved in ArrayList.
        //Broadcast a message to all clients.
        for(ServerThread e:cList){
            e.getPw().println(clientMsg);
        }
    }
    
}
