package aop.ex1;

public class DaoImple implements DaoInter{

	@Override
	public void first() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i+" ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("End!");
	}

	@Override
	public String second() {
		StringBuilder sb=new StringBuilder();
		sb.append("----------").append("\n");
		sb.append("김길동").append("\n");
		return sb.toString();
	}

	@Override
	public void third() {
		String[] ar= {"메세지1","메세지2","메세지3","메세지4","메세지5"};
		for(int i=0;i<=ar.length;i++) {
			System.out.println("비즈니스 로직의 "+ar[i]);
		}
		
	}

}
