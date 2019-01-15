package ex0;

import java.io.DataInputStream;
import java.io.FileInputStream;

/* Ex2_DataInputStream */
public class Ex2_DataInputStream {
    private String path;
    public Ex2_DataInputStream() {
         path ="C:\\bigdataStudy\\java\\demo\\ex2_data.txt";
    }
    public void printDataStream (){
        try (DataInputStream dis
                = new DataInputStream(new FileInputStream(path))) {
            System.out.println("Ãâ·Â :----------------------");
            System.out.println("int:" + dis.readInt());
            System.out.println("boolean:"+dis.readBoolean());
            System.out.println("char:"+dis.readChar());
            System.out.println("Float:"+dis.readFloat());
            System.out.println("String:" + dis.readUTF());
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new Ex2_DataInputStream().printDataStream();
    }
}
