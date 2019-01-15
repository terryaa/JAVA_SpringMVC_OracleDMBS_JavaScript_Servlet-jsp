/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author younghoonkim
 */
public class PriorityExample {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            //priority is 1~10
            Thread thread=new CalcThread("thread"+i);
            if(i!=10){
                thread.setPriority(Thread.MIN_PRIORITY);
                
            }else {
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            thread.start();
        }
    }
    
}
