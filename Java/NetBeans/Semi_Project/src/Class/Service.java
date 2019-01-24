/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import GUI.Grace_GUI;
import Interface.ServiceInter;
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
    
    
    //선택되어있는 날짜사이에 있는 예약정보들로 얻어와 예약정보리스트를 새로고침한다. 
     @Override
    public void reservationListRefresh(Grace_GUI gui){
        
        gui.setReservationListArray(new ArrayList<>());
        //DatePicker로부터 날짜들을 가져온다.
        Date date=(Date)gui.getDatePicker()[0].getModel().getValue();
        String startEndDate;
        //일반회원과 admin구별, 서버에 자료를 요청한다.
        if(gui.getMember().isAdmin()){
            startEndDate="date:"+"admin:"+sdf.format(date);
        }
        else{
            startEndDate="date:"+gui.getMember().getId()+":"+sdf.format(date);
        }
        date=(Date)gui.getDatePicker()[1].getModel().getValue();
        startEndDate+=":"+sdf.format(date);
        if(initSocketPrintWriter(gui)){
            gui.getPw().println(startEndDate);
            gui.getPw().flush();
        }
                try {
                    gui.getS().close();
                    gui.getPw().close();
                } catch (IOException ex) {
                    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    //로그인 조건을 만족시킬시, 아이디와 패스워드를 서버에 전송하여
    //로그인 성공여부를 전송받아 결과를 알려준다.
    //로그인을 위한 칸들의 조건이 구현되어있다.
    @Override
    public void login(Grace_GUI gui){
        
        String id=gui.getLoginidv().getText().trim();
        String password=gui.getLoginpwv().getText().trim();
        
        
         try {gui.setS(new Socket("localhost",9999));
             
             gui.setPw(new PrintWriter(gui.getS().getOutputStream(),true));
         } catch (IOException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
        if (id.equals("")) {
            JOptionPane.showMessageDialog(gui, "아이디를 입력해주세요");
            gui.getLoginidv().requestFocus();
        } 
        else {
            if (password.equals("")) {
                JOptionPane.showMessageDialog(gui, "비밀번호를 입력해주세요");
                gui.getLoginpwv().requestFocus();
            } 
            else {
                    
                    
                String login = "login:" + id + ":" + password + ":";
                gui.getPw().println(login);
                gui.getPw().flush();
                
            
                StringTokenizer st=null;
                BufferedReader br=null;
                try {
                    br = new BufferedReader
                                (new InputStreamReader(gui.getS().getInputStream()));
                    String readLine=br.readLine();
                    st=new StringTokenizer(readLine, ":");
                    String identifier=st.nextToken();
                    if(identifier.equals("login")){
                        String loginResult=st.nextToken();
                        if (loginResult.equals("true")) {
                            JOptionPane.showMessageDialog(gui, "로그인 되었습니다.");
                            gui.getMember().setId(st.nextToken());
                            gui.getMember().setName(st.nextToken());
                            gui.getMember().setPassword(st.nextToken());
                            gui.getMember().setCellphone(st.nextToken());
                            
                            if(gui.getMember().getId().equals("admin"))
                            {
                                gui.getMember().setAdmin(true);
                                gui.getLabel_Admin().setVisible(true);
                                gui.getTextField_Admin().setVisible(true);
                                gui.getButton_Admin().setVisible(true);
                            }
                            else{
                                gui.getMember().setAdmin(false);
                                gui.getLabel_Admin().setVisible(false);
                                gui.getTextField_Admin().setVisible(false);
                                gui.getButton_Admin().setVisible(false);
                            }
                            reservationListRefresh(gui);
                            gui.getLabel_LoginID().setText(gui.getMember().getName());
                            gui.getCard().show(gui.getCardPanel(), "cardReservation");
                        } else if (loginResult.equals("false")) {
                            JOptionPane.showMessageDialog(gui, "비밀번호를 다시 입력해주세요.");
                            gui.getLoginidv().setText("");

                        } else if (loginResult.equals("none")) {
                            JOptionPane.showMessageDialog(gui, "아이디가 없습니다.");
                            gui.getLoginpwv().setText("");
                            gui.getLoginidv().setText("");
                        }else{
                            JOptionPane.showMessageDialog(gui, "알수없는에러.");
                        }
                    }
                } catch (IOException ex) {
                Logger.getLogger(Grace_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                try {
                    br.close();
                    gui.getS().close();
                    gui.getPw().close();
                } catch (IOException ex) {
                    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
            }
        }
        
        
            
        
    }

    //회원가입의 모든 조건을 확인하여 조건에 맞을시 회원가입요청을 서버에 전송한다.
    //회원가입 항목 모든 칸에대한 조건이 구현되어있다.
    @Override
    public void join(Grace_GUI gui){
         
        
        String namev =gui.getJoinname().getText(); //입력한 값을 namev에 대입
        String idv = gui.getJoinid().getText(); // 입력한 값을 idv에 대입
        String passwordv = gui.getJoinpw().getText(); //입력한 값을 passwordv에 대입
        String cellphonev1 = gui.getJoincell1().getText(); // 입력한 값을 cell1에 대입
        String cellphonev2 = gui.getJoincell2().getText(); // 입력한 값을 cell2에 대입
        String cellphonev3 = gui.getJoincell3().getText(); // 입력한 값을 cell3에 대입
        
        BufferedReader br=null;
        
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
        }else if(!(idv.equals(gui.getId()))) { // 입력된 idv와 현재joinid가 같지 않을 경우
            JOptionPane.showMessageDialog(gui, "중복체크를 다시 하세요");
        }
            else {
            if(initSocketPrintWriter(gui)){
                StringBuffer sb=new StringBuffer();
                sb.append("join:");
                sb.append(namev).append(":");
                sb.append(idv).append(":");
                sb.append(passwordv).append(":");
                sb.append(cellphonev1).append(":");
                sb.append(cellphonev2).append(":");
                sb.append(cellphonev3).append(":");
                gui.getPw().println(sb.toString());
                gui.getPw().flush();



                try {
                    br = new BufferedReader
                            (new InputStreamReader(gui.getS().getInputStream()));
                    String readLine=br.readLine();
                    if(readLine.contains("true")){
                        JOptionPane.showMessageDialog(gui, "회원가입이 완료되었습니다.");
                        gui.getCard().show(gui.getCardPanel(), "cardLogin");
                    }

                } catch (IOException ex) {
                    System.out.println("Data Transmission failure");
                    JOptionPane.showMessageDialog(gui, "서버 에러");
                }finally{
                    try {
                        gui.getS().close();
                        gui.getPw().close();
                    br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                }
            }
            
        }
        
    }
    //회원가입시 아이디가 이미 등록되어있는지 체크를위해 서버에 아이디를 전송하여
    //중복여부를 결과로 받아 알려준다.
    @Override
    public void idCheck(Grace_GUI gui){
        BufferedReader br = null;
         try {
             String msg=null;
             if (gui.getJoinid().getText().equals("")) { // idv가 빈칸인 상태에서 중복체크버튼을 눌렀을 때
                 JOptionPane.showMessageDialog(gui, "아이디입력");
             }else{
                 gui.setId(gui.getJoinid().getText()); // joinid 에 입력된 값을 id에 저장
                 msg="id_check:" + gui.getId() + ":";
             }
            if(initSocketPrintWriter(gui)){

                 br = new BufferedReader(new InputStreamReader(gui.getS().getInputStream()));
                 System.out.println(msg);
                 gui.getPw().println(msg);
                 gui.getPw().flush();
                 String answer = br.readLine();

                 System.out.println(answer);
                 StringTokenizer stz = new StringTokenizer(answer, ":");
                 String token = stz.nextToken();

                 if (token.equals("id_check")) {
                     if (stz.nextToken().equals("true")) {
                         JOptionPane.showMessageDialog(gui, "사용가능한 아이디입니다.");
                         gui.setCheck(true);
                     }
                     else {
                         JOptionPane.showMessageDialog(gui, "이미 존재하는 아이디입니다.");
                         gui.setCheck(false);
                     }
                 }
             }
         }
         catch (IOException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
                 
             try {
                 gui.getS().close();
                 gui.getPw().close();
                 br.close();
             } catch (IOException ex) {
                 Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
   
    //소켓과 프린트라이터 초기화 메소드
    private boolean initSocketPrintWriter(Grace_GUI gui){
        
         try {
             gui.setS(new Socket("localhost",9999));
             gui.setPw(new PrintWriter(gui.getS().getOutputStream(),true));
             return true;
         } catch (IOException ex) {
             JOptionPane.showMessageDialog(gui, "Server Failure.");
             return false;
         }
         
    }
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
              if(initSocketPrintWriter(gui)){
                  if(gui.getMember().isAdmin()){
                      gui.getPw().println("make:"+gui.getReserveTockenAdmin());
                  }
                  else
                      gui.getPw().println("make:"+gui.getReserveTocken());
              }
              BufferedReader br=null;
              
            try {
                br = new BufferedReader(new InputStreamReader(gui.getS().getInputStream()));
                String readLine=br.readLine();
                if(readLine.equals("duplication")){
                    gui.getLabelError().setForeground(Color.GREEN);
                    //중복일시에 텍스트컬러를 초록색으로 바꿈.

                    gui.getLabelError().setText("이미 예약되어 있습니다. 다른 시간에 예약하세요.");
                    //다른시간에 예약되었다고 출력하게 만듬
                }
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
         try {
             gui.getS().close();
             gui.getPw().close();
         } catch (IOException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
    }


    
    @Override
    //관리자가 검색을 눌렀을시 서버와 통신하여 아이디가 존재하는지여부를 검색한뒤 결과를 GUI에서알려줌. 
    public void checkID(Grace_GUI gui){
         BufferedReader br = null;
         try {
             String msg=null;
             String id=gui.getTextField_Admin().getText();
             if (id.equals("")) { // idv가 빈칸인 상태에서 중복체크버튼을 눌렀을 때
                 JOptionPane.showMessageDialog(gui, "아이디입력");
             }else{
                  // joinid 에 입력된 값을 id에 저장
                 msg="id_search:" + id + ":";
             }
            if(initSocketPrintWriter(gui)){

                 br = new BufferedReader(new InputStreamReader(gui.getS().getInputStream()));
                 System.out.println(msg);
                 gui.getPw().println(msg);
                 gui.getPw().flush();
                 String answer = br.readLine();

                 System.out.println(answer);
                 StringTokenizer stz = new StringTokenizer(answer, ":");
                 String token = stz.nextToken();

                 if (token.equals("id_search")) {
                     if (stz.nextToken().equals("true")) {
                         JOptionPane.showMessageDialog(gui, "회원 검색 완료");
                         gui.setSearch_id(stz.nextToken());
                         gui.setSearch_name(stz.nextToken());
                     }
                     else {
                         JOptionPane.showMessageDialog(gui, "검색 아이디를 다시 확인하여주세요");
                     }
                 }
             }
         }
         catch (IOException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
                 
             try {
                 gui.getS().close();
                 gui.getPw().close();
                 br.close();
             } catch (IOException ex) {
                 Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
        
}
