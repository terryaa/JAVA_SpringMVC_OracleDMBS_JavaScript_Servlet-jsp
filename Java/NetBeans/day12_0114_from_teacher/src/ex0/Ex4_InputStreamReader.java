package ex0;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Ex4_InputStreamReader 
    ����Ʈ��Ʈ�� -> ���ڽ�Ʈ������ �����ϱ� ���� ��Ʈ��
*/
public class Ex4_InputStreamReader {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String path = "C:\\bigdataStudy\\java\\demo\\memo.txt";
            // InputStreamReader : ����Ʈ�� ���ڿ��� �������ִ� ��Ʈ��
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path))
            );
            String str = null;
            while ((str = br.readLine()) != null) {                
                System.out.println(str);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
    }
}
