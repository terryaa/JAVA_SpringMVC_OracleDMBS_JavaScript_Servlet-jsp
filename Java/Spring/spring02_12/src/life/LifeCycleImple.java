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
		System.out.println("������ ȣ��!");
	}

	@Override
	public void init() {
		System.out.println("init ȣ��!");
		
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy ȣ��!");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		System.out.println("execute ȣ��!");
		
	}
	

}
