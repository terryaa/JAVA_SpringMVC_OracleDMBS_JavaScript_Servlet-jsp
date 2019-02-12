/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 *
 * @author younghoonkim
 */


//Date 가져오는법.
//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//	String date = sdf.format(new Date()); 
//	System.out.println(date); //15/10/2013
public class Reservation implements Serializable{
    String id;
    String name;
    String date;
    String program;
    String memo;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
