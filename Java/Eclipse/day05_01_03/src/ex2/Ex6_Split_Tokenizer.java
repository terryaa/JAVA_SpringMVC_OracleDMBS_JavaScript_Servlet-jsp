package ex2;

import java.util.StringTokenizer;

public class Ex6_Split_Tokenizer {

	public static void main(String[] args) {
		//StringTokenizer�� �ǹ̾��� whitespace�� ��ū���� ��������ʴ´�
		//split�� whitespace�� �ǹ��ִ� ��ū�������
		String str="��浿�ڱ��϶�ڱ�������������ڡڼ���";
		StringTokenizer stz=new StringTokenizer(str,"��");
		while(stz.hasMoreTokens()) {
			System.out.println(stz.nextToken());
		}
		System.out.println("_____________");
		String[] arr=str.split("��");
		System.out.println("�迭�Ǳ��� :"+arr.length);
		for(String e:arr) {
			System.out.println(e);
		}
	}
}
