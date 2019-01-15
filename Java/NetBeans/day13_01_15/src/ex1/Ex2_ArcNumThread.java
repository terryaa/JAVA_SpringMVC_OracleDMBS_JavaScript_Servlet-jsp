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
public class Ex2_ArcNumThread implements Runnable {

    @Override
    public void run() {
        int arcNum=0;
        while(arcNum<360){
            arcNum+=10;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        
    }
    
}
