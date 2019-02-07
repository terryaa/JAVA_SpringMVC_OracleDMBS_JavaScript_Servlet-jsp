
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class SawonDao {
    private static SawonDao dao=null;
    
    private SawonDao(){}
    
    public static SawonDao getDao(){
        if(dao==null)dao=new SawonDao();
        return dao;
    }
    public List<Sawon> sawonSearch(int deptno) throws SQLException{
        List<Sawon> arlist=new ArrayList<>();
    
        Connection con=MyConn.getConn();
        CallableStatement cs=con.prepareCall("begin p_sawon(?,?); end;");
        cs.setInt(1,deptno);
        cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        cs.execute();
        ResultSet rs=(ResultSet) cs.getObject(2);
        
        while(rs.next()){
            Sawon sawon=new Sawon();
            sawon.setSabun(rs.getInt("sabun"));
            sawon.setSname(rs.getString("sname"));
            sawon.setSapay(rs.getInt("sapay"));
            
            arlist.add(sawon);
        }
        con.close();
        return arlist;
    }
//    public static void main(String[] args) throws SQLException {
//        SawonDao dao=SawonDao.getDao();
//        List<Sawon> list=dao.getDao().sawonSearch(10);
//        for(Sawon e : list){
//            System.out.println("번호" +e.getSabun());
//            System.out.println("이름"+ e.getSname());
//            System.out.println("===================");
//        }
//        
//    }
    
    public void insertSawon(Sawon v) {
        CallableStatement cs=null;
        Connection con=null;
        try {
            con=MyConn.getConn();
            cs=con.prepareCall("begin ps_in(?,?,?,?,?); end;");
            cs.setString(1,v.getSname());
            cs.setInt(2,v.getDeptno());
            cs.setString(3,v.getSajob());
            cs.setInt(4, v.getSapay());
            cs.setString(5,"남성");
            cs.execute();
            System.out.println("insert success");
        } catch (SQLException ex) {
            Logger.getLogger(SawonDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try {
                con.close();
                cs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SawonDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
}
