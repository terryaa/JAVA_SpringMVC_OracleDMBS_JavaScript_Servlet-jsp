package ex1_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex1_AutoWiredService implements PrintInter{
	//���� �ʹ��������� �������� �� �������°��� �������̶������⶧����
	//�ٸ�������� DTO�� ���� ����.
	//�ڵ����� ���������� ����� �����ִ� ������̼�.
	//byName,byType ���
	//byName�� ������Ƽ�� �̸��� �����ϸ� �ٷ� �ڵ����� ���� �������ش�.
	//byType�� ���� Ÿ���� ������ �˻��ؼ� �ڵ����� ���� �������ش�.
	//�� ���� if / if�������� �Ѵ� �۵��Ѵ�.
	//���� Ÿ�� 2���̻��϶� ���ϴ°��� �������ؼ� Qualifier�� ����Ѵ�.
	//@Autowired
	//@Qualifier("hold")
	//null�� ����մϴ�.
	//@Autowired(required=false)
	@Autowired
	@Qualifier("hold")
	private String name;
	@Override
	public String printName() {
		return "����� �̸���:"+name+"�Դϴ�.";
	}
//	public Ex1_AutoWiredService() {
//		
//	}
//	public Ex1_AutoWiredService(@Qualifier("hold") String name)
//	{	
//		this.name=name;
//	}
}
