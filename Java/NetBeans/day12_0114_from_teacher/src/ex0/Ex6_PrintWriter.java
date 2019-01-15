package ex0;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Ex6_PrintWriter
���) OutputWriter =>���ὺƮ���ε� .....
���������� OutputWriter, BufferedWriter ����� �����ϰ� �ִ�.******
*/
public class Ex6_PrintWriter {
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            String path = "C:\\bigdataStudy\\java\\demo\\memo3.txt";
            // �ι�° ���� : autoFlush (�ڵ����� ������ ����ش�.)
            //  new FileWriter(path)
            pw = new PrintWriter(
                     new FileOutputStream(path)
                  ,true);
            pw.println("���� �ݰ�����!2");
            //pw.flush();
        } catch (Exception ex) {
        } finally {
            pw.close();
        }
    }
}
