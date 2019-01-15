package ex0;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* Ex1_FileCp 
Ư�� ������ �ٸ� ��ġ�� ���縦 �ϱ� ���� ����� ����
: 2�� ��Ʈ�� �߿� ���۸� ������ ��� : �ӵ��� ����!
*/
public class Ex1_FileCp2 {
    public static void main(String[] args) throws IOException, IOException {
        long start = System.currentTimeMillis();
        String path1 = "C:\\bigdataStudy\\java\\demo\\jdk.exe";
        String path2 = "C:\\bigdataStudy\\java\\demo\\myjdk.exe";
        // 2�� ��Ʈ���� ����
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1����Ʈ���� �ּҸ� ���ڷ� ����!
            bis = new BufferedInputStream(
                    new FileInputStream(path1));
            bos = new BufferedOutputStream(
                    new FileOutputStream(path2));
            int readV = 0;
            // bis�� ���� ���ۿ� ��� �о� ���̸鼭 
            // bos�� �о�� ��η� ���۴����� �����Ѵ�.
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
        System.out.println("������ �ð� :"+(end - start));
    }
}









