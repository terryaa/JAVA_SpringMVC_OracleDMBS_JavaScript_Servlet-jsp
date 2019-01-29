/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class MyConnSawon {
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnSawon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConn() throws SQLException{
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            String user="bigdate";
            String pwd="big";
            return DriverManager.getConnection(url, user, pwd);
    }
}
