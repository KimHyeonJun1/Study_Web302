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
	// Arduino ===============================================================================
		// 자료 추가
		public boolean Arduino_Save(String v01, String v02, String v03, String v04) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			// 현재 날짜 구하기
			Date nowTime = new Date();
			// 포맷 정의
		    SimpleDateFormat nalja_f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 데이터 포맷
			// 포맷 적용
		    //System.out.println(nalja_f.format(nowTime));
		    //System.out.println(v01 + "  " + v02 + "  " + v03 + "  " + v04);

			try {
				con = pool.getConnection();
				sql = "insert arduino01 (f01,f02,f03,f04,f07) values (?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, v01);
				pstmt.setString(2, v02);
				pstmt.setString(3, v03);
				pstmt.setString(4, v04);
				pstmt.setString(5, nalja_f.format(nowTime));
				if (pstmt.executeUpdate() == 1)
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}

			return flag;
		}
	
	
	
	// public boolean Arduino_Save(String v01, String v02, String v03, String v04, String v05) {
		public boolean Arduino_Insert(Arduino1DTO bean) {
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		// 현재 날짜 구하기
		Date nowTime = new Date();
		// 포맷 정의
		SimpleDateFormat nalja_f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 데이터 포맷
		// 포맷 적용
	//	System.out.println(nalja_f.format(nowTime));
	//	System.out.println(v01 + "    " + v02 + "     " + v03 + "    " + v04 + "     " v05 );
		
		try {
			con = pool.getConnection();
			sql = "insert 03_arduino1 (f01,f02,f03,f04, f05,f06,f07) values (?, ?, ?, ?, ? ,? ,?)";
			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, v01);
//			pstmt.setString(2, v02);
//			pstmt.setString(3, v03);
//			pstmt.setString(4, v04);
			pstmt.setString(1, bean.getF01());
			pstmt.setString(2, bean.getF02());
			pstmt.setString(3, bean.getF03());
			pstmt.setString(4, bean.getF04());
			pstmt.setString(5, bean.getF05());
			pstmt.setString(6, bean.getF06());
			pstmt.setString(7, nalja_f.format(nowTime));
			if (pstmt.executeUpdate() == 1)
				flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return flag;
		
	}
		
		
		
		public boolean Arduino_Update1(Arduino1DTO bean) {
			Connection con = null;
			String sql = null;
			PreparedStatement pstmt = null;
			boolean flag = false;
			
			// 현재 날짜 구하기
			Date nowTime = new Date();
			// 포맷 정의
			SimpleDateFormat nalja_f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 데이터 포맷
			// 포맷 적용
		//	System.out.println(nalja_f.format(nowTime));
		//	System.out.println(v01 + "    " + v02 + "     " + v03 + "    " + v04 + "     " v05 );
			
			try {
				con = pool.getConnection();
				sql = "update 03_arduino2 set f02=?, f03=?, f04=?, f05=?, f07=? where f01= 'E0:98:06:13:5D:75' ";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, bean.getF02());
				pstmt.setString(2, bean.getF03());
				pstmt.setString(3, bean.getF04());
				pstmt.setString(4, bean.getF05());
				pstmt.setString(5, nalja_f.format(nowTime));
				int count = pstmt.executeUpdate();
				if (count > 0)
					flag = true;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con, pstmt);
			}
			
			return flag;
			
		}	
		
		// 자료 업테이트2
		public boolean Arduino_Update2(Arduino1DTO bean) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			// 현재 날짜 구하기
			Date nowTime = new Date();
			// 포맷 정의
		    SimpleDateFormat nalja_f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 데이터 포맷
			// 포맷 적용
		    //System.out.println(nalja_f.format(nowTime));

			try {
				con = pool.getConnection();
				// 온도 수정 bean.getF03()
				sql = "update 03_arduino3 set s02=?, s05=?, s06=? where s01 = ? and s03 = '00001' ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getF02());
				pstmt.setString(2, bean.getF03());
				pstmt.setString(3, nalja_f.format(nowTime));
				pstmt.setString(4, bean.getF01());
				int count = pstmt.executeUpdate();
				
				// 습도 수정 bean.getF04()
				sql = "update 03_arduino3 set s02=?, s05=?, s06=? where s01 = ? and s03 = '00002' ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getF02());
				pstmt.setString(2, bean.getF04());
				pstmt.setString(3, nalja_f.format(nowTime));
				pstmt.setString(4, bean.getF01());
				count = pstmt.executeUpdate();

				// 조도 수정 bean.getF05()
				sql = "update 03_arduino3 set s02=?, s05=?, s06=? where s01 = ? and s03 = '00003' ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getF02());
				pstmt.setString(2, bean.getF05());
				pstmt.setString(3, nalja_f.format(nowTime));
				pstmt.setString(4, bean.getF01());
				count = pstmt.executeUpdate();

				if (count > 0)
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		
		// 자료 조회(MAC address) 한 건만 조회 arduino2
		public Arduino1DTO Arduino_Get1(String v01) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Arduino1DTO bean = null;
			try {
				con = pool.getConnection();
				sql = "select * from 03_arduino2 where f01=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, v01);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean = new Arduino1DTO();
					bean.setNumb(rs.getInt("numb"));
					bean.setF05(rs.getString("f05"));
					bean.setF06(rs.getString("f06"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con, pstmt);
			}
			
			return bean;
			
			
			
		}
		
		// 자료 조회 (MAC address) 여러건 조회
		public Vector<Arduino2DTO> Arduino_Get2(String v01) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<Arduino2DTO> vlist = new Vector<Arduino2DTO>();
			
			try {
				con = pool.getConnection();
				sql = "select * from 03_arduino3 where s01=? and s03 in ('00004', '00005') ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, v01);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Arduino2DTO bean = new Arduino2DTO();
					bean.setNumb(rs.getInt("numb"));
					bean.setS01(rs.getString("s01"));
					bean.setS02(rs.getString("s02"));
					bean.setS03(rs.getString("s03"));
					bean.setS04(rs.getString("s04"));
					bean.setS05(rs.getString("s05"));
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
		public Vector<Arduino2DTO> Arduino_Get3(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<Arduino2DTO> vlist = new Vector<Arduino2DTO>();
			try {
				con = pool.getConnection();
				sql = "select * from 03_arduino3 ";//where s01 = 'E0:98:06:13:5D:75' and s03 in ('00004', '00005') ";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Arduino2DTO bean = new Arduino2DTO();
					bean.setNumb(rs.getInt("numb"));
					bean.setS01(rs.getString("s01"));
					bean.setS02(rs.getString("s02"));
					bean.setS03(rs.getString("s03"));
					bean.setS04(rs.getString("s04"));
					bean.setS05(rs.getString("s05"));
					bean.setS06(rs.getString("s06"));
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
					sql = "update 03_arduino3 set s05='OFFOO' where numb=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, recnum);
				} else {
					sql = "update 03_arduino3 set s05='ONOOO' where numb=?";
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












