/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KOSTA
 */
public class SelectPhoneNum {
    private static SelectPhoneNum spn=null;
    public static synchronized SelectPhoneNum getSpn(){
        if(spn==null){
            spn=new SelectPhoneNum();
        }
        return spn;
    }
    private SelectPhoneNum(){};
    
     public List<MemphoneVO> getDeptList(String dname) throws SQLException{
         List<MemphoneVO> list=new ArrayList<>();
        //select sname form sawon where sname like '%길%';    =>이름에 길이 포함된사람들출력
        //select의 경우 검색된 결과값(인스턴스)를 crsor로 반환.
         List<MemphoneVO> resultList=new ArrayList<>();
        
        Connection con=MyConn.getConn();
        String sql="select num,name,pnum,substr(pnum,1,instr(pnum,')',1,1)-1) AS front from memphone";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            MemphoneVO mv=new MemphoneVO();
            mv.setNum(rs.getInt("num"));
            mv.setName(rs.getString("name"));
            mv.setPhone(rs.getString("pnum"));
            mv.setFront(rs.getString("front"));
            list.add(mv);
        }
        if(dname.equals("선택")){
             con.close();
            return list;
        }
        else
        {
            for(MemphoneVO e : list){
                if(dname.equals(e.getFront())){
                    resultList.add(e);
                    
                }
            }
        }
        con.close();
        return resultList;
       
      
     }
}
