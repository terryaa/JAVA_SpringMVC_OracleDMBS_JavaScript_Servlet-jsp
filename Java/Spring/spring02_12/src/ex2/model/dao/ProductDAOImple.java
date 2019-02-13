package ex2.model.dao;

import ex2.model.domain.ProductVO;
import ex2.model.service.ProductDAO;

public class ProductDAOImple implements ProductDAO {

	private ProductVO product;
    public void setProduct(ProductVO product) {
		this.product = product;
	}
	@Override
	public ProductVO getProduct() {
		return product;
	}

}
