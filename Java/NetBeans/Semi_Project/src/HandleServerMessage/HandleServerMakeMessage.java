/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HandleServerMessage;

import Class.Service;
import GUI.Grace_GUI;
import Interface.HandleServerMessage;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class HandleServerMakeMessage implements HandleServerMessage {

    @Override
    public String createRequest(Grace_GUI gui) {
        return null;
    }

    @Override
    public boolean processResponse(String msg, Grace_GUI gui) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
