/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import POJO.Reservation;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author KOSTA
 */
public class ReservationList {
    ArrayList<Reservation> list=null;
     Reservation resv=null;
    public ArrayList<Reservation> makeList(String strList){
        Scanner sc=new Scanner(strList);
         StringTokenizer st;
        list=new ArrayList<>();
        while(sc.hasNext()){
            reservationInfo(sc.nextLine());
            list.add(resv);
        }
        return list;
        
    }
    private void reservationInfo(String msg){
        resv=new Reservation();
        StringTokenizer st=new StringTokenizer(msg,":");
        resv.setId(st.nextToken());
        resv.setName(st.nextToken());
        resv.setDate(st.nextToken());
        resv.setProgram(st.nextToken());
        resv.setMemo(st.nextToken());
    }
    
}
