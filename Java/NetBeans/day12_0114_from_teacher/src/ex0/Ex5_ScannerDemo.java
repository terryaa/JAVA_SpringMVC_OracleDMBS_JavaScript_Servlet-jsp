package ex0;

import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


/* Ex5_Demo 
Scanner 를 사용하면 연결스트림이 없이도
바로 바이트스트림을 문자 스트림으로 읽어 올 수 있다.
=> nextLine()으로 읽어 내기 위함
반대로 키보드의 값을 한줄단위로 읽어 와야 한다면 ..Scanner
BufferedReader br = new BufferedReader(System.in) 
=> 뭐가 필요할까요? 
*/
public class Ex5_ScannerDemo {
    public static void main(String[] args) throws MalformedURLException {
         String path ="https://news.naver.com/main/read.nhn?oid=052&sid1=103&aid=0001240445&mid=shm&mode=LSD&nh=20190114114615";
        URL url = new URL(path);
        // implements Iterator<String> , 반복자를 사용할 수 있다. ******
        // InputStreamReader 브릿지,버퍼를 내부적으로 캡슐화
        try(Scanner sc = new Scanner(url.openStream(),"euc-kr")){
            String rdv = null;
            while (sc.hasNext()) {  //    hasNext() : 반복할 데이터가 있으면 true          
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
