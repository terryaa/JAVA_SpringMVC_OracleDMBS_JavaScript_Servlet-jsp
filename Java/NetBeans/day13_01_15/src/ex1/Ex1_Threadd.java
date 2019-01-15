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
public class Ex1_Threadd implements Runnable {
    private int value;
    @Override
    public void run(){
        int i=0;
        String name=Thread.currentThread().getName();
        while(i<3){
            System.out.println(name+",local variable :"+(++i));
            System.out.println(name+",field value's value :"+(++value));
            System.out.println("Thread Active Cnt"+Thread.activeCount());
        }
    }
    public static void main(String[] args) {
        Ex1_Threadd r=new Ex1_Threadd();
        new Thread(r).start();
        new Thread(r).start();
    }
    
    
}
