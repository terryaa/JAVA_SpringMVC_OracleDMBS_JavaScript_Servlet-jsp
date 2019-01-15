package ex0;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Ex5_Demo */
public class Ex5_Demo {
    public static void main(String[] args) throws MalformedURLException {
        BufferedReader br =null;
        try {
            String path ="https://news.naver.com/main/read.nhn?oid=052&sid1=103&aid=0001240445&mid=shm&mode=LSD&nh=20190114114615";
            URL url = new URL(path);
            // ��¿�� ���� ����Ʈ��Ʈ������ �޾ƿ� ��ü��
            // ���ڽ�Ʈ������ �����Ϸ��� �Ҷ��� �ִ�.
            // InputStreamReader(inputstream,���ڵ�)
            // => Scanner�� ��ü �����ϴ�. (InputStreamReader x)
            // �������� : Scanner�� API �����ؼ� 
            // �Ȱ��� ������� Ex5_ScannerDemo���� �����Ͻÿ�.
            //url.openStream():Inputstream
            br = new BufferedReader(
                    new InputStreamReader(url.openStream(),"euc-kr"));
             String str = null;
            while ((str = br.readLine()) != null) {                
                System.out.println(str);
            }
        } catch (IOException ex) {
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Ex5_Demo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
