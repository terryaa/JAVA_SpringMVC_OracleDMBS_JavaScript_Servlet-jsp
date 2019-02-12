package factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sql seesion객체를 만들고 반환해주는 클래스

public class FactoryService {
	private static SqlSessionFactory factory;
	static {
		try {
			//1.mybatis의 환경설정 파일을 읽어온다.
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
