package Ex1;

public class Ex4_SwitchLabel {
	public static void main(String[] args) {
		
		loopout : for (int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						//���� for��ó�� �ٱ��� for������ Ż���ϰ� ���� ��
						//���� ���� ���� �ٿ��� break���� ǥ�ø� �� �θ� �ȴ�.
						//jdk 5���� ����.
						if(j==3) {
							break loopout;
						}
						System.out.println(j + "," + i);
					}
		}
	}
}
