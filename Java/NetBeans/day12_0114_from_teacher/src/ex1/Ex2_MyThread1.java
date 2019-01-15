package ex1;
/* Ex2_MyThread1 */
//스레드를 사용하는 방법 1. 상속
public class Ex2_MyThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("^---^"+getName());
    }
    
}
