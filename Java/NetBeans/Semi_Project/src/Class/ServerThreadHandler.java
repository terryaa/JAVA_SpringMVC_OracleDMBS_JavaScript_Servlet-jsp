/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Interface.ServerThreadHandlerInter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author younghoonkim
 */
public class ServerThreadHandler implements ServerThreadHandlerInter{
    
    private final String path="/Users/younghoonkim/Documents/KOSTA_Git/KOSTA_MAC"
                    + "/Java/NetBeans/Semi_Project/src/Data/";
    
    
     public String idcheck(String msg){
         JSONParser parser = new JSONParser(); // 불러오기?
        JSONObject memberInfo = new JSONObject(); // 값에 대한 객체 생성
        JSONObject members=null;
         StringTokenizer st=new StringTokenizer(msg);
    
        try {
            members=(JSONObject) parser.parse(new FileReader(path+"member.json"));
            JSONObject member_id = (JSONObject) members.get(id);
                    if (member_id!=null) {
                        return "id_check:true:";
                    } else {
                        return "id_check:false:";
                    }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServerThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServerThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
}
