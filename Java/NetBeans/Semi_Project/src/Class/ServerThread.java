/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private Server server;
    private BufferedReader br;
    private PrintWriter pw;

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
    
    public ServerThread(Socket socket, Server server){
        this.socket=socket;
        this.server=server;
        System.out.println("Client's IP:"+socket.getInetAddress().getHostAddress());
    }

    @Override
    public void run() {
        
        try {
            pw=new PrintWriter(socket.getOutputStream(),true);
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            File file=new File("/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/reservation.txt");
            Scanner sc=new Scanner(file);
            
            StringBuffer sb=new StringBuffer();
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
                System.out.println(sb.toString());
            }
            String reservationList=sb.toString();
            System.out.println(reservationList);
            if(!reservationList.equals("")){
                server.sendReservationList(reservationList);
            }
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
