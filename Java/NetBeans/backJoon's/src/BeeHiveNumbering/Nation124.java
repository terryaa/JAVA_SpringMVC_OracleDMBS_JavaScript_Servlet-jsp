/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeeHiveNumbering;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author younghoonkim
 */
public class Nation124 {
    public static void main(String[] args) {
        int num=21;
        double result=0;
        for(int j=0;num>0;j++)
        {
            double temp=(((int) (((num-1)%(Math.pow(3,j+1)) )/(Math.pow(3,j))) +1)*Math.pow(10,j));
     
            if(temp==3*Math.pow(10, j))
                result+=Math.pow(10,j)+temp;
            else
                result+=temp;
            
            num-=Math.pow(3,j+1);
        }
        System.out.println(result);
        Date dt=new Date();
       	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	String date = sdf.format(new Date()); 
	System.out.println(date); //15/10/2013

        
    }      
    private int generateNum(int num){
        
        return 0;
    }
    
    
}
