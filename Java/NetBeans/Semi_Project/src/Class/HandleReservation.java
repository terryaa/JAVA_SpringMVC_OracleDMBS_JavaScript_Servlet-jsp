/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import POJO.Member;
import Interface.HandleData;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class HandleReservation implements HandleData {
        /**
 *
 * @author shin
 */
    private String path = "/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/"+"reservation.txt";
    private String path2 = "/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/"+"reservationArray.txt";
    ////////////////////내림차순 정렬/////////////////////////
    public void TextArray() throws IOException{                     


  System.out.println("< 텍스트 파일 불러오기 >\n");         
  FileReader FR = new FileReader(path);                     //파일리더.
  BufferedReader BR = new BufferedReader(FR);               //버퍼드리더

  ArrayList<String> ArrayList = new ArrayList<String>();    //어레이리스트 생성
  String Line;
  while ((Line = BR.readLine()) != null) {                  //while(null값뜰때까지)
   ArrayList.add(Line);                                     //라인생성
  }

  System.out.println("< 내림차순 정렬 전 >\n");
  for (int i = 0; i < ArrayList.size(); i++)                //내림차순 정렬 전.
                                                            //for문으로 사이즈까지
   System.out.println(ArrayList.get(i));                    //i번째를 출력

  System.out.println("\n< 정렬이 완료되었습니다. >\n");
  ArrayList = AscendingOrder(ArrayList);                    //AscendingOrder = 오름차순.
                                                            //어레이리스트 = 오름차순의 어레이리스트이다.
                                                            //내림차순의 이유는 밑에.
  System.out.println("< 내림차순 정렬 후 >\n");             
  for (int i = 0; i < ArrayList.size(); i++)                //내림차순 정렬 후
  System.out.println(ArrayList.get(i));                    //출력

  System.out.println("\n< 텍스트 파일 내보내기 >\n");                   //텍스트파일 보내기
  FileWriter FW = new FileWriter(path2);                                //파일에 새로 작성  
  BufferedWriter BW = new BufferedWriter(FW);                           //버퍼드라이터 bw 지정. 
   
        
        
  for (int i = 0; i < ArrayList.size(); i++) {                          //어레이리스트사이즈까지
 
        
      BW.write(ArrayList.get(i));          //쓰기
   BW.newLine();       //새로운라인생성  
  }
                                                     
  BR.close();
  BW.close();
  FR.close();
  FW.close();                                                           //버퍼드리더 등 다 종료
  }
 public static ArrayList AscendingOrder(ArrayList<String> ArrayList) {  //정렬
  String Temp;
  ///
  
  
  
  ///
  ArrayList<String> NewArrayList = new ArrayList<String>();
     StringTokenizer st;
  for (int i = 1; i < ArrayList.size() - 1; i++) {
   for (int j = i + 1; j < ArrayList.size(); j++) {
       st=new StringTokenizer(ArrayList.get(i),":");
      st.nextToken();st.nextToken();
       String str1=st.nextToken();
       
       st=new StringTokenizer(ArrayList.get(j),":");
       st.nextToken();st.nextToken();
       String str2=st.nextToken();

       if(str1.compareTo(str2)>0){
     Temp = ArrayList.get(i);
     ArrayList.set(i, ArrayList.get(j));
     ArrayList.set(j, Temp);
       }

   }
  }
  NewArrayList = ArrayList;
  return NewArrayList;
 }
    
    
    
    @Override
    public Member load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Member m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Member m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

