package ex2.model.service;

import ex2.model.domain.ProductVO;

public class ProductServiceImple implements ProductService{
	
	private ProductDAO productdao;
	
	@Override
	public ProductVO getProduct() {
		return productdao.getProduct();
	}
	public ProductDAO getProductDAO() {
		return productdao;
	}
	public void setProductDao(ProductDAO productdao) {
		this.productdao=productdao;
	}

}
