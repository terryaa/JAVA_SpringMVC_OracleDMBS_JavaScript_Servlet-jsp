package ex0;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/* Ex2_DataOutputStream 
   �������� �ڷ��� ���� �Բ� ����
   ����� ������� InputStream�� �о� �鿩�� �Ѵ�.
*/
public class Ex2_DataOutputStream {
    private String path;
    public Ex2_DataOutputStream() {
        path ="C:\\bigdataStudy\\java\\demo\\ex2_data.txt";
    }
    // DataType�� �Բ� �Է��� ó���ϴ� �޼���
   public void dataWrite(){
       // �ڵ����� close �����Ѵ�.! ��������!!!!!
       try(DataOutputStream dos = 
               new DataOutputStream(new FileOutputStream(path))){
           // �Է� ������ �ſ� �߿��ϴ�.!
           dos.writeInt(10);
           dos.writeBoolean(true);
           dos.writeChar('A');
           dos.writeFloat(10.5f);
           dos.writeUTF("MyTest");
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    public static void main(String[] args) {
        new Ex2_DataOutputStream().dataWrite();
    }
}
