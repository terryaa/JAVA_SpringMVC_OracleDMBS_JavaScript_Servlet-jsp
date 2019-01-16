/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Ex2_Canvas implements Runnable {
    private Ex2_CanvasDemo ex;
    Ex2_Canvas(Ex2_CanvasDemo ex){
        this.ex=ex;
    }

    @Override
    public void run() { 
         for(int i=0;i<370;i+=30){
            
            try {
                System.out.println("circle1:"+i);
                Thread.sleep(100);
                //repaint  = update() / paint()
                ex.setArcNUm(i);
                ex.getCanvas1().repaint();
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            catch (InterruptedException ex) {
                Logger.getLogger(Ex2_CanvasDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         ex.setX(ex.getX()+100);
    }
    
    
    
}
