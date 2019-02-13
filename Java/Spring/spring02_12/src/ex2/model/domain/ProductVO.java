package ex2.model.domain;

public class ProductVO {

	private String name;
	private int price;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("Product[name=");
		sb.append(name).append(",price=");
		sb.append(price).append("]");
		return sb.toString();
	}
	
}
