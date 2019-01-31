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
//��Ʈ��ũ���� �����ϴ� �������ϰ��
    //connection������ �����ϰ� �ȵɰ��
//�̱���,����ȭ�� ������ �ؾ��Ѵ�
public class JDBCSelectDemo {
    //static ���亹��
    private static JDBCSelectDemo jsda;
    //getJsdd() ȣ��� jdbcselectdemo��
    //��ȯ�ϴ� ����ƽ �޼ҵ�
    public static synchronized JDBCSelectDemo getJsda(){
        //��������� (Ex> t1,t2,t3..) ���� �����ϴ� �����忡��
        //�����ϵ��� �ϰ�, �������� �̹� ������ �ּҸ� �޾Ƽ� ����ϵ����Ѵ�.
        //static������ �����ϴ�
        if(jsda==null){
            jsda=new JDBCSelectDemo();
        }
        
        return jsda;
    }
    
    //�� �����ڴ� �ۿ��������������� �ݵ�� private
    private JDBCSelectDemo(){}
    
    //Dept �� �μ� ���̺��ǰ�
    //�ϳ��� row �� ������ ��ü -> DeptVO
    //��� ������ Collection -> List
    public List<DeptVO> getDeptList() throws SQLException{
        
        List<DeptVO> list =new ArrayList<>();
        Connection con=MyConn.getConn();
        String sql="select deptno,dname,loc from dept";
        PreparedStatement pstmt=con.prepareStatement(sql);
        //select�� ��� �˻�
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
    //���뿬������) ������̺� �����ϱ�
    //��ĳ�ʷ� "��"�Է��ϸ� �ѹ��ΰ��������ϰ�ʹ�.
    
      public List<DeptVO> getDeptList(String dname) throws SQLException{
        
        List<DeptVO> list =new ArrayList<>();
        Connection con=MyConn.getConn();
        //select sname form sawon where sname like '%��%';    =>�̸��� ���� ���ԵȻ�������
        String sql="select s.sname sname ,s.deptno deptno ,d.dname dname,s.sapay sapay from sawon s, dept d" + 
                " where s.deptno=d.deptno ";
        PreparedStatement pstmt=con.prepareStatement(sql);
        //pstmt.setString(1,"%"+dname+"%");
        //select�� ��� �˻��� �����(�ν��Ͻ�)�� crsor�� ��ȯ.
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
              System.out.println("�μ���ȣ: " +e.getDeptno());
              System.out.println("�μ��̸�: " +e.getDname());
              System.out.println("����̸�: "+ e.getSawon().getSname());
              System.out.println("�޿�: "+ e.getSawon().getSapay());
              System.out.println("------------------------");
          }
          System.out.println("��:" +list.size());
        
    }
   
}

//�̱��������� - �����ڸ� private. �ܺο��������ϸ�ȵ�.
//static���� new�� ���ִµ�, � �����尡 ���ǰ��� �ѹ��� �����ڸ� �θ����Ѵ�.