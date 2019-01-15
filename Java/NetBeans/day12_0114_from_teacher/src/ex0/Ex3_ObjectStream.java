package ex0;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/* Ex3_ObjectStream 
   Ex3_Member ��ü�� �����ؼ� ����ȭ�� �����͸� ����
*/
public class Ex3_ObjectStream {
    public static void main(String[] args) {
        String path ="C:\\bigdataStudy\\java\\demo\\ex3_obj.txt";
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
         // ����ȭ ����� �Ǵ� ��ü * (Serializable �������̽��� ����)
         Ex3_Member v = new Ex3_Member();
         v.setId("xman");
         v.setPwd("1");
         v.setAge(30);
         v.setName("��浿");
         v.setPay(2000);
         // ����ȭ
         oos.writeObject(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
