/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import GUI.Info_GUI;
import POJO.Member;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author younghoonkim
 */
public interface ServiceInter {
    
    public void displayDetailedInfo(javax.swing.JTextArea detailedInfo,ArrayList<String> array,int row);
    public void serviceStart(Timer timer,UtilDateModel[] model,JDatePanelImpl[] datePanel,JDatePickerImpl[] datePicker,
            JLabel currentYearMonthDay,JLabel currentHourMin,JFrame gui);
    public void reservationListRefresh(JDatePickerImpl[] datePicker,PrintWriter pw,Member member);
    
}
