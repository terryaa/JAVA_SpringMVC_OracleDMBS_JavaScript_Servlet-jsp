package kr.or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.dto.customerVO;

@Repository
public class CustomerDao {
	@Autowired
	private SqlSessionTemplate ss;//context에서 만들어둔 마이바티스 설정에서 불러옴
	public void addCustomer(customerVO vo) {
		ss.insert("customer.customerAdd",vo);
	}
}
