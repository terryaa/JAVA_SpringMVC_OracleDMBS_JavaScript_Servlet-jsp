package ex0;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* Ex1_FileCp 
특정 파일을 다른 위치에 복사를 하기 위한 기능을 구현
: 2차 스트림 중에 버퍼를 내장한 기능 : 속도가 증가!
*/
public class Ex1_FileCp2 {
    public static void main(String[] args) throws IOException, IOException {
        long start = System.currentTimeMillis();
        String path1 = "C:\\bigdataStudy\\java\\demo\\jdk.exe";
        String path2 = "C:\\bigdataStudy\\java\\demo\\myjdk.exe";
        // 2차 스트림을 선언
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1차스트림의 주소를 인자로 전달!
            bis = new BufferedInputStream(
                    new FileInputStream(path1));
            bos = new BufferedOutputStream(
                    new FileOutputStream(path2));
            int readV = 0;
            // bis로 부터 버퍼에 담아 읽어 들이면서 
            // bos로 읽어온 경로로 버퍼단위로 저장한다.
            while((readV = bis.read()) != -1){
                bos.write(readV);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally{
          // if(fis != null) fis.close();
           //if(fos != null) fos.close();
           if(bis != null) bis.close();
           if(bos != null) bos.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("복사한 시간 :"+(end - start));
    }
}









