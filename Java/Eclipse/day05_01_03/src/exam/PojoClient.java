package exam;


public class PojoClient {
	
	private PojoMember ep;
	//2.Ex3_PojoClient의 객체를 생성한후
	//현재 클래스의 멤버에 저장하는 메서드를 정의
	public PojoClient(PojoMember ep) {
		//미성년이면 데이터를 입력하지못하도록 구현
		if(ep.getAge()>19)
		{
			this.ep=ep;
		}
		else
			System.out.println("미성년자는 입력이 안됩니다!");
	}
	public void printMember() {
		if(ep!=null) {
			System.out.println("회원의번호:"+ep.getNum());
			System.out.println("이름:"+ep.getName());
			System.out.println("아이디:"+ep.getId());
			if(ep.isAgree()==true) {
				System.out.println("수신 동의 했습니다.");
			}
			else {
				System.out.println("수신 미동의했습니다.");
			}
		}
	}
	
}
