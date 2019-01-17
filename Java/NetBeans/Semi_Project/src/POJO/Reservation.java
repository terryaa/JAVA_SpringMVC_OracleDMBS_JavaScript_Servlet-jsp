/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Calendar;

/**
 *
 * @author younghoonkim
 */
public class Reservation extends Member{
    Calendar calender;
    String program;

    public Calendar getCalender() {
        return calender;
    }

    public void setCalender(Calendar calender) {
        this.calender = calender;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    
}
