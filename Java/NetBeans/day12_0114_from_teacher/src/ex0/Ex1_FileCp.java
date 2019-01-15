package ex0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Ex1_FileCp 
Ư�� ������ �ٸ� ��ġ�� ���縦 �ϱ� ���� ����� ����
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
            // fis�� ���� 1byte�� �о� ���̸鼭 
            // fos�� �о�� ��η� 1byte�� �����Ѵ�.
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
        System.out.println("������ �ð� :"+(end - start));
    }
}









