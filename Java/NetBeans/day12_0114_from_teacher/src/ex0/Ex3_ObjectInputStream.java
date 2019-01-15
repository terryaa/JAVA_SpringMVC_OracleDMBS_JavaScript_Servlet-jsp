package ex0;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Ex3_ObjectInputStream */
public class Ex3_ObjectInputStream {
    public static void main(String[] args) {
        ObjectInputStream ois =null;
        try {
             String path ="C:\\bigdataStudy\\java\\demo\\ex3_obj.txt";
            ois = new ObjectInputStream(new FileInputStream(path));
            // ������ȭ (��ü ����) 
            Ex3_Member v = (Ex3_Member) ois.readObject();
            System.out.println("id:"+v.getId());
            System.out.println("name:"+v.getName());
             System.out.println("PWD:"+v.getPwd());
            System.out.println("age:"+v.getAge());
            System.out.println("pay :"+v.getPay());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
