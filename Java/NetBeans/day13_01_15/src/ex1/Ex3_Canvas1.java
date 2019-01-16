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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author kosta
 */
public class Ex3_Canvas1 extends JFrame {

    private Canvas can;
    private int arcNum;
    private int x = 100;
 
    public int getX() {
        return x;
    }
 
    public void setX(int x) {
        this.x = x;
    }
 
    public Canvas getCan() {
        return can;
    }
 
    public int getArcNum() {
        return arcNum;
    }
 
    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }
 
    public Ex3_Canvas1() throws InterruptedException {
        add(can = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.red);
                g.drawArc(x, 100, 100, 100, 0, arcNum);
                 
 
            }
 
            @Override
            public void update(Graphics g) {
                paint(g);
            }
        });
        can.setBackground(Color.white);
        setBounds(100, 100, 800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //MyThread가 해야할 작업이 현재 클래스의 캔버스를 그리는 일이기 때문에
        //this로 현재객체의 주소값을 전달함
        setVisible(true);
        System.out.println("Test");
        Thread t1 = new Thread(new MyThread0(this));
        Thread t2 = new Thread(new MyThread0(this));
        Thread t3 = new Thread(new MyThread0(this));
        Thread t4 = new Thread(new MyThread0(this));
        Thread t5 = new Thread(new MyThread0(this));
         
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        t5.start();
 
    }
 
    public static void main(String[] args) throws InterruptedException {
        new Ex3_Canvas1();
    }

}