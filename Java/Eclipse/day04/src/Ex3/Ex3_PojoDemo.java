package Ex3;
///1. 순수한 값만을 가진ㄴ 객체
//분석->설계(만들어지거나, 제작)
//2. 데이터 베이스 설계로 엔티티로 바로 제작가능
//자동으로 만들지만, 항상 손이 간다
public class Ex3_PojoDemo {
//회원의 정보를 저장
	//멤버필드, 지역변수 => 반드시 소문자로 작성해ㅅ...규칙연습
	private int num;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	int age;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isAgree() {
		return agree;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	public int getGetnum() {
		return getnum;
	}
	public void setGetnum(int getnum) {
		this.getnum = getnum;
	}
	private String name,id;

	private boolean agree;
	//setter, gatter로 메서드를 제한다
	private int getnum;//alt + shift + s

	
}
