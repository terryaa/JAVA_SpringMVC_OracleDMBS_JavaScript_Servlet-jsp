package ex0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Ex1_FileCp 
특정 파일을 다른 위치에 복사를 하기 위한 기능을 구현
*/
public class Ex1_FileCp {
    public static void main(String[] args) throws IOException, IOException {
        long start = System.currentTimeMillis();
        String path1 = "C:\\bigdataStudy\\java\\demo\\jdk.exe";
        String path2 = "C:\\bigdataStudy\\java\\demo\\myjdk.exe";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(path1);
            fos = new FileOutputStream(path2);
            int readV = 0;
            // fis로 부터 1byte씩 읽어 들이면서 
            // fos로 읽어온 경로로 1byte씩 저장한다.
            while((readV = fis.read()) != -1){
                fos.write(readV);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally{
           if(fis != null) fis.close();
           if(fos != null) fos.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("복사한 시간 :"+(end - start));
    }
}









