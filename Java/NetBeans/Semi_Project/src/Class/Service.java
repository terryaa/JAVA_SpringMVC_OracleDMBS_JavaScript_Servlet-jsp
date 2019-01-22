/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Interface.ServiceInter;
import POJO.Member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * Service클래스는 GUI에서 동작하며, GUI에서 필요한 Business Logic 을 작성 구현클래스이다. 
 * @author younghoonkim
 */
public class Service implements ServiceInter{
    
     private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
     
     //예약을 클릭했을시 해당 Table의 행 번호를 얻어와 상세정보를 만들어 출력해준다. 
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

    //GUI시작시 달력, 시간 초기화 및 GUI에 표시하는 역할을 한다
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
    
    //선택되어있는 날짜사이에 있는 예약정보들로 얻어와 예약정보리스트를 새로고침한다. 
     @Override
    public void reservationListRefresh(JDatePickerImpl[] datePicker,PrintWriter pw,Member member){
        
        
        Date date=(Date)datePicker[0].getModel().getValue();
        String startEndDate;
        if(member.isAdmin()){
            startEndDate="date:"+"admin:"+sdf.format(date);
        }
        else{
            startEndDate="date:"+member.getId()+":"+sdf.format(date);
        }
        date=(Date)datePicker[1].getModel().getValue();
        startEndDate+=":"+sdf.format(date);
        pw.println(startEndDate);
        pw.flush();
    }
        
}
