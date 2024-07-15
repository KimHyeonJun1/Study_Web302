package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HrDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//사원목록조회
	public ArrayList<EmployeeDTO> listOfEmployee() {
		connect();
		
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
;		String sql = "select * from employees";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();//select
			ps.executeUpdate();//insert,update,delete
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setFirst_name(rs.getString("first_name"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
		} finally {
			disconnect();
		}
		return list;
		
		
	}
	
	
	private void connect() {
		try {
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/hr");
		conn = ds.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void disconnect() {
		if(rs!= null) {
			try{rs.close();}catch(Exception e) {}
			if(ps!= null) {
				try{ps.close();}catch(Exception e) {}
				if(conn!= null) {
					try{conn.close();}catch(Exception e) {}
		}
	}
		}
}
}