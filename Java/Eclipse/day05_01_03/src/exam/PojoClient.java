package exam;


public class PojoClient {
	
	private PojoMember ep;
	//2.Ex3_PojoClient�� ��ü�� ��������
	//���� Ŭ������ ����� �����ϴ� �޼��带 ����
	public PojoClient(PojoMember ep) {
		//�̼����̸� �����͸� �Է��������ϵ��� ����
		if(ep.getAge()>19)
		{
			this.ep=ep;
		}
		else
			System.out.println("�̼����ڴ� �Է��� �ȵ˴ϴ�!");
	}
	public void printMember() {
		if(ep!=null) {
			System.out.println("ȸ���ǹ�ȣ:"+ep.getNum());
			System.out.println("�̸�:"+ep.getName());
			System.out.println("���̵�:"+ep.getId());
			if(ep.isAgree()==true) {
				System.out.println("���� ���� �߽��ϴ�.");
			}
			else {
				System.out.println("���� �̵����߽��ϴ�.");
			}
		}
	}
	
}
