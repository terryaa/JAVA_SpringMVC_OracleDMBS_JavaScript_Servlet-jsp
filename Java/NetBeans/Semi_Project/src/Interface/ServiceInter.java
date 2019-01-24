/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import GUI.Grace_GUI;

/**
 *
 * @author younghoonkim
 */
public interface ServiceInter {
    
    //예약을 클릭했을시 해당 Table의 행 번호를 얻어와 상세정보를 만들어 출력해준다. 
    public void displayDetailedInfo(Grace_GUI gui);
    //GUI시작시 달력, 시간 초기화 및 GUI에 표시하는 역할을 한다
    public void serviceStart(Grace_GUI gui);
    //선택되어있는 날짜사이에 있는 예약정보들로 얻어와 예약정보리스트를 새로고침한다. 
    public void reservationListRefresh(Grace_GUI gui);
    //로그인 조건을 만족시킬시, 아이디와 패스워드를 서버에 전송하여
    //로그인 성공여부를 전송받아 결과를 알려준다.
    //로그인을 위한 칸들의 조건이 구현되어있다.
    public void login(Grace_GUI gui);
        //회원가입의 모든 조건을 확인하여 조건에 맞을시 회원가입요청을 서버에 전송한다.
    //회원가입 항목 모든 칸에대한 조건이 구현되어있다.
    public void join(Grace_GUI gui);
    //회원가입시 아이디가 이미 등록되어있는지 체크를위해 서버에 아이디를 전송하여
    //중복여부를 결과로 받아 알려준다.
    public void idCheck(Grace_GUI gui);
     //예약하기 버튼을 누를경우 admin/일반사용자를 나누어
    //예약정보를 서버에 전송하여 예약을 저장한뒤 결과를 받는다.
    public void makeReservation(Grace_GUI gui);
    public void checkID(Grace_GUI gui);
}
