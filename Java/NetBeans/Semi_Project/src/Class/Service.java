/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import GUI.Info_GUI;
import Interface.ServiceInter;
import POJO.Member;
import POJO.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.lang.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Future;


/**
 *
 * @author younghoonkim
 */
public class Service implements ServiceInter{
    
     private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
     @Override
    public void displayDetailedInfo(javax.swing.JTextArea detailedInfo,ArrayList<String> array,int row){
        detailedInfo.selectAll();
        detailedInfo.cut();
      StringBuffer sb=new StringBuffer();
         if (row >= 0) {
            StringTokenizer st=new StringTokenizer(array.get(row),":");
            sb.append("아이디 : ").append(st.nextToken()).append("\n");
            sb.append("이름 : ").append(st.nextToken()).append("\n");
            sb.append("예약시간 : ").append(st.nextToken()).append("\n");
            sb.append("시술종류 : ").append(st.nextToken()).append("\n");
            sb.append("남은 보톡스 예약횟수 : ").append(st.nextToken()).append("\n");
            sb.append("남은 레이저 예약횟수 : ").append(st.nextToken()).append("\n");
            sb.append("남은 피부관리 예약횟수 : ").append(st.nextToken()).append("\n");
            sb.append("의사메모 : ").append(st.nextToken()).append("\n");
         }
         detailedInfo.append(sb.toString());
    }

    @Override
    public void serviceStart(Timer timer,UtilDateModel[] model,JDatePanelImpl[] datePanel,JDatePickerImpl[] datePicker,
            JLabel currentYearMonthDay,JLabel currentHourMin, JFrame gui) {
        
        String yearMonthDay = sdf.format(new Date());
        currentYearMonthDay.setText(yearMonthDay);
            
        Calendar cal=Calendar.getInstance(TimeZone.getDefault());
            
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        LocalDate now=LocalDate.now();


        model[0]=new UtilDateModel();

        model[0].setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        model[0].setSelected(true);
        datePanel[0]=new JDatePanelImpl(model[0], p);
        datePicker[0]=new JDatePickerImpl(datePanel[0], new DateLabelFormatter());
        datePicker[0].setBounds(10,75,130,30);
        gui.add(datePicker[0]);


        model[1]=new UtilDateModel();
        model[1].setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 1);
        model[1].setSelected(true);
        datePanel[1]=new JDatePanelImpl(model[1], p);
        datePicker[1]=new JDatePickerImpl(datePanel[1], new DateLabelFormatter());
        datePicker[1].setBounds(150,75,130,30);
        gui.add(datePicker[1]);
        
        final SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
            timer=new Timer(500,new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String HourMin=sdf2.format(new Date());
                    currentHourMin.setText(HourMin);
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            timer.setInitialDelay(0);
            timer.start();
    } 
     @Override
    public void reservationListRefresh(JDatePickerImpl[] datePicker,PrintWriter pw,Member member){
        
        
        Date date=(Date)datePicker[0].getModel().getValue();
        String startEndDate;
        if(member.isAdmin()){
            startEndDate="date:"+"admin:"+sdf.format(date);
        }
        else{
            startEndDate="date:"+member.getId()+sdf.format(date);
        }
        date=(Date)datePicker[1].getModel().getValue();
        startEndDate+=":"+sdf.format(date);
        pw.println(startEndDate);
        pw.flush();
    }
    
     @Override
    public ArrayList<String> initTable(JTable reservationTable,Socket s){
         ArrayList<String>tempList=new ArrayList<>();
        class ReservationList implements Callable<ArrayList<String>>{
            ArrayList<String> reservationListArray;
            @Override
            public ArrayList<String> call(){
                try {
                    reservationListArray=new ArrayList<>();
                    BufferedReader br=new BufferedReader
                (new InputStreamReader(s.getInputStream()));
                    System.out.println("buffer");
                    while(true){
                        StringTokenizer st1=new StringTokenizer(br.readLine(),"\n");
                        System.out.println("readline");
                        
                        
                        while(st1.hasMoreTokens()){
                            reservationListArray.add(st1.nextToken());
                             

                        for(int col=0;col<reservationListArray.size();col++){
                            StringTokenizer st2=new StringTokenizer(
                                    reservationListArray.get(col),":");
                            st2.nextToken();
                            DefaultTableModel dtm = (DefaultTableModel) reservationTable.getModel();
                            dtm.setRowCount(reservationListArray.size());
                            //reservationTable.se
                            for(int row=0;row<3;row++)
                            {
                                reservationTable.setValueAt(st2.nextToken(), col, row);
                            }
                        }
                        
                        }
                    }
                        
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (IOException ex) {
                    System.out.println("Data transmission failed from Server");
                }
                return reservationListArray;
            }
                
            
        }
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<ArrayList<String>> reservationListArray = service.submit(new ReservationList());
         
         try {
            tempList= reservationListArray.get();
             System.out.println(tempList.get(0));
             
             
             
             //return rla.getReservationListArray();
         } catch (InterruptedException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ExecutionException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
         return tempList;
    }
        
}
