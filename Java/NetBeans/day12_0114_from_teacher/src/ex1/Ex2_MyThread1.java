package ex1;
/* Ex2_MyThread1 */
//�����带 ����ϴ� ��� 1. ���
public class Ex2_MyThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("^---^"+getName());
    }
    
}
