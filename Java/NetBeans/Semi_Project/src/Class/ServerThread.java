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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;
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
    private final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
    private final String path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/";
   
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
            
            
//            StringTokenizer stz = new StringTokenizer(clientMsg, "/");
//            String token = stz.nextToken();
            
            //readLine을 통해 client가 보내는 자료를 읽어온다.
            //client의 요청에따라 예약확인/중복확인/아이디검색/로그인/예약등록으로 나뉜다.
            while(true){
                String fromClient=br.readLine();
                Scanner sc=new Scanner(file);
                st=new StringTokenizer(fromClient,":");
                String identifier=st.nextToken();
                //클라이언트가 날짜를 골랐을경우,시작일과 끝일을 비교하여 그 기간내에
                //존재하는 예약들을 불러온다.
                //관리자의경우 모든 예약이, 일반사용자의경우 기간내의 자신의 예약이조회된다. 
                if(identifier.equals("date")){
                    sb=new StringBuffer();

                    st=new StringTokenizer(fromClient,":");
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
                                    sb.append("date^").append(readLine).append("\n");
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
                                sb.append("date^").append(readLine).append("\n");
                        }
                    }
                }
                //로그인 요청이들어올경우
                //Json파일에서 ID와 비밀번호 비교후 비밀번호가 맞을경우 로그인성공 메세지를 보내준다.
                else if(identifier.equals("login")) {
                    sb=new StringBuffer();
                    sb.append("login:");
                    String id = st.nextToken();
                    String password = st.nextToken();
                    members = (JSONObject) parser.parse(new FileReader(path+"member.json"));

                    JSONObject member_id = (JSONObject) members.get(id);

                    if (member_id == null) {
                        System.out.println("아이디 없음");
                        sb.append("none:");
                    } else {
                        try {
                            if (((String) member_id.get("password")).equals(password)) {
                                sb.append("true:").append(id).append(":");
                                sb.append((String) member_id.get("Name")).append(":");
                                sb.append((String) member_id.get("password")).append(":");
                                sb.append((String) member_id.get("Cell1")).append("-");
                                sb.append((String) member_id.get("Cell2")).append("-");
                                sb.append((String) member_id.get("Cell3")).append(":");
                                
                            } else {
                                sb.append("false:");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Error log : no password saved");
                            pw.println("login:false:");
                        }
                        // 회원가입하는 로직
                    }
                }
                
                //관리자가 회원의 아이디를 검색하여 중복확인 결과를 알려준다
                else if(identifier.equals("id_check")){
                    // "id_check/아이디/null/null"
                    
                    members = (JSONObject) parser.parse(new FileReader(path+"member.json"));
                    Set ids = members.keySet();
                    if (!ids.contains(st.nextToken())) {
                        pw.println("id_check:true:");
                    } else {
                        pw.println("id_check:false:");
                    }
                    // 아이디 체크하는 로직
                }
                //회원가입
                //Json파일에 Map형태로 저장
                 else if (identifier.equals("join")) {
                    // "join/아이디/비밀번호/연락처"
                    //String id = stz.nextToken();
                    // 회원가입하는 로직
                    members = (JSONObject) parser.parse(new FileReader(path+"member.json"));
                    JSONObject memberInfo = new JSONObject();   // 값에 대한 객체 생성
                    memberInfo.put("Name", st.nextToken());        //입력한 값을 JSon에 저장
                    memberInfo.put("ID",st.nextToken());            //입력한 값을 JSon에 저장
                    memberInfo.put("password", st.nextToken());//입력한 값을 JSon에 저장
                    memberInfo.put("Cell1", st.nextToken()); //입력한 값을 JSon에 저장
                    memberInfo.put("Cell2", st.nextToken()); //입력한 값을 JSon에 저장
                    memberInfo.put("Cell3", st.nextToken()); //입력한 값을 JSon에 저장
                    
                    members.put(memberInfo.get("ID"),memberInfo);
                    FileWriter fw = new FileWriter(path+"member.json");
                    fw.write(members.toJSONString());
                    fw.flush();
                    fw.close();
                    sb=new StringBuffer();
                    sb.append("join:true");
                
                }
                 
                 //예약 생성.
                 //예약을 원하는 아이디정보를 불러와 예약을 Reservation에저장한다.
                 else if(identifier.equals("make")){
                     
                     sb=new StringBuffer();
                     StringTokenizer rt = new StringTokenizer(fromClient, "^");
                     st=new StringTokenizer(rt.nextToken(),":");
                     st.nextToken();
                     DataCheck dc=new DataCheck();
                     DataInput di=new DataInput();
                     HandleReservation hr=new HandleReservation();
                     //년,월,일,시간 중복체크
                    if(dc.Check(st.nextToken())==true){
                       //중복이아니라면 텍스트파일 생성
                    //다음 토큰에는 예약저장에 필요한 모든정보 포함.
                        
                        di.execWriter(rt.nextToken());
                        //순번정렬
                        //hr.TextArray();
                        sb.append("make");
                    }
                    else
                        sb.append("duplication");
//                    pw.println("duplication");
                }
                 //관리자가 아이디를 검색하여 예약을 등록할떄 아이디검색을 하는 부분
                 //Json에서 아이디를 검색하여 결과를 보내줌.
                 else if(identifier.equals("id_search")){
                     members = (JSONObject) parser.parse(new FileReader(path+"member.json"));
                     sb=new StringBuffer();
                    Set ids = members.keySet();
                    String id=st.nextToken();
                    if (ids.contains(id)) {
                        //pw.println("id_check:true:");
                        JSONObject member_id = (JSONObject) members.get(id);
                        sb.append("id_search:true:");
                        sb.append(id).append(":");
                        sb.append((String) member_id.get("Name")).append(":");
                        
                    } else {
                        pw.println("id_check:false:");
                    }
                 }
                
                //예약정보를 String형태로 정리한다.
                String reservationList=sb.toString();
                System.out.println(reservationList);
                
                //Server에게 String형태의 검색결과자료를 broadcast하도록한다.
                server.sendReservationList(reservationList);
                
            }
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.json.simple.parser.ParseException ex) {
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
