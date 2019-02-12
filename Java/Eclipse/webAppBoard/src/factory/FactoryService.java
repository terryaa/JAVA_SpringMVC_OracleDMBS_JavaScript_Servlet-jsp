package factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sql seesion��ü�� ����� ��ȯ���ִ� Ŭ����

public class FactoryService {
	private static SqlSessionFactory factory;
	static {
		try {
			//1.mybatis�� ȯ�漳�� ������ �о�´�.
			Reader reader=Resources.getResourceAsReader("configg/config.xml");
			factory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
