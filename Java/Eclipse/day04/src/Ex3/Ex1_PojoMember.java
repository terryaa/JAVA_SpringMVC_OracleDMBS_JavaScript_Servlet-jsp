package Ex3;

public class Ex1_PojoMember {

//1. ȸ���� ������ ����ϴ� Ŭ���� ����� ����
//��ü�� �⺻���� null -> new�� ���� �ȵ� �ּ�
	private Ex3_PojoDemo ep; ///100��
	
	
	public void setMember(Ex3_PojoDemo ep) {
		///������ ���̰��� �Ǻ��ؼ� �������� �̼������� �����ϰ�
		//�̼����̸� �����͸� �Է����� ���ϵ��� �����غ��ô�.
		if(ep.getAge() <= 19) {
			System.out.println("�̼����ڴ� ���� �Ұ�");
			
		}else {
			this.ep = ep;
	
		}
			}
	
	//3. ep(ȸ��)�� ���� ����ϴ� �޼���
	public void printMember() {
		if(ep != null) {
			System.out.println("ȸ���� ��ȣ:" + ep.getNum());
			System.out.println("�̸�:" + ep.getName());
			System.out.println("���̵�:" + ep.getId());
			if(ep.isAgree() == true) {
				System.out.println("���� �����߽��ϴ�.");
			}
			else {
				System.out.println("���� �̵����߽��ϴ�.");
			}
		}
		}

}
