/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import GUI.Grace_GUI;
import Interface.TextInputCheckInter;
import javax.swing.JOptionPane;
import POJO.Member;

/**
 *
 * @author KOSTA
 */
public class LoginTextInputChecker implements TextInputCheckInter {
        public boolean textIntputCheck(Grace_GUI gui){
            String id=gui.getLoginidv().getText().trim();
            String password=gui.getLoginpwv().getText().trim();
            if (id.equals("")) {
                JOptionPane.showMessageDialog(gui, "아이디를 입력해주세요");
                gui.getLoginidv().requestFocus();
            }
            else if (password.equals("")) {
                JOptionPane.showMessageDialog(gui, "비밀번호를 입력해주세요");
                gui.getLoginpwv().requestFocus();
            }
            else{
                gui.setMember(new Member(id,password));
                return true;
            }
            return false;
        }
}
