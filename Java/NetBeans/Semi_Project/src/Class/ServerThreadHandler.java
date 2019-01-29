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
    JSONParser parser = null; // 불러오기?
    JSONObject memberInfo = null; // 값에 대한 객체 생성
    JSONObject members=null;
//     JSONParser parser = new JSONParser(); // 불러오기?
//    JSONObject memberInfo = new JSONObject(); // 값에 대한 객체 생성
    
     public String idcheck(String msg){
         StringTokenizer st=new StringTokenizer(msg, "^");
         String identifier=st.nextToken();
         String userId=st.nextToken();
         StringBuffer sb=new StringBuffer();
        try {
            members = (JSONObject) parser.parse(new FileReader(path+"member.json"));
            memberInfo= (JSONObject) members.get(userId);
            if(memberInfo==null) {
                return "false";
            }
            else{//나중에 check으로통일가능하면통일
                if(identifier.equals("search") || identifier.equals("check")){
                    sb.append("true");
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServerThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         if(!containsId(st.nextToken())){
             return "false";
         }
         for(int i=0;i<10;i++ ){
             System.out.println("hahahaha");
         }
         else
             
         
                      
         
         
     }
     public boolean containsId(String id){
         JSONParser parser = new JSONParser(); // 불러오기?
        JSONObject memberInfo = new JSONObject(); // 값에 대한 객체 생성
        JSONObject members=null;
         try {
            members=(JSONObject) parser.parse(new FileReader(path+"member.json"));
            JSONObject member_id = (JSONObject) members.get(id);
                    if (member_id!=null) {
                       return true;
                    } else {
                        return false;
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
