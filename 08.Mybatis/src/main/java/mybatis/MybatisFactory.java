package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSessionFactory factory;
	
	
	
	
	
	//1. static 싱글톤
	// static 초기화식
//	static {
//		String resource = "mybatis/config.xml";
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			factory = new SqlSessionFactoryBuilder().build(inputStream);
//			
//		} catch (IOException e) {
//		}
//	}
//	
//		public static SqlSessionFactory getInsteance() {
//			return factory;
//		}
	
	
	//2. 싱글톤 패턴
	public static SqlSessionFactory getInstance() {
		if(factory  == null) {
		String resource = "mybatis/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
		}
		}
		return factory;
	}
	
	
	
	
}
