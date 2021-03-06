/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import GUI.Grace_GUI;
import HandleServerMessage.HandleServerIdDuplicationMessage;
import HandleServerMessage.HandleServerJoinMessage;
import HandleServerMessage.HandleServerLoginMessage;
import Interface.HandleServerMessage;
import Interface.ServiceInter;
import Interface.TextInputCheckInter;
import POJO.Member;
import POJO.Reservation;
import TextInputChecker.IdDuplicationInputChecker;
import TextInputChecker.JoinTextInputChecker;
import TextInputChecker.LoginTextInputChecker;
import TextInputChecker.SearchIdInputChecker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * Service클래스는 GUI에서 동작하며, GUI에서 필요한 Business Logic 을 작성 구현클래스이다. 
 * @author younghoonkim
 */
public class Service implements ServiceInter{
    
     private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
     private final SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
     TextInputCheckInter tici;
     HandleServerMessage hsm;
     private ArrayList<Reservation> list=null;
     
     //예약을 클릭했을시 해당 Table의 행 번호를 얻어와 상세정보를 만들어 출력해준다. 
     @Override
    public void displayDetailedInfo(Grace_GUI gui){
        
        gui.getReservationTable().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    //예약리스트,table,선택된 행번호를 매게변수로 가져가
                    //해당 행의 번호를 이용하여 예약정보리스트에서 선택된 정보가 들어있는 arraylist를 선택,
                    //arraylist에들어있는 정보를 출력형태에 맞게 바꾸어 GUI에 표현한다.
                    gui.getDetailedInfo().selectAll();
                    gui.getDetailedInfo().cut();
                    int row=gui.getReservationTable().rowAtPoint(evt.getPoint());
                    //자료를 스트링버퍼에만들어 저장.
                  StringBuffer sb=new StringBuffer();
                     if (row >= 0) {
                        Reservation resv=list.get(row);
                        sb.append("아이디 : ").append(resv.getId()).append("\n");
                        sb.append("이름 : ").append(resv.getName()).append("\n");
                        sb.append("예약시간 : ").append(resv.getDate()).append("\n");
                        sb.append("시술종류 : ").append(resv.getProgram()).append("\n");
                        sb.append("의사메모 : ").append(resv.getMemo()).append("\n");
                     }
                     //출력창에 출력.
                     gui.getDetailedInfo().append(sb.toString());
                            }
                        });
        //출력창 초기화
        
    }

    //GUI시작시 달력, 시간 초기화 및 GUI에 표시하는 역할을 한다
    @Override
    public void serviceStart(Grace_GUI gui) {
        
        String yearMonthDay = sdf.format(new Date());
        gui.getCurrentYearMonthDay().setText(yearMonthDay);
            
        Calendar cal=Calendar.getInstance(TimeZone.getDefault());
            
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");


        this.initCalender(gui, cal, p);
        Timer timer=gui.getTimer();
        
            timer=new Timer(500, (ActionEvent e) -> {
                String HourMin=sdf2.format(new Date());
                gui.getCurrentHourMin().setText(HourMin);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });
            timer.setInitialDelay(0);
            timer.start();
    } 
     private void initCalender(Grace_GUI gui, Calendar cal, Properties p){
        UtilDateModel[] model=gui.getModel();
        JDatePanelImpl[] datePanel=gui.getDatePanel();
        JDatePickerImpl[] datePicker=gui.getDatePicker();
        for(int i=0;i<model.length;i++){
            model[i]=new UtilDateModel();
        model[i].setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+i, cal.get(Calendar.DATE));
        model[i].setSelected(true);
        datePanel[i]=new JDatePanelImpl(model[i], p);
        datePicker[i]=new JDatePickerImpl(datePanel[i], new DateLabelFormatter());
        datePicker[i].setBounds(10+140*i,115,130,30);
        gui.getCardRervation().add(datePicker[i]);
        }
    }
    
    public void initTable(Grace_GUI gui){
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(gui.getS().getInputStream());
            list= (ArrayList) ois.readObject();

            ArrayList<String> reservationListArray=new ArrayList<>();
            DefaultTableModel dtm = (DefaultTableModel) gui.getReservationTable().getModel();
            if(list!=null)
            {
                dtm.setRowCount(list.size());
                for(int row=0;row<list.size();row++){
                    Reservation resv=list.get(row);
                    gui.getReservationTable().setValueAt(resv.getName(), row, 0);
                    gui.getReservationTable().setValueAt(resv.getDate(), row, 1);
                    gui.getReservationTable().setValueAt(resv.getProgram(), row, 2);
                }
            }


                
            } catch (IOException ex) {
                System.out.println("Data transmission failed from Server");
            } catch (ClassNotFoundException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
            try {
                gui.setBr(new BufferedReader(new InputStreamReader(gui.getS().getInputStream())));
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
    }
    //선택되어있는 날짜사이에 있는 예약정보들로 얻어와 예약정보리스트를 새로고침한다. 
     @Override
    public void reservationListRefresh(Grace_GUI gui){
        gui.setReservationListArray(new ArrayList<>());
        //DatePicker로부터 날짜들을 가져온다.
        //검색 시작일
        StringBuffer sb=new StringBuffer();
        sb.append("date^");
        sb.append(gui.getMember().getId()).append("^");
        sb.append(datePick(gui,0)).append("^");
        sb.append(datePick(gui,1)).append("^");
        
        //일반회원과 admin구별, 서버에 자료를 요청한다.
        gui.getPw().println(sb.toString());
        initTable(gui);
    }
    private String datePick(Grace_GUI gui,int num){
        Date date=(Date)gui.getDatePicker()[num].getModel().getValue();
        return sdf.format(date);
    }

    
   //예약하기 버튼을 누를경우 admin/일반사용자를 나누어
    //예약정보를 서버에 전송하여 예약을 저장한뒤 결과를 받는다.
   
    
    @Override
    public void makeReservation(Grace_GUI gui){
        gui.Action();
        tici=new SearchIdInputChecker();
        if(!tici.textIntputCheck(gui)){
             if(gui.getMember().isAdmin()){
                      gui.getPw().println("make^"+"id^"+gui.getReserveTockenAdmin());
                  }
                  else
                      gui.getPw().println("make^"+"id^"+gui.getReserveTocken());
             try {
                String readLine=gui.getBr().readLine();
                if(readLine.equals("duplication")){
                    gui.getLabelError().setForeground(Color.GREEN);
                    //중복일시에 텍스트컬러를 초록색으로 바꿈.
                }
                    else{
                      gui.getLabelError().setForeground(Color.blue);
            gui.getLabelError().setText("예약이 완료되었습니다!");
                }
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    
    @Override
    //관리자가 검색을 눌렀을시 서버와 통신하여 아이디가 존재하는지여부를 검색한뒤 결과를 GUI에서알려줌. 
    public void idSearch(Grace_GUI gui){

             if (check(gui)==true) { 
                JOptionPane.showMessageDialog(gui, "회원 검색 완료");
                gui.setCheck(true);
             }
             else {
                JOptionPane.showMessageDialog(gui, "검색 아이디를 다시 확인하여주세요");
                gui.setCheck(false);
                 }
             
    }
    //회원가입시 아이디가 이미 등록되어있는지 체크를위해 서버에 아이디를 전송하여
    //중복여부를 결과로 받아 알려준다.
    @Override
    public void idCheck(Grace_GUI gui){
        
            tici=new IdDuplicationInputChecker();
             if (!tici.textIntputCheck(gui)) { 
                 if (check(gui)==true) {
                     JOptionPane.showMessageDialog(gui, "사용가능한 아이디입니다.");
                     gui.setCheck(true);
                 }
                 else {
                     JOptionPane.showMessageDialog(gui, "이미 존재하는 아이디입니다.");
                     gui.setCheck(false);
                 }
             }
         
    }
    
    
    private boolean check(Grace_GUI gui){
          try {
                 hsm=new HandleServerIdDuplicationMessage();
                 gui.getPw().println(hsm.createRequest(gui));
                 String msg = gui.getBr().readLine();
                 if(hsm.processResponse(msg, gui))
                     System.out.println("Data from Server is not correct");
                 else
                 {
                     return true;
                 }
                
         }
         catch (IOException ex) {
             JOptionPane.showMessageDialog(gui, "서버 에러");
         }
          return false;
    }
       //로그인 조건을 만족시킬시, 아이디와 패스워드를 서버에 전송하여
    //로그인 성공여부를 전송받아 결과를 알려준다.
    //로그인을 위한 칸들의 조건이 구현되어있다.
     @Override
    public void login(Grace_GUI gui){
        tici=new LoginTextInputChecker();
        if (!tici.textIntputCheck(gui))
        {
            hsm=new HandleServerLoginMessage();
            gui.getPw().println(hsm.createRequest(gui));


                try {
                    String readLine=gui.getBr().readLine();
                    hsm=new HandleServerLoginMessage();
                    if(!hsm.processResponse(readLine,gui))
                        System.out.println("Data from Server is not correct");
                    else
                        reservationListRefresh(gui);
                   
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(gui, "서버 에러");
                }
            }
        else
            System.out.println("잘못된 입력");
    }
    
     //회원가입의 모든 조건을 확인하여 조건에 맞을시 회원가입요청을 서버에 전송한다.
    //회원가입 항목 모든 칸에대한 조건이 구현되어있다.
    @Override
    public void join(Grace_GUI gui){
         
        tici=new JoinTextInputChecker();
        if (!tici.textIntputCheck(gui)){
            hsm=new HandleServerJoinMessage();
            gui.getPw().println(hsm.createRequest(gui));
            gui.getPw().flush();
            try {
                String readLine=gui.getBr().readLine();
                if(!hsm.processResponse(readLine, gui)){
                     System.out.println("Data from Server is not correct");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(gui, "서버 에러");
            }
        }
        else {
             System.out.println("잘못된 입력");
        }
        
    }
    
        
}
