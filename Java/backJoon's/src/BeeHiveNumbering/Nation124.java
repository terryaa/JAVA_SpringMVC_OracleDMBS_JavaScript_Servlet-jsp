/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeeHiveNumbering;

/**
 *
 * @author younghoonkim
 */
public class Nation124 {
    public static void main(String[] args) {
        int n=10;
        int remain_12=(int)Math.ceil((double)(n%12)/3);
        int num=n%3;
        if(num==0)
            num+=4;
        num+=(remain_12-1)*10;
        if(remain_12==4)
            num+=10;
        //num+=(num/12)
      String answer = String.valueOf(num);
        System.out.println(answer);
    }
    
            
    
    
}
