/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Interface.ServerMessageCreateInter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author KOSTA
 */
public class ServerJoinMessageCreate implements ServerMessageCreateInter {
    
    private final String path="C:\\bigdata\\KOSTA_MAC\\Java\\NetBeans\\Semi_Project\\src\\Data\\";

    @Override
    public String createMessage(String msg, JSONObject members) {
        StringTokenizer st=new StringTokenizer(msg,"^");
        st.nextToken();
        String str=st.nextToken();
        System.out.println(str);
        st=new StringTokenizer(str,":");
         JSONObject memberInfo=new JSONObject();
        memberInfo.put("Name", st.nextToken());        //입력한 값을 JSon에 저장
        System.out.println(memberInfo.get("Name"));
        memberInfo.put("ID",st.nextToken());            //입력한 값을 JSon에 저장
        System.out.println(memberInfo.get("ID"));
        memberInfo.put("password", st.nextToken());//입력한 값을 JSon에 
        System.out.println(memberInfo.get("password"));
        String cell=st.nextToken();
        st=new StringTokenizer(cell,"-");
        memberInfo.put("Cell1", st.nextToken()); //입력한 값을 JSon에 저장
        memberInfo.put("Cell2", st.nextToken()); //입력한 값을 JSon에 저장
        memberInfo.put("Cell3", st.nextToken()); //입력한 값을 JSon에 저장

        members.put(memberInfo.get("ID"),memberInfo);
        FileWriter fw;
        String message=null;
        try {
            fw = new FileWriter(path+"member.json");
            fw.write(members.toJSONString());
            fw.flush();
            fw.close();
            message="join^true:";
        } catch (IOException ex) {
            Logger.getLogger(ServerJoinMessageCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
