/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Interface.ServerMessageCreateInter;
import org.json.simple.JSONObject;

/**
 *
 * @author KOSTA
 */
public class ServerIdDuplicationMessageCreate implements ServerMessageCreateInter {

    @Override
    public String createMessage(String msg, JSONObject members) {
        JSONObject memberInfo= (JSONObject) members.get(msg);
        StringBuffer sb=new StringBuffer();
        if(memberInfo==null) {
            sb.append("none^id^");
        }
        else{
            sb.append("true^").append(memberInfo.get("Name")).append("^");
        }
        return sb.toString();
    }
    
}
