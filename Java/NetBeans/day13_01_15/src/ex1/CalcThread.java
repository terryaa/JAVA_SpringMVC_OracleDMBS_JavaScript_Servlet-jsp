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
public class CalcThread  extends Thread{

    public CalcThread(String name){
        setName(name);
    }
    
    @Override
    public void run() {
       for(int i=0;i<20000000;i++){
           
       }
        System.out.println(getName()+":"+this.getPriority());
    }
    
    
}
