/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HandleServerMessage;

import GUI.Grace_GUI;
import Interface.HandleServerMessage;
import java.util.StringTokenizer;

/**
 *
 * @author KOSTA
 */
public class HandleServerIdDuplicationMessage implements HandleServerMessage{

    @Override
    public String createRequest(Grace_GUI gui) {
        StringBuffer msg=new StringBuffer();
        msg.append("check^").append(gui.getSearch_id()).append("^");
        return msg.toString();
    }

    @Override
    public boolean processResponse(String msg, Grace_GUI gui) {
         StringTokenizer stz = new StringTokenizer(msg, "^");
         String token = stz.nextToken();

         if (token.equals("none")) {
             return true;
         }
         else {
             return false;
         }
    }
    
}
