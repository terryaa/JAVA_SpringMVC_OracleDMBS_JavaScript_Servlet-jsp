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
public class Ex1_Main {
    public static void main(String[] args) throws InterruptedException {
        Thread th1=new Thread(new Ex1_Thread());
        th1.start();
        th1.join();
        for(int i=0;i<100000;i++){
            System.out.println("main:"+i);
        }
    }
}
