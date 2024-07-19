package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSession sessionHr;
	private static SqlSession sessionHanul;
	
	public static SqlSession getHrInstance() {
		if( sessionHr == null ) {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sessionHr = new SqlSessionFactoryBuilder()
								.build(inputStream, "hr")
								.openSession(true);
	
			} catch (IOException e) {
			}
		}
		return sessionHr;
	}
	public static SqlSession getHanulInstance() {
		if( sessionHanul == null ) {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sessionHanul = new SqlSessionFactoryBuilder()
									.build(inputStream, "hanul" )
									.openSession(true);
				
			} catch (IOException e) {
			}
		}
		return sessionHanul;
	}
}
