package Arduino;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;



public class ArduinoDAO {

	private DBConnection pool;
	
	public ArduinoDAO() {
		
		try {
			pool = DBConnection.getInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

		// 자료 조회(MAC address) 한 건만 조회 arduino2
		public Arduino2DTO Arduino_Get1(String v01) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Arduino2DTO bean = null;
			try {
				con = pool.getConnection();
				sql = "select * from 03_arduino where usma=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, v01);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean = new Arduino2DTO();
					bean.setNumb(rs.getInt("numb"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con, pstmt);
			}
			
			return bean;
			
			
			
		}
		
		// 자료 조회 (MAC address) 여러건 조회
		public Vector<Arduino1DTO> Arduino_Get2(String v01) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<Arduino1DTO> vlist = new Vector<Arduino1DTO>();
			
			try {
				con = pool.getConnection();
				sql = "select * from 03_arduino where usma=? and pin in ('00001', '00002') ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, v01);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Arduino1DTO bean = new Arduino1DTO();
					bean.setNumb(rs.getInt("numb"));
					bean.setS01(rs.getString("usma"));
					bean.setS02(rs.getString("pin"));
					bean.setS03(rs.getString("name"));
					bean.setS04(rs.getString("control"));
					vlist.add(bean);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con, pstmt, rs);
			}
			
			return vlist;
			
		}
		
		// 자료 조회 전체(전체 자료 확인하기 위함)
		public Vector<Arduino1DTO> Arduino_Get3(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<Arduino1DTO> vlist = new Vector<Arduino1DTO>();
			try {
				con = pool.getConnection();
				sql = "select * from 03_arduino where usma = 'E0:98:06:13:5D:75' and pin in ('00001', '00002') ";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Arduino1DTO bean = new Arduino1DTO();
					bean.setNumb(rs.getInt("numb"));
					bean.setS01(rs.getString("usma"));
					bean.setS02(rs.getString("pin"));
					bean.setS03(rs.getString("name"));
					bean.setS04(rs.getString("control"));
					vlist.add(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con, pstmt, rs);
			}
			
			return vlist;
			
			
			
		}
		
		// ON OFF 제어값 변경
		public boolean Arduino_Update_Perm(int recnum, String perm) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				if (perm.equals("ONOOO")) {
					sql = "update 03_arduino set control='OFFOO' where numb=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, recnum);
				} else {
					sql = "update 03_arduino set control='ONOOO' where numb=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, recnum);
				}
				int count = pstmt.executeUpdate();
				if (count > 0)
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
}
}












