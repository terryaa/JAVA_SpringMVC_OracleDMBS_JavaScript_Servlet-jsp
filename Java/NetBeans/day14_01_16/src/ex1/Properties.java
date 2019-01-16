/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author younghoonkim
 */
public class Properties {
    public static void main(String[] args) throws IOException {
        String msg="servername";
         java.util.Properties properties=new java.util.Properties();
          properties.load(new FileReader("/Users/younghoonkim/Documents/KO"
                    + "STA_Git/KOSTA_MAC/Java/NetBeans/day14"
                    + "_01_16/src/ex1/client_no00.properties"));
            String value=properties.getProperty(msg);
            
           System.out.println(value);
    }
   
    
}
