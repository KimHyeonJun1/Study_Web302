package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HrDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ArrayList<EmployeeDTO> employeeList() {
		connect();
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		String sql = "select last_name||' '||first_name as name, e.* " 
				+ "from employees e order by hire_date";
		
		try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmployee_id(rs.getInt("employee_id"));
			dto.setName(rs.getString("name"));
			dto.setDepartment_id(rs.getInt("department_id"));
			dto.setJob_id(rs.getString("job_id"));
			dto.setHire_date(rs.getDate("hire_date"));
			list.add(dto);
			
		}
		
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		return list;
	}
	
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "0000");
			
			
		} catch (Exception e) {
			
		}
		}
		
		public void disconnect() {
			if(rs !=null) {
				try{rs.close();}catch(Exception e) {}
			}
			if(ps!=null) {
				try{ps.close();}catch(Exception e) {}
			}
			if(conn!=null) {
				try{conn.close();}catch(Exception e) {}
			}
	}
	}
