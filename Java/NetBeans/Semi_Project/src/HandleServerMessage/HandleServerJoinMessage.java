package HandleServerMessage;


import GUI.Grace_GUI;
import Interface.HandleServerMessage;
import POJO.Member;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KOSTA
 */
public class HandleServerJoinMessage implements HandleServerMessage {

    @Override
    public String createRequest(Grace_GUI gui) {
         Member mem=gui.getMember();
            StringBuffer sb=new StringBuffer();
            sb.append("join^");
            sb.append(mem.getName()).append(":");
            sb.append(mem.getId()).append(":");
            sb.append(mem.getPassword()).append(":");
            sb.append(mem.getCellphone()).append(":").append("^");
            return sb.toString();
    }

    @Override
    public boolean processResponse(String msg, Grace_GUI gui) {
        if(msg.contains("true"))
        {
            JOptionPane.showMessageDialog(gui, "회원가입이 완료되었습니다.");
            gui.getCard().show(gui.getCardPanel(), "cardLogin");
            return true;
        }
        else
            return false;
    }
    
}
