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
public class MyThread0 implements Runnable {
 private Ex3_Canvas1 myCan;
    //생성자 호출시 캔버스를 가지고 있는 객체의 주소값을 초기화
 
    public MyThread0(Ex3_Canvas1 myCan) {
        this.myCan = myCan;
    }
     
    @Override
    public void run() {
        //여기에서 스레드 핸들링 작업(원을 그리기 위한..)
        int temN;
        while (myCan.getArcNum() <= 360) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
           temN = myCan.getArcNum();
            temN = temN + 30;
            myCan.setArcNum(temN);
            myCan.getCan().repaint();//스레드에게 캔버스의 그림을 그리도록 repaint를 호출한다.
        }
        int x = myCan.getX();
        x += 100;
        myCan.setX(x);
        temN =0;
        myCan.setArcNum(temN);
    }
}