package ex0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/** Ex1_FileReWrDemo 
    ���� ���� ��Ʈ��! 2byte
*/
/**
 *
 * @author
 */
public class Ex1_FileReWrDemo {
    private String path;
    /**
     * @see �⺻ ������, �����δ� window�� c...
     */
    public Ex1_FileReWrDemo() {
        path = "C:\\bigdataStudy\\java\\demo\\memo.txt";
    }
    /**
     *
     * @param msg �� memo.txt�� BufferedWriter�� ����ؼ� ���ڿ��� ����Ǳ� ���� ��Ʈ���Դϴ�.
     */
    public void writeMemo(String msg) {
        //���� ����� ���� ���� ��Ʈ�� (2�� ��Ʈ��)
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            //���� ��Ʈ���� ����ؼ� �ش� ����� ������ �ۼ�
            bw.write(msg);
            bw.newLine(); // ����
            bw.flush(); // ���۸� ����ִ� ���
        } catch (IOException ex) {
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                }
            }
        }
    }    
        /**
         *
         * @return ArrayList<String>
         * �޸����� ������ FileReader�� �о�ͼ� ���ڿ��� �������� ��ȯ �մϴ�.
         */
    public ArrayList<String> getMemo() throws FileNotFoundException, IOException {
        ArrayList<String> ar = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(path));
        String rdv = null;
        // readLine() �� ��Ʈ���� ���ؼ� ���ڿ��� ���� ������ �о�´�.
        // ��������  null 
        while((rdv = br.readLine()) != null){
            //�о�� ���ڿ��� �� �� �� ArrayList�� ����
            ar.add(rdv);
        }
        br.close();
        return ar;
    }
}
