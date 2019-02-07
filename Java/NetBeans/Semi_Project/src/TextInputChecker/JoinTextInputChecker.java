/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TextInputChecker;

import GUI.Grace_GUI;
import Interface.TextInputCheckInter;
import POJO.Member;
import javax.swing.JOptionPane;

/**
 *
 * @author KOSTA
 */
public class JoinTextInputChecker implements TextInputCheckInter {
    public boolean textIntputCheck(Grace_GUI gui){
        String namev =gui.getJoinname().getText(); //입력한 값을 namev에 대입
        String idv = gui.getJoinid().getText(); // 입력한 값을 idv에 대입
        String passwordv = gui.getJoinpw().getText(); //입력한 값을 passwordv에 대입
        String cellphonev1 = gui.getJoincell1().getText(); // 입력한 값을 cell1에 대입
        String cellphonev2 = gui.getJoincell2().getText(); // 입력한 값을 cell2에 대입
        String cellphonev3 = gui.getJoincell3().getText(); // 입력한 값을 cell3에 대입
        
        if (namev.equals("")) { //namev가 빈칸일 경우
            JOptionPane.showMessageDialog(gui, "이름을 입력하세요"); // 에러메시지
        } else if (idv.equals("")) { // idv가 빈칸일 경우
            JOptionPane.showMessageDialog(gui, "아아디를 입력하세요");
        } else if (passwordv.equals("")) { // passwordv가 빈칸일 경우
            JOptionPane.showMessageDialog(gui, "비밀번호를 입력하세요");
        } else if (cellphonev1.equals("") || cellphonev2.equals("") || cellphonev3.equals("")) {
            // cell1,2,3이 빈칸일 경우
            JOptionPane.showMessageDialog(gui, "핸드폰 번호를 입력하세요");
        } else if (!(cellphonev1.matches("[0-9]{3}") && cellphonev2.matches("[0-9]{4}") && cellphonev3.matches("[0-9]{4}"))) {
            // cell1,2,3이 숫자가 아니고, 각각 3,4,4 글자가 아닐 경우
            JOptionPane.showMessageDialog(gui, "핸드폰 번호를 다시 입력하세요");
        } else if (gui.isCheck() == false) { // 중복체크를 안했을 경우
            JOptionPane.showMessageDialog(gui, "중복 체크 하세요");
        }else if(!(idv.equals(gui.getSearch_id()))) { // 입력된 idv와 현재joinid가 같지 않을 경우
            System.out.println(gui.getSearch_id());
            JOptionPane.showMessageDialog(gui, "중복체크를 다시 하세요");
        }else{
            gui.setMember(new Member(namev,idv,passwordv,cellphonev1+"-"+cellphonev2+"-"+cellphonev3));
            return false;
        }
        return true;
            
        
    }
}
