/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import GUI.Grace_GUI;
import POJO.Member;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author younghoonkim
 */
public interface ServiceInter {
    
    public void displayDetailedInfo(Grace_GUI gui);
    public void serviceStart(Grace_GUI gui);
    public void reservationListRefresh(Grace_GUI gui);
    public void login(Grace_GUI gui);
    public void setReservationTable(Grace_GUI gui);
    public void join(Grace_GUI gui);
    public void idCheck(Grace_GUI gui);
    public void makeReservation(Grace_GUI gui);
    public void checkID(Grace_GUI gui);
}
