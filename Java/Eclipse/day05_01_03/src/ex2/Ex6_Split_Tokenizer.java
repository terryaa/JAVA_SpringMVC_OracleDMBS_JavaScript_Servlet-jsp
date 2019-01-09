package ex2;

import java.util.StringTokenizer;

public class Ex6_Split_Tokenizer {

	public static void main(String[] args) {
		//StringTokenizer는 의미없는 whitespace를 토큰으로 취급하지않는다
		//split은 whitespace로 의미있는 토큰으로취급
		String str="김길동★구하라★김수현★전지현★★수지";
		StringTokenizer stz=new StringTokenizer(str,"★");
		while(stz.hasMoreTokens()) {
			System.out.println(stz.nextToken());
		}
		System.out.println("_____________");
		String[] arr=str.split("★");
		System.out.println("배열의길이 :"+arr.length);
		for(String e:arr) {
			System.out.println(e);
		}
	}
}
