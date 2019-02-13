package life;

public class LifeCycleImple implements LifeCycleInter {

	private String mytype;
	
	public String getMytype() {
		return mytype;
	}

	public void setMytype(String mytype) {
		this.mytype = mytype;
	}
	public LifeCycleImple() {
		System.out.println("생성자 호출!");
	}

	@Override
	public void init() {
		System.out.println("init 호출!");
		
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy 호출!");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		System.out.println("execute 호출!");
		
	}
	

}
