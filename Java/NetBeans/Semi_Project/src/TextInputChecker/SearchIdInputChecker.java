/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TextInputChecker;

import GUI.Grace_GUI;
import Interface.TextInputCheckInter;
import java.awt.Color;

/**
 *
 * @author KOSTA
 */
public class SearchIdInputChecker implements TextInputCheckInter{

    @Override
    public boolean textIntputCheck(Grace_GUI gui) {
         if(gui.getReserveinfo().length() >= 19){
            //만약 길이가 19가 넘으면
            gui.getLabelError().setForeground(Color.red);
            //라벨 텍스트 색을 빨간색으로.
            gui.getLabelError().setText("정확히 입력해주세요.");
            //정확히 입력해주세요를 Label에 출력

        }else if(gui.getReservememolength() >= 20){
            gui.getLabelError().setForeground(Color.black);
            gui.getLabelError().setText("메모의 글자수가 초과하였습니다.");
        }
         else
            return false;
         return true;
    }
    
}
