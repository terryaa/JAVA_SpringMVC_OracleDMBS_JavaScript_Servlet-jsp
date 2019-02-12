/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;
import Interface.ServerMessageCreateInter;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import org.json.simple.JSONObject;
/**
 *
 * @author KOSTA
 */
public class ServerReservationMessageCreate implements ServerMessageCreateInter {

    private final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
    private final String path="C:\\bigdata\\KOSTA_MAC\\Java\\NetBeans\\Semi_Project\\src\\Data\\";
    
    @Override
    public String createMessage(String msg, JSONObject members) {
        StringBuffer sb=new StringBuffer();
        try {
            StringTokenizer st=new StringTokenizer(msg,"^");
            st.nextToken();
            String clientId=st.nextToken();
            Date startDate=setDate(sdf.parse(st.nextToken()));
            Date endDate=setDate(sdf.parse(st.nextToken()));
            
            Scanner sc=new Scanner(new File(path+"reservation.txt"));
            
            
            
            
            
            firstWhile:
            while(sc.hasNext()){
                //Scanner에서 reservation.txt파일을 읽어온다.
                //reservation.txt - id:name:date:program
                //읽은 line을 :로 나누어 날짜를 추출, 날짜를 비교하여
                //2개의 날짜사이의 예약정보를 저장한다.
                String readLineScanner=sc.nextLine();
                st=new StringTokenizer(readLineScanner, ":");
                
                //파일에있는 예약정보의 id와 날짜저장
                String idFromScanner=st.nextToken();
                st.nextToken();
                Date date=sdf.parse(st.nextToken());
                if(startDate.compareTo(date)==0 ||
                        startDate.compareTo(date)<0){
                    //시작일을 찾은경우, 시작일부터 끝일까지의 while문을 다시시작한다.
                    while(sc.hasNext()){
                        //보낼자료를 StringBuffer에저장
                        if(clientId.equals(idFromScanner)||clientId.equals("admin"))
                            sb.append(readLineScanner).append("\n");
                        //:을 기준으로 나눠진 자료를 구별한다.
                        readLineScanner=sc.nextLine();
                        st=new StringTokenizer(readLineScanner, ":");
                        idFromScanner=st.nextToken();st.nextToken();
                        
                        date=sdf.parse(st.nextToken());
                        //끝일을 찾을경우 처음 while문 종료.읽기를 종료한다.
                        if(endDate.compareTo(date)<0){
                            break firstWhile;
                        }
                    }
                    if(clientId.equals(idFromScanner)||clientId.equals("admin"))
                        sb.append(readLineScanner).append("\n");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServerReservationMessageCreate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServerReservationMessageCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return sb.toString();
    }
    private Date setDate(Date dateStr){
            Calendar getHour=Calendar.getInstance();
            getHour.setTime(dateStr);
            getHour.set(Calendar.HOUR_OF_DAY, 0);
            dateStr=getHour.getTime();
            return dateStr;
    }
}
