/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Interface.ServerMessageCreateInter;
import java.util.StringTokenizer;
import org.json.simple.JSONObject;

/**
 *
 * @author KOSTA
 */
public class ServerLoginMessageCreate implements ServerMessageCreateInter {
    @Override
      public String createMessage(String msg, JSONObject members){
          StringTokenizer st=new StringTokenizer(msg,":");
          StringBuffer sb=new StringBuffer();
           JSONObject memberInfo= (JSONObject) members.get(st.nextToken());
           if( memberInfo!=null){
              
              if (((String) memberInfo.get("password")).equals(st.nextToken())) {
                sb.append("true^").append(memberInfo.get("Id")).append("^"); 
                sb.append((String) memberInfo.get("Name")).append("^");
                sb.append((String) memberInfo.get("password")).append("^");
                sb.append((String) memberInfo.get("Cell1")).append("-");
                sb.append((String) memberInfo.get("Cell2")).append("-");
                sb.append((String) memberInfo.get("Cell3")).append("^");
            }
              else
                   sb.append("false^");
           }
         else
             sb.append("false^");
          return sb.toString();
      }
      
}
