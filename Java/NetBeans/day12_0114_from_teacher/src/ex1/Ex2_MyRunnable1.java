package ex1;
/* Ex2_MyRunnable1 */
public class Ex2_MyRunnable1 implements Runnable{
    // Thread�� ������ Ŭ�����̱� ������ �߻�޼����� run()��
    // ������ �ִ�. ���� getName() �� ����Ϸ��� 
    // ���� �������� �ּҸ� �����ͼ� �Ʒ�ó�� ����Ѵ�.
    @Override
    public void run() {
        // ������ ���ÿ��� run()ȣ��� �������� �ּҰ�
        System.out.println("@---@"+Thread.currentThread().getName());
    }

}
