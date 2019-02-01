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
        String sql="select deptno,dname,loc from dept where dname like ?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,"%"+dname+"%");
        //select�� ��� �˻��� �����(�ν��Ͻ�)�� crsor�� ��ȯ.
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
        //select sname form sawon where sname like '%��%';    =>�̸��� ���� ���ԵȻ�������
        String sql="select sabun,sname,deptno,sajob,sapay,sahire,sgender,samgr from sawon where sname like ?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,"%"+dname+"%");
        //select�� ��� �˻��� �����(�ν��Ͻ�)�� cursor�� ��ȯ.
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
//            System.out.println("�μ� ��ȣ:"+e.getDeptno());
//            System.out.println("�μ� �̸�:"+e.getDname());
//            System.out.println("����:"+e.getLoc());
//        }
        for(Sawon e : dlist){
            System.out.println("���:"+e.getSabun());
            System.out.println("��� �̸�:"+e.getSname());
            System.out.println("�μ� ��ȣ:"+e.getDeptno());
            System.out.println("����:"+e.getSajob());
            System.out.println("����:"+e.getSapay());
            System.out.println("�����:"+e.getSahire());
            System.out.println("����:"+e.getSgender());
            System.out.println("����:"+e.getSamgr());
        }
        
    }
}

//�̱��������� - �����ڸ� private. �ܺο��������ϸ�ȵ�.
//static���� new�� ���ִµ�, � �����尡 ���ǰ��� �ѹ��� �����ڸ� �θ����Ѵ�.