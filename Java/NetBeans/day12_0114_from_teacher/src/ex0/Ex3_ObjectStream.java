package ex0;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/* Ex3_ObjectStream 
   Ex3_Member 객체를 생성해서 직렬화로 데이터를 전송
*/
public class Ex3_ObjectStream {
    public static void main(String[] args) {
        String path ="C:\\bigdataStudy\\java\\demo\\ex3_obj.txt";
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
         // 직렬화 대상이 되는 객체 * (Serializable 인터페이스를 구현)
         Ex3_Member v = new Ex3_Member();
         v.setId("xman");
         v.setPwd("1");
         v.setAge(30);
         v.setName("김길동");
         v.setPay(2000);
         // 직렬화
         oos.writeObject(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
