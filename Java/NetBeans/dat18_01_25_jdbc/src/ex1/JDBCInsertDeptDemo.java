/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//1.JDBC드라이버연결
//2. Connection 획득
//3. PreparedStatement 값을 바인딩한다.
//4. PreparedStatement 객체를 사용해서 Query전소
//5. 모든 connection을 반납한다.
/**
 *
 * @author KOSTA
 */
public class JDBCInsertDeptDemo {

    /**
     * @param args the command line arguments
//     */
    public static void main(String[] args) {
        Connection con=null;//커넥션을 반납하기위해서 선언
        PreparedStatement pstmt=null;
        try {
            // TODO code application logic here
            //1. JDBC 드라이버 연결 - 클래스 로딩
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            //2.Connection 획득 - 긴으에 따라서 객체화 시킴(newinstance()가 캡슐화(객체화))
//            String url="jdbc:oracle:thin:@localhost:1521:xe";
//            String user="bigdate";
//            String pwd="big";
            con=MyConn.getConn();
            System.out.println("Connection222222:"+con);
            //3. PreparedStatement 값을 바인딩(?)한다.
            String sql="insert into dept values(?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, 40);
            pstmt.setString(2, "각무부");
            pstmt.setString(3, "서울");
            //4. PreparedStatment객체를 사용해서 쿼리 전송
            int res = pstmt.executeUpdate();
            System.out.println("Res" + res);
            System.out.println("Connection:"+con);
        } 
//        catch (ClassNotFoundException ex) {
//            Logger.getLogger(JDBCInsertDeptDemo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        catch (SQLException ex) {
            Logger.getLogger(JDBCInsertDeptDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DB에러. 꼭확인해야합니다. 에러가 디비인지 자바인지.");
                
        }finally{
            if(con!=null)
                try {
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCInsertDeptDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

