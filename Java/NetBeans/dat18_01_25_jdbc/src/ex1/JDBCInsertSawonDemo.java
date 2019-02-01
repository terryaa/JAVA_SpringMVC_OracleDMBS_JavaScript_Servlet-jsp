/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class JDBCInsertSawonDemo {
    public static void main(String[] args) {
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
         java.util.Date utilDate;
        
        
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con=MyConnSawon.getConn();
             utilDate = sdf.parse("2019/01/25");
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             String sql="insert into sawon values(?,?,?,?,?,?,?,?)";
             pstmt=con.prepareStatement(sql);
             pstmt.setInt(1, 48);
             pstmt.setString(2, "헤헤");
             pstmt.setInt(3, 10);
             pstmt.setString(4, "히히");
             pstmt.setInt(5, 5000);
             pstmt.setDate(6,sqlDate);
             pstmt.setString(7, "남자");
             pstmt.setInt(8,1);
             int res = pstmt.executeUpdate();
            System.out.println("Res" + res);
            System.out.println("Connection:"+con);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCInsertSawonDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JDBCInsertSawonDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
