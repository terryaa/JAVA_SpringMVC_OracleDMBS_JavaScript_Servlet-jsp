/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package day22_01_31;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KOSTA
 */
public class SawonMain {
    //����(����, �����(loc)
    public static void main(String[] args) throws SQLException {
        SawonDao dao=SawonDao.getDao();
       
        Sawon vo=new Sawon();
        vo.setDeptno(10);
        vo.setSname("���ι�");
        vo.setSgender("����");
        vo.setSapay(3000);
        vo.setSajob("�븮");
        dao.insertSawon(vo);
        
         List<Sawon> list=dao.getDao().sawonSearch(10);
        for(Sawon e : list){
            System.out.println("��ȣ" +e.getSabun());
            System.out.println("�̸�"+ e.getSname());
            System.out.println("===================");
        }
        while(true){
            
        }
    }
}
