package ex1;
/* Ex2_Main 
   ������� ������ ����, ���� �Ǵ� ������ ��Ȯ���� �ʴ�.
*/
public class Ex2_Main {
    public static void main(String[] args) {
          Ex2_MyThread1 em = new Ex2_MyThread1();
                  Thread t1 = new Thread(new Ex2_MyRunnable1());
        em.start();
        // ������� �����ֱⰡ �־ �ι� start�� ȣ���� �� ����.
       //  em.start();
        t1.start();
         //���θ޼��忡�� �����ð��� �ֱ� ���ؼ� �ݺ�
        for(int i=0; i<10; i++){
            System.out.print(i+"\t");
        }
        
    }
}
