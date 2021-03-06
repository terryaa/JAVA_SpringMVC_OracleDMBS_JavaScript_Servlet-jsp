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

import Interface.ServerMessageCreateInter;
import POJO.Reservation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author younghoonkim
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private Server server;
    private BufferedReader br;
    private PrintWriter pw;
    
    private final String path="C:\\bigdata\\KOSTA_MAC\\Java\\NetBeans\\Semi_Project\\src\\Data\\";
    private ServerMessageCreateInter smci;
   
    JSONParser parser = new JSONParser(); // 불러오기?
    JSONObject memberInfo = new JSONObject(); // 값에 대한 객체 생성

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
            //Stream연결 
            pw=new PrintWriter(socket.getOutputStream(),true);
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //필요변수 초기화
            File file=new File(path+"reservation.txt");
            
            StringTokenizer st;
            StringBuffer sb=null;
            JSONObject members=null;
            Scanner sc=null;
            
//            StringTokenizer stz = new StringTokenizer(clientMsg, "/");
//            String token = stz.nextToken();
            
            //readLine을 통해 client가 보내는 자료를 읽어온다.
            //client의 요청에따라 예약확인/중복확인/아이디검색/로그인/예약등록으로 나뉜다.
            firstWhile:
            while(true){
                String fromClient=br.readLine();
                st=new StringTokenizer(fromClient,"^");
                sb=new StringBuffer();
                //데이터형식  identifier ^ clientid ^ data:
                String identifier=st.nextToken();
                String clientId=st.nextToken();
                members = (JSONObject) parser.parse(new FileReader(path+"member.json"));
                
                
                
                //관리자가 회원의 아이디를 검색하여 중복확인 결과를 알려준다
                //데이터형식: check^
                if(identifier.equals("check")){
                    smci=new ServerIdDuplicationMessageCreate();
                    sb.append(smci.createMessage(clientId, members));
                }
                //데이터형식 : date^userId^2000/01/01^2000/01/01
                //날짜를 받아서 테이블에 출력할 정보 생성
                //클라이언트가 날짜를 골랐을경우,시작일과 끝일을 비교하여 그 기간내에
                //존재하는 예약들을 불러온다.
                //관리자의경우 모든 예약이, 일반사용자의경우 기간내의 자신의 예약이조회된다. 
                else if(identifier.equals("date")){
                    //Client가 선택한 날짜정보 저장
                   smci=new ServerReservationMessageCreate();
                   sb.append(smci.createMessage(fromClient, members));
                   ReservationList rl=new ReservationList();
                   ArrayList<Reservation> list=rl.makeList(sb.toString());
                   ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                   oos.writeObject(list);
                   pw=new PrintWriter(socket.getOutputStream(),true);
                   continue;
                    
                }
                //로그인 요청이들어올경우
                //Json파일에서 ID와 비밀번호 비교후 비밀번호가 맞을경우 로그인성공 메세지를 보내준다.
                //데이터형식: login^id^password
                else if(identifier.equals("login")){
                    smci=new ServerLoginMessageCreate();
                    sb.append(smci.createMessage(fromClient, members));
                }
                
                //회원가입
                //Json파일에 Map형태로 저장
                //데이터형식 - join^name:id:pwd:cell123
                 else if (identifier.equals("join")) {
                    // "join/아이디/비밀번호/연락처"
                    //String id = stz.nextToken();
                    // 회원가입하는 로직
                    smci=new ServerJoinMessageCreate();
                    try{
                    sb.append(  smci.createMessage(fromClient, members));
                    }catch(Exception e){
                        e.getStackTrace();
                    }
                }
                 
                 //예약 생성.
                 //예약을 원하는 아이디정보를 불러와 예약을 Reservation에저장한다.
                 //데이터형식 - make^id^date:
                 else if(identifier.equals("make")){
                     DataCheck dc=new DataCheck();
                     DataInput di=new DataInput();
                     HandleReservation hr=new HandleReservation();
                     //년,월,일,시간 중복체크
                    if(dc.Check(st.nextToken())==true){
                       //중복이아니라면 텍스트파일 생성
                    //다음 토큰에는 예약저장에 필요한 모든정보 포함.
                        di.execWriter(st.nextToken());
                        sb.append("make");
                    }
                    else
                        sb.append("duplication");
                }
                 //관리자가 아이디를 검색하여 예약을 등록할떄 아이디검색을 하는 부분
                 //Json에서 아이디를 검색하여 결과를 보내줌.
                
                //예약정보를 String형태로 정리한다.
                String serverMessage=sb.toString();
                System.out.println(serverMessage);
                
                //Server에게 String형태의 검색결과자료를 broadcast하도록한다.
                //server.sendReservationList(reservationList);
                pw.println(serverMessage);
                
            }
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (org.json.simple.parser.ParseException ex) {
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
