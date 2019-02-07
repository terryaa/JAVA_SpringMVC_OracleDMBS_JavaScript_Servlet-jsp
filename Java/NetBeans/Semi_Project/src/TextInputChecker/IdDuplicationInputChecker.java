/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TextInputChecker;

import GUI.Grace_GUI;
import Interface.TextInputCheckInter;
import javax.swing.JOptionPane;

/**
 *
 * @author KOSTA
 */
public class IdDuplicationInputChecker implements TextInputCheckInter{

    @Override
    public boolean textIntputCheck(Grace_GUI gui) {
        if(gui.getSearch_id().equals(""))
            JOptionPane.showMessageDialog(gui, "아이디입력");
        else
            return false;
        return true;
    }
    
}
