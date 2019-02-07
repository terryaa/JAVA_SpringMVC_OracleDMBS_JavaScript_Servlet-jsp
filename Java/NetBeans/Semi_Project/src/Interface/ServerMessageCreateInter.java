/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import org.json.simple.JSONObject;

/**
 *
 * @author KOSTA
 */
public interface ServerMessageCreateInter {
    public String createMessage(String msg, JSONObject members);
}
