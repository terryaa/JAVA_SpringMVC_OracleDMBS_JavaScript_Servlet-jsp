/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class DataInput {
    private final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
    
//        private ServerSocket ss;
//    public DataInput(ServerSocket ss) {
//        this.ss = ss;
//    }
    
    
private String path ="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/"; //path생성. 보안이므로 private로

    ///////////////데이터 입력/////////////
//    public class testWrite {
    
//            private testRead efr;
//            public testWrite(){
//            efr = new testRead();
//            } 
           
    public void execWriter(String memo){
            writeClient(memo);
       }
    
    
    
    private void execReader(){
        try {
        ArrayList<String> arlist = getMemo();     //ArrayList를 String으로 저장하는데, getMemo()를 저장한다.
        for(String e : arlist){                   //향상된 for문. 
            System.out.println(e);                //e를 출력한다.
        }
        } catch (IOException ex) {
        ex.printStackTrace();
        }
        
    }

    
    
    private void writeClient(String wc){                                 //고객을 작성한다.
        BufferedWriter bw = null;                                       //버퍼라이터 bw를 만듬.
        try {
            Scanner sc=new Scanner(new File(path+"reservation.txt"));
            StringTokenizer st=new StringTokenizer(wc,":");
            st.nextToken();st.nextToken();
            Date startDate=sdf.parse(st.nextToken());
            StringBuffer sb=new StringBuffer();
            
            
            while(sc.hasNext()){
                String readLine=sc.nextLine();
                
                st=new StringTokenizer(readLine,":");
                st.nextToken();st.nextToken();
                Date date=sdf.parse(st.nextToken());
                int result=startDate.compareTo(date);
                System.out.println(result);
                if(result<0){
                    sb.append(wc).append("\n");
                    sb.append(readLine).append("\n");
                    break;
                }
                sb.append(readLine).append("\n");
            }
            
            
            
            while(sc.hasNext()){
                sb.append(sc.nextLine()).append("\n");
            }
            
            bw = new BufferedWriter(new FileWriter(path+"reservation.txt"));    //bw는 새로운 버퍼드라이터인데, 그 버퍼드라이터가 파일라이터를 불러오는 버퍼드라이터이다.
            //문자스트림을 사용해서 경로의 문서에 작성
            bw.write(sb.toString());                                               //버퍼드라이터에 작성한다. wc값을 받을거니 wc값을 작성한다.
            bw.newLine();                                               //새로운 라인 작성  
            bw.flush();                                                 //flush로 남은거 다 밀어냄
        } catch (IOException ex) {
            System.out.println("문제가 발생했습니다.");                  //만약 안되면 문제 발생
        } catch (ParseException ex) {
            Logger.getLogger(DataInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private ArrayList<String> getMemo() throws FileNotFoundException, IOException{ 
    ArrayList<String> ar = new ArrayList<>();                                   //어레이리스트 스트링타입을가진거 생성
    BufferedReader br = null;                                                   //버퍼드리더 만듬
    br = new BufferedReader(new FileReader(path+"reservation.txt"));                         //버퍼드리더인데 파일리더의 경로를 가진 버퍼드리더
    String rdv = null;                                                          //rdv는 널값
    //readLine() 은 스트림을 통해서 문자열을 한줄 단위로 읽어온다.
    //마지막은 null
    while((rdv = br.readLine()) != null){
    //읽어온 문자열을 한줄씩 ArrayList에 저장
    ar.add(rdv);        
    }
    br.close();                                                                 //닫는다.
    return ar;                                                                  //ar를 리턴
    }
    
    
    ///////////////////////////////
}