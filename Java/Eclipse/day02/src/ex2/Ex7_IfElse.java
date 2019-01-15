package ex2;

public class Ex7_IfElse {
	public static void main(String[] args) {
		
		
		
		/*
		 * 조건에 만족하지 못하면 if문은 실행되지 않는다.
		 * 그러나 else를 정의해 두면 그 외의 조건을 모두 실행시킬 수 있다.
		 * if(조건){실행문1;} 
		 * else{실행문2;}
		 * 
		 */
		
		
		int num = 10;
		int v=0;
		if(num==10){
			//컴파일러가 if문은 수행이 안될 수도 있다고 인지해서 if에만 초기화하면 오류가 남
			//따라서 else에도 초기화 해줘야 함.(디폴트로)
			v = 10;
			System.out.println(num+"월의 꽃");
			
		}
		else {
		//v = 20;
			System.out.println(num + "월의 꽃");
		}
		System.out.println(v + "");
		
		//컴파일오류가 남.
		//초기화를 해서 사용해야 함
		// v = 0; 이런식으로 초기화를 시켜줘야 함
		
		/*
		 * str1과 str2는 객체를 가르키므로 참조 자료형이다.
		 * 따라서 str1과 str2는 주소를 저장하고 있고
		 * new를 통해 각각 생성되었기 때문에 두 주소는 다르다.
		 * 내용을 비교하고 싶다면 equals를 사용해야 한다.
		 * 
		 * 암묵적 객체 생성방법은 같은 상수값일 때,
		 * 상수풀을 공유하기 때문에
		 * str2에서는 더이상 새로운 객체를 생성하지 않고
		 * 이미 생성된 str1이 참조한 주소값을 전달받는다.
		 */
		String str1 = "Test";
		String str2 = "Test";
		
		if(str1 == str2) {
			System.out.println("str1, str2는 주소가 같다.");
			
		}
		else {
			System.out.println("str1, str2는 주소가 다르다.");
		
		}
		
		if(str1.equals(str2)) {
			System.out.println("내용이 같다");}
		else {
				System.out.println("내용이 다르다");
			}
		
		
		
		
		
		///////////////////////////////////////
		String val = "사과";
		String col = "";
		if(val.contentEquals("사과")) {
			col = "Red";
		}
		else if(val.contentEquals("바나나")) {
			col = "Yellow";
		}
		else if(val.contentEquals("오렌지")) {
			col = "Orange";
		}
		else {
			col = "White";
		}
		
		System.out.println(val + "은(는)" +  col + "색 입니다.");
		
		
		
		////////////////////////////////////////////////
		
		int score = 50;
		String grade ="";
		if(score >=50) {
			grade = "고급";
			
		}
		else if(score>= 30) {
			grade = "중급";
		}
		else if (score >= 20) {
			grade = "초급";
			}
		else {
			grade = "없음";
		}
		
		System.out.println("점수: " + score + "\n 등급 : " + grade);
		}
	
	
	///////////////////////////////////////////
		
	}













