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
public class Ex1_Thread implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<100000;i++){
            System.out.println(i);
        }
        
    }
    
}
