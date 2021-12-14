package dbtest.dbtestdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbtest.dbtestdto.DBTestDTO;

public class DBTestDAO {
	
	public DBTestDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 성동");
		} catch(ClassNotFoundException e ) {
			System.out.println("로딩 실패");
			e.printStackTrace();
		}
		
	}
	
	private Connection getConnection() {
		
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##jsp";
		String password = "oracle";
		
		try {
			con = DriverManager.getConnection(url,user,password);
			System.out.println("연결 성공");
		} catch(SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		return con;
	}
	
	public int insert(DBTestDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into dbtest values(?,?,?,sysdate)";
		
		int su = 0;
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getAge());
			ps.setDouble(3, dto.getHeight());
			
			su = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public int update(DBTestDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update dbtest set age=?, height=? where name=?";
		int su = 0;
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getAge());
			ps.setDouble(2, dto.getHeight());
			ps.setString(3, dto.getName());
			
			su = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public void select() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from dbtest";
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				/*
				String name = rs.getString(1); //columindex
				int age = rs.getInt(2);
				double height = rs.getDouble(3);
				Date logtime = rs.getDate(4);
				*/
				String name = rs.getString("name"); //columindex
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				Date logtime = rs.getDate("logtime");
				
				
				System.out.println(name+"\t"+age+"\t"+height+"\t"+logtime);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}

