/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import GUI.Grace_GUI;
import Interface.HandleServerMessage;
import Interface.ServiceInter;
import Interface.TextInputCheckInter;
import POJO.Member;
import java.awt.Color;
import java.awt.event.ActionEvent;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

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
                        StringTokenizer st=new StringTokenizer(gui.getReservationListArray().get(row),":");
                        sb.append("아이디 : ").append(st.nextToken()).append("\n");
                        sb.append("이름 : ").append(st.nextToken()).append("\n");
                        sb.append("예약시간 : ").append(st.nextToken()).append("\n");
                        sb.append("시술종류 : ").append(st.nextToken()).append("\n");
//                        sb.append("남은 보톡스 예약횟수 : ").append(st.nextToken()).append("\n");
//                        sb.append("남은 레이저 예약횟수 : ").append(st.nextToken()).append("\n");
//                        sb.append("남은 피부관리 예약횟수 : ").append(st.nextToken()).append("\n");
                        sb.append("의사메모 : ").append(st.nextToken()).append("\n");
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
          try {
                Socket s;
               // s=gui.getS();
                ArrayList<String> reservationListArray=new ArrayList<>();
                DefaultTableModel dtm = (DefaultTableModel) gui.getReservationTable().getModel();
                BufferedReader br=new BufferedReader
                        (new InputStreamReader(gui.getS()
                                .getInputStream()));
                String readLine=br.readLine();
                if(!readLine.equals("")){
                StringTokenizer st=new StringTokenizer(readLine,"^");
                String str=st.nextToken();
                if(str.equals("date"))
                {
                    StringTokenizer st1=new StringTokenizer(st.nextToken(),"\n");


                    while(st1.hasMoreTokens())
                    {
                        reservationListArray.add(st1.nextToken());


                        for(int col=0;col<reservationListArray.size();col++){
                            StringTokenizer st2=new StringTokenizer(
                                    reservationListArray.get(col),":");
                            st2.nextToken();

                            dtm.setRowCount(reservationListArray.size());
                            //reservationTable.se
                            for(int row=0;row<3;row++)
                            {
                                gui.getReservationTable().setValueAt(st2.nextToken(), col, row);
                            }
                        }

                    }
                    }
                    else if(str.contains("login")||str.contains("join")||
                            str.contains("id_check")||str.contains("make")
                            ||str.contains("id_search")||str.contains("duplication")){
                        System.out.println("no data to fetch");
                    }
                    else{
                          System.out.println("no data to fetch");
                        dtm.setRowCount(0);
                    }
                    }

                
            } catch (IOException ex) {
                System.out.println("Data transmission failed from Server");
            }finally{
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
        sb.append(datePick(gui,1)).append("^");
        sb.append(datePick(gui,2)).append("^");
        
        //일반회원과 admin구별, 서버에 자료를 요청한다.
        gui.getPw().println(sb.toString());
        initTable(gui);
    }
    private String datePick(Grace_GUI gui,int num){
        Date date=(Date)gui.getDatePicker()[num].getModel().getValue();
        return sdf.format(date);
    }
    //로그인 조건을 만족시킬시, 아이디와 패스워드를 서버에 전송하여
    //로그인 성공여부를 전송받아 결과를 알려준다.
    //로그인을 위한 칸들의 조건이 구현되어있다.
   
  

    //회원가입의 모든 조건을 확인하여 조건에 맞을시 회원가입요청을 서버에 전송한다.
    //회원가입 항목 모든 칸에대한 조건이 구현되어있다.

      
   
    
   //예약하기 버튼을 누를경우 admin/일반사용자를 나누어
    //예약정보를 서버에 전송하여 예약을 저장한뒤 결과를 받는다.
   
    
    @Override
    public void makeReservation(Grace_GUI gui){
        gui.Action();
        
        if(gui.getReserveinfo().length() >= 19){
            //만약 길이가 19가 넘으면
            gui.getLabelError().setForeground(Color.red);
            //라벨 텍스트 색을 빨간색으로.
            gui.getLabelError().setText("정확히 입력해주세요.");
            //정확히 입력해주세요를 Label에 출력

        }else if(gui.getReservememolength() >= 20){
            gui.getLabelError().setForeground(Color.black);
            gui.getLabelError().setText("메모의 글자수가 초과하였습니다.");

        }else {
            gui.getLabelError().setForeground(Color.blue);
            gui.getLabelError().setText("예약이 완료되었습니다!");
                  if(gui.getMember().isAdmin()){
                      gui.getPw().println("make^"+gui.getReserveTockenAdmin());
                  }
                  else
                      gui.getPw().println("make^"+gui.getReserveTocken());
              
            try {
                String readLine=gui.getBr().readLine();
                if(readLine.equals("duplication")){
                    gui.getLabelError().setForeground(Color.GREEN);
                    //중복일시에 텍스트컬러를 초록색으로 바꿈.
                }
                    else{
                    gui.getLabelError().setText("이미 예약되어 있습니다. 다른 시간에 예약하세요.");
                    //다른시간에 예약되었다고 출력하게 만듬
                }
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    
    @Override
    //관리자가 검색을 눌렀을시 서버와 통신하여 아이디가 존재하는지여부를 검색한뒤 결과를 GUI에서알려줌. 
    public void idSearch(Grace_GUI gui,String id){

             if (check(gui,id)==true) { 
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
    public void idCheck(Grace_GUI gui,String id){
        
                 if (check(gui,id)==true) {
                     JOptionPane.showMessageDialog(gui, "사용가능한 아이디입니다.");
                     gui.setCheck(true);
                 }
                 else {
                     JOptionPane.showMessageDialog(gui, "이미 존재하는 아이디입니다.");
                     gui.setCheck(false);
                 }
         
    }
    
    
    private boolean check(Grace_GUI gui,String id){
          try {
             String msg=null;
             if (id.equals("")) { // idv가 빈칸인 상태에서 중복체크버튼을 눌렀을 때
                 JOptionPane.showMessageDialog(gui, "아이디입력");
             }else{
                 gui.setId(id); // joinid 에 입력된 값을 id에 저장
                 msg="check^" +id  + "^";
             }
                 //gui.setBr(new BufferedReader(new InputStreamReader(gui.getS().getInputStream())));
                 gui.getPw().println(msg);
                 gui.getPw().flush();
                 String answer = gui.getBr().readLine();
                 
                 StringTokenizer stz = new StringTokenizer(answer, "^");
                 String token = stz.nextToken();

                 if (token.equals("true")) {
                     return true;
                 }
                 else {
                     return false;
                 }
                 
             
         }
         catch (IOException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
          return false;
    }
   
     @Override
    public void login(Grace_GUI gui){
        tici=new LoginTextInputChecker();
        if (tici.textIntputCheck(gui))
        {
            StringBuffer sb=new StringBuffer();
            sb.append("login^").append(gui.getMember().getId()).append("^");
            sb.append(gui.getMember().getPassword()).append("^");
            gui.getPw().println(sb.toString());


                StringTokenizer st=null;
                try {
                    String readLine=gui.getBr().readLine();
                    hsm=new HandleServerLoginMessage();
                    if(hsm.handledata(readLine,gui)){
                         reservationListRefresh(gui);
                    }
                   
                } catch (IOException ex) {
                Logger.getLogger(Grace_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        else
            JOptionPane.showMessageDialog(gui, "알수없는 에러");
    }
    @Override
    public void join(Grace_GUI gui){
         
        tici=new JoinTextInputChecker();
        if (tici.textIntputCheck(gui)){
            Member mem=gui.getMember();
            StringBuffer sb=new StringBuffer();
                sb.append("join^");
                sb.append(mem.getName()).append(":");
                sb.append(mem.getId()).append(":");
                sb.append(mem.getPassword()).append(":");
                sb.append(mem.getCellphone()).append(":");
                gui.getPw().println(sb.toString());
                gui.getPw().flush();
                try {
                    String readLine=gui.getBr().readLine();
                    if(readLine.contains("true")){
                        JOptionPane.showMessageDialog(gui, "회원가입이 완료되었습니다.");
                        gui.getCard().show(gui.getCardPanel(), "cardLogin");
                    }
                } catch (IOException ex) {
                    System.out.println("Data Transmission failure");
                    JOptionPane.showMessageDialog(gui, "서버 에러");
                }
        }
        else {
             JOptionPane.showMessageDialog(gui, "잘못된 입력");    
        }
        
    }
    
        
}
