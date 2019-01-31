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
    //순차(절차, 제어역행(loc)
    public static void main(String[] args) throws SQLException {
        SawonDao dao=SawonDao.getDao();
       
        Sawon vo=new Sawon();
        vo.setDeptno(10);
        vo.setSname("새로미");
        vo.setSgender("남자");
        vo.setSapay(3000);
        vo.setSajob("대리");
        dao.insertSawon(vo);
        
         List<Sawon> list=dao.getDao().sawonSearch(10);
        for(Sawon e : list){
            System.out.println("번호" +e.getSabun());
            System.out.println("이름"+ e.getSname());
            System.out.println("===================");
        }
        while(true){
            
        }
    }
}
