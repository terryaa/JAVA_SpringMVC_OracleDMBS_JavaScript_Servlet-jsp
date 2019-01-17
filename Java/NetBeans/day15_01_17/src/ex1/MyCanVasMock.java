/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author younghoonkim
 */
public class MyCanVasMock extends JFrame {
    
    private int arcNum=360;
    private int x=100,y=100;
    private int r=50;
            
    private Color col=Color.CYAN;
    
    public MyCanVasMock(){
        Canvas can=new Canvas(){

            @Override
            public void update(Graphics g) {
                paint(g);
                //super.update(g); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void paint(Graphics g) {
                g.setColor(col);
                g.fillOval(x, y, r, r);
                //super.paint(g); //To change body of generated methods, choose Tools | Templates.
            }
            
    };
    
        add(can);
        can.setBackground(Color.yellow);
        setBounds(100,100,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyCanVasMock();
    }
    
    
    
}
