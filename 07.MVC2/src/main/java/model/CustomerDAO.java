package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//CRUD: Create, Read, Update, Delete
	//신규고객 등록
	public int registerCustomer(CustomerDTO dto) {
		conn();
		int dml = 0;
		String sql = "insert into customer(name, gender, email, phone) "
				+ "values (?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getGender());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPhone());			
			dml = ps.executeUpdate(); //ctrl+enter
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dml;
	}
	
	//고객목록 조회
	
		public ArrayList<CustomerDTO> getListOfcustomer(){
			//DB연결 -> DB table에서 목록조회
			//: return타입 - ArrayList<DTO> : select
			conn();
			
			ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>();
			String sql = "select * from customer";
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery(); 
				//select: executeQuery,
				//insert/update/delete: executeUpdate
				while( rs.next() ) {
					CustomerDTO dto = new CustomerDTO();
					dto.setEmail(rs.getString("email"));
					dto.setGender(rs.getString("gender"));
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setPhone(rs.getString("phone"));
					list.add(dto);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				disconn();
			}
			return list;
		}
	
	//고객정보 한 건 조회
		public CustomerDTO getOneCustomer(int id) {
			conn();
			
			CustomerDTO dto = null;
			String sql = "select * from customer where id = ? ";
			try {
				ps = conn.prepareCall(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					 dto = new CustomerDTO();
					 dto.setEmail(rs.getString("email"));
					 dto.setGender(rs.getString("gender"));
					 dto.setId(rs.getInt("id"));
					 dto.setName(rs.getString("name"));
					 dto.setPhone(rs.getString("phone"));
				}
			
			} catch (SQLException e) {
			} finally {
				disconn();
			}
			
			return dto;
		}
		
	//고객정보 수정저장
		public void updateCustomer(CustomerDTO dto) {
			conn();
			
			String sql
			= "update customer "
					+ "set name = ?, gender = ?, email = ?, phone = ? "
					+ "where id = ? ";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getGender());
				ps.setString(3, dto.getEmail());
				ps.setString(4, dto.getPhone());
				ps.setInt(5, dto.getId());
				ps.executeUpdate();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				disconn();
			}
			
			
		}
	//고객정보 삭제
	public void deleteCustomer(int id) {
		conn();
		String sql = "delete from customer where id = ? ";
		
		try {
			ps = conn.prepareStatement(sql); //db연결
			ps.setInt(1, id); //준비된 쿼리문에 ?가 있다면 ?에 값을 담기
			ps.executeUpdate(); // developer에서의 ctrl + enter
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			disconn();
		}
		
		
		
	}
	
	
	//자원회수 - DB연결개체 반납
	private void disconn() {
		if(rs != null) {
			try{rs.close();}catch(Exception e) {}
		}
		if(ps != null) {
			try{ps.close();}catch(Exception e) {}
		}
		if(conn != null) {
			try{conn.close();}catch(Exception e) {}
		}
		
	}
	
	//DB연결
	private void conn() {
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource)context.lookup("java:comp/env/hr");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}










