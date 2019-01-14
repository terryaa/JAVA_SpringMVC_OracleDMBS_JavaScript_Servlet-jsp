/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex1_FileReWrDemo {
    
    private String path;
    public Ex1_FileReWrDemo(){
        //This path will not apply in Windows. 
        path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC/Java/NetBeans/day"
                + "12_01_14/src/ex1/memo.txt";
    }
    //msg is String to be saved in memo.txt using BufferedWriter. 
    public void writeMemo(String msg){
        
        BufferedWriter bw=null;
        try {
            bw=new BufferedWriter(new FileWriter(path,true));
             bw.write(msg);
        bw.newLine();
        bw.flush();
  
        } catch (IOException ex) {
            Logger.getLogger(Ex1_FileReWrDemo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(bw!=null){
                try{
                    bw.close();
                }catch(IOException ex){
                    
                }
            }
        }
       
        
    }
    
    public ArrayList<String> getMemo() throws FileNotFoundException, IOException {
        ArrayList<String> ar=new ArrayList<>();
        BufferedReader br=null;
        br=new BufferedReader(new FileReader(path));
        String rdv=null;
        //readLine() reads text by a line through a stream.
        //last(EOF) is null
        while((rdv=br.readLine())!=null){
        ar.add(rdv);
    }
        br.close();
        return ar;
    }
    
}
