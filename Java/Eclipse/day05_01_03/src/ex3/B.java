package ex3;

public class B {

	int bb=2;
	A aRef;
	public B() {
		aRef=new A();
	}
	public int getBb() {
		return bb;
	}
	public void setBb(int bb) {
		this.bb = bb;
	}
	public A getaRef() {
		return aRef;
	}
	public void setaRef(A aRef) {
		this.aRef = aRef;
	}
}
