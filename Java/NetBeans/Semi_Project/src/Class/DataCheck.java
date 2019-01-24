/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author KOSTA
 */
public class DataCheck {
    
    
    
      public boolean Check(String ch) throws IOException{
 
//         Socket s = ss.accept();
        
    ArrayList<String> fileList = new ArrayList<String>();  
    //ArrayList가 사용할 객체 타입은 스트링이고 이름은 fileList로 저장한다.
        String sss = null;
        
        
        File file = new File("/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/"+"reservation.txt");
        //파일 저장
        BufferedReader buf = new BufferedReader(new FileReader(file));
        //버퍼드리더 buf는 새로운 버퍼드리더인데 그걸 파일이름으로 하는 버퍼드리더이다.
        //BufferedReader(Reader rd)  < rd에 연결되는 문자입력 버퍼스트림 생성
        //약간 파일리더의 애드온같은 개념. 
        System.out.println("-=-=-=-체크스타트=-=-=-=-");
        //체크스타트
        boolean ccheck =true;
        

       
            while((sss = buf.readLine()) != null) {
                //만약 buf.ReadLine()이 null값이라면
                
                fileList.add(sss);
                //어레이인 파일리스트에 s를 추가한다.
                
            }
                for(String fNm : fileList) { //향상된 for문 사용
                    if(fNm.contains(ch)) { //만약 fNm이 ch를 포함한다면
                        System.out.println(fNm + "is duplicated"); //중복처리
                        ccheck = false;   //ccheck를 false로 처리한다.
                        
                    }
                    
                    
                }
        
	buf.close();
        //buf를 종료한다.
//        s.close();
        System.out.println("=-=-==-체크 종료-=-=-=-");
        //체크종료
    
       return ccheck;
       
       //결과값을 ccheck로 반환한다. (true / false)
}
      }

