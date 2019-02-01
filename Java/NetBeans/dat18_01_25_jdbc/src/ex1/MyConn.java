/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class MyConn {
   //초기자원 : 스태틱자원의 초기화 : 메인메서드보다 먼저실행됨 
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConn() throws SQLException{
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="bigdate";
        String pwd="big";
        return DriverManager.getConnection(url, user, pwd);
        
    }
}

