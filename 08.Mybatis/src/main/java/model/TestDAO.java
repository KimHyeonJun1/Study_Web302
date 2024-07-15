package model;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class TestDAO {

	private SqlSession sql; //쿼리실행 메소드를 가진 클래스
	
	public CustomerDTO getOneCustomer() {
		CustomerDTO dto = sql.selectOne("test.getCustomer");
		return dto;
	}
	
	
	public String getOneNow() {
		conn();
		String now = sql.selectOne("test.now");
		return now;
		
	}
	
	public Date getOneToday() {
		conn();
		Date today = sql.selectOne("test.today");
		return today;
		
	}
	
		private void conn() {
			
			SqlSessionFactory factory = MybatisFactory.getInstance();	
			sql = factory.openSession(true);
			
//			String resource = "mybatis/config.xml";
//			InputStream inputStream;
//			try {
//				inputStream = Resources.getResourceAsStream(resource);
//				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//				sql = sqlSessionFactory.openSession(true);//dml에 대한 auto commit 지정: true
//			} catch (IOException e) {
//			}
		}
}
