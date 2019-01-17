/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.text.SimpleDateFormat;

/**
 *
 * @author younghoonkim
 */


//Date 가져오는법.
//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//	String date = sdf.format(new Date()); 
//	System.out.println(date); //15/10/2013
public class Reservation extends Member{
    
    SimpleDateFormat sdf;
    String program;

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
    
   

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    
}
