/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package day23_01_29;


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
        String sql="select s.sname sname ,s.deptno deptno ,d.dname dname,s.sapay sapay from sawon s, dept d" + 
                " where s.deptno=d.deptno ";
        PreparedStatement pstmt=con.prepareStatement(sql);
        //pstmt.setString(1,"%"+dname+"%");
        //select의 경우 검색된 결과값(인스턴스)를 crsor로 반환.
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            DeptVO vo=new DeptVO();
            Sawon sawon=new Sawon();
            sawon.setSname(rs.getString("sname"));
            sawon.setSapay(rs.getInt("sapay"));
            vo.setSawon(sawon);
            vo.setDeptno(rs.getInt("deptno"));
            vo.setDname(rs.getString("dname"));
            //vo.setLoc(rs.getString("loc"));
            list.add(vo);
        }
        con.close();
        return list;
     }
        
      
      public static void main(String[] args) throws SQLException {
          List<DeptVO> list=JDBCSelectDemo.getJsda().getDeptList("test");
          for(DeptVO e : list){
              System.out.println("부서번호: " +e.getDeptno());
              System.out.println("부서이름: " +e.getDname());
              System.out.println("사원이름: "+ e.getSawon().getSname());
              System.out.println("급여: "+ e.getSawon().getSapay());
              System.out.println("------------------------");
          }
          System.out.println("총:" +list.size());
        
    }
   
}

//싱글톤의조건 - 생성자를 private. 외부에서생성하면안됨.
//static에서 new를 해주는데, 어떤 스레드가 오건간에 한번만 생성자를 부르게한다.