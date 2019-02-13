package ex2.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ex2.model.domain.ProductVO;
import ex2.model.service.ProductService;

public class ProduceMain {
	public static void main(String[] args) {
		ApplicationContext ctx=
				new GenericXmlApplicationContext
				("ex2/model/service/product.xml");
		ProductService prService=ctx.getBean("productService",
				ProductService.class);
		ProductVO product=prService.getProduct();
		System.out.println(product);
	}
}
