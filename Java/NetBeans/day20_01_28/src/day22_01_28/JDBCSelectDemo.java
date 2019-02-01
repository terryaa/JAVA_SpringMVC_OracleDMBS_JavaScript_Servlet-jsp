/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package day22_01_28;

import exam.MyConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KOSTA
 */
//네트워크에서 접근하는 스레드일경우
    //connection관리가 원할하게 안될경우
//싱글톤,동기화로 관리를 해야한다
public class JDBCSelectDemo {
    //static 개념복습
    private static JDBCSelectDemo jsda;
    //getJsdd() 호출시 jdbcselectdemo를
    //반환하는 스태틱 메소드
    public static synchronized JDBCSelectDemo getJsda(){
        //스레드들중 (Ex> t1,t2,t3..) 먼저 접근하는 스레드에게
        //생성하도록 하고, 나머지는 이미 생성된 주소를 받아서 사용하도록한다.
        //static영역에 존재하는
        if(jsda==null){
            jsda=new JDBCSelectDemo();
        }
        
        return jsda;
    }
    
    //이 생성자는 밖에서생성안함으로 반드시 private
    private JDBCSelectDemo(){}
    
    //Dept 는 부서 테이블의값
    //하나의 row 를 저장할 객체 -> DeptVO
    //모두 저장할 Collection -> List
    public List<DeptVO> getDeptList() throws SQLException{
        
        List<DeptVO> list =new ArrayList<>();
        Connection con=MyConn.getConn();
        String sql="select deptno,dname,loc from dept";
        PreparedStatement pstmt=con.prepareStatement(sql);
        //select의 경우 검색
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            DeptVO vo=new DeptVO();
            vo.setDeptno(rs.getInt("deptno"));
            vo.setDname(rs.getString("dname"));
            vo.setLoc(rs.getString("loc"));
            list.add(vo);
        }
        con.close();
        return list;
        }
    //응용연습문제) 사원테이블에 적용하기
    //스캐너로 "총"입력하면 총무부가나오게하고싶다.
    
      public List<DeptVO> getDeptList(String dname) throws SQLException{
        
        List<DeptVO> list =new ArrayList<>();
        Connection con=MyConn.getConn();
        //select sname form sawon where sname like '%길%';    =>이름에 길이 포함된사람들출력
        String sql="select deptno,dname,loc from dept where dname like ?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,"%"+dname+"%");
        //select의 경우 검색된 결과값(인스턴스)를 crsor로 반환.
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            DeptVO vo=new DeptVO();
            vo.setDeptno(rs.getInt("deptno"));
            vo.setDname(rs.getString("dname"));
            vo.setLoc(rs.getString("loc"));
            list.add(vo);
        }
        con.close();
        return list;
        }
      public List<Sawon> getSawonList(String dname) throws SQLException{
        
        List<Sawon> list =new ArrayList<>();
        Connection con=MyConn.getConn();
        //select sname form sawon where sname like '%길%';    =>이름에 길이 포함된사람들출력
        String sql="select sabun,sname,deptno,sajob,sapay,sahire,sgender,samgr from sawon where sname like ?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,"%"+dname+"%");
        //select의 경우 검색된 결과값(인스턴스)를 cursor로 반환.
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            Sawon vo=new Sawon();
            vo.setSabun(rs.getInt("sabun"));
            vo.setSname(rs.getString("sname"));
            vo.setDeptno(rs.getInt("deptno"));
            vo.setSajob(rs.getString("sajob"));
            vo.setSapay(rs.getInt("sapay"));
            vo.setSahire(rs.getString("sahire"));
            vo.setSgender(rs.getString("sgender"));
            vo.setSamgr(rs.getInt("samgr"));
            list.add(vo);
        }
        con.close();
        return list;
        }
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        List<Sawon> dlist=JDBCSelectDemo.getJsda().getSawonList(str);
//        List<DeptVO> dlist=JDBCSelectDemo.getJsda().getDeptList(str);
//        for(DeptVO e : dlist){
//            System.out.println("부서 번호:"+e.getDeptno());
//            System.out.println("부서 이름:"+e.getDname());
//            System.out.println("지역:"+e.getLoc());
//        }
        for(Sawon e : dlist){
            System.out.println("사번:"+e.getSabun());
            System.out.println("사원 이름:"+e.getSname());
            System.out.println("부서 번호:"+e.getDeptno());
            System.out.println("직업:"+e.getSajob());
            System.out.println("연봉:"+e.getSapay());
            System.out.println("고용일:"+e.getSahire());
            System.out.println("성별:"+e.getSgender());
            System.out.println("몰라:"+e.getSamgr());
        }
        
    }
}

//싱글톤의조건 - 생성자를 private. 외부에서생성하면안됨.
//static에서 new를 해주는데, 어떤 스레드가 오건간에 한번만 생성자를 부르게한다.