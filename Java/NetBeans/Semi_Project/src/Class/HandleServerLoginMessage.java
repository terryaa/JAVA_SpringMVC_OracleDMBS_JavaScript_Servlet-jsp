/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import GUI.Grace_GUI;
import Interface.HandleServerMessage;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author KOSTA
 */
public class HandleServerLoginMessage implements HandleServerMessage{

    @Override
    public boolean handledata(String msg,Grace_GUI gui) {
        StringTokenizer st=new StringTokenizer(msg, "^");
        String loginResult=st.nextToken();
        //로그인 성공시 필드멤버인 Member의 값을 채워줌
        //회원정보를 인메모리에 저장
        gui.getMember().setId(st.nextToken());
        gui.getMember().setName(st.nextToken());
        gui.getMember().setPassword(st.nextToken());
        gui.getMember().setCellphone(st.nextToken());


        if (loginResult.equals("true")) {
            setAdminSearchBox(gui.getMember().getId(), gui);
            gui.getLabel_LoginID().setText(gui.getMember().getName());
            JOptionPane.showMessageDialog(gui, "로그인 되었습니다.");
            gui.getCard().show(gui.getCardPanel(), "cardReservation");
            return true;
        }
        //비밀번호 오류
        else if (loginResult.equals("false")||loginResult.equals("none")) {
            JOptionPane.showMessageDialog(gui, "비밀번호 혹은 아이디가 맞지 않습니다.");
            gui.getLoginidv().setText("");
            
        }
        return false;
    }
     private void setAdminSearchBox(String id,Grace_GUI gui){
        if(id.equals("admin")){

            gui.getMember().setAdmin(true);
            gui.getLabel_Admin().setVisible(true);
            gui.getTextField_Admin().setVisible(true);
            gui.getButton_Admin().setVisible(true);
        }
        else{
            gui.getMember().setAdmin(false);
            gui.getLabel_Admin().setVisible(false);
            gui.getTextField_Admin().setVisible(false);
            gui.getButton_Admin().setVisible(false);
        }
    }
    
}
