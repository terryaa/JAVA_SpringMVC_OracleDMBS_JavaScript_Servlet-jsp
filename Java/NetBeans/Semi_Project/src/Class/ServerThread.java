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

import java.util.Date;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;
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
    private final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private String id;
    private final String path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/reservation.txt";

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
            //Initializing streams. 
            pw=new PrintWriter(socket.getOutputStream(),true);
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //Variables Initialization
            File file=new File(path);
            Scanner sc=new Scanner(file);
            StringTokenizer stst;
            StringBuffer sb=null;
            
            //Read from client's input stream
            while(true){
                String fromClient=br.readLine();
                
                //클라이언트가 날짜를 골랐을경우,시작일과 끝일을 비교하여 그 기간내에
                //존재하는 예약들을 불러온다.
                //관리자의경우 모든 예약이, 일반사용자의경우 기간내의 자신의 예약이조회된다. 
                if(fromClient.contains("date")){
                    sb=new StringBuffer();

                    StringTokenizer st=new StringTokenizer(fromClient,":");
                    st.nextToken();
                    String clientId=st.nextToken();

                    //비교할 날짜 초기화
                    Date startDate=setDate(sdf.parse(st.nextToken()));
                    Date endDate=setDate(sdf.parse(st.nextToken()));
                    //스캐너와 파일연결
                    sc=new Scanner(file);
                    
                    //스캐너를 이용 한줄씩 읽어들이며 저장된 자료가
                    //기간내에 있는지, 예약ID와 사용자ID가 일치하는지 비교한다.
                    firstWhile:
                    while(sc.hasNext()){
                        
                        String readLine=sc.nextLine();
                        st=new StringTokenizer(readLine, ":");

                        String id=st.nextToken();st.nextToken();

                        Date date=sdf.parse(st.nextToken());
                        if(startDate.compareTo(date)==0 ||
                                startDate.compareTo(date)<0){
                            //시작일을 찾은경우, 시작일부터 끝일까지의 while문을 다시시작한다.
                            while(sc.hasNext()){
                                //보낼자료를 StringBuffer에저장
                                if(clientId.equals(id)||clientId.equals("admin"))
                                    sb.append(readLine).append("\n");
                                //:을 기준으로 나눠진 자료를 구별한다.
                                readLine=sc.nextLine();
                                st=new StringTokenizer(readLine, ":");
                                id=st.nextToken();st.nextToken();

                                date=sdf.parse(st.nextToken());
                                //끝일을 찾을경우 처음 while문 종료.읽기를 종료한다. 
                                if(endDate.compareTo(date)<0){
                                    break firstWhile;
                                }
                            }
                            if(clientId.equals(id)||clientId.equals("admin"))
                                sb.append(readLine).append("\n");
                        }
                    }
                }
            String reservationList=sb.toString();
                    System.out.println(reservationList);
                    if(!reservationList.equals("")){
                        server.sendReservationList(reservationList);
                    }
            }
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //This method set Date's hour information to 12:00AM.
    private Date setDate(Date dateStr){
            Calendar getHour=Calendar.getInstance();
            getHour.setTime(dateStr);
            getHour.set(Calendar.HOUR_OF_DAY, 0);
            dateStr=getHour.getTime();
            return dateStr;
    }
    
}
