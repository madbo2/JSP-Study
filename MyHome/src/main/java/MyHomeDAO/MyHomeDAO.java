package MyHomeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import MyHomeDTO.MyHomeDTO;

public class MyHomeDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//SingleTon Pattern
	private static MyHomeDAO instance;
	private MyHomeDAO() {
		
	}
	public static MyHomeDAO getInstance() {
		if(instance == null) {
			instance = new MyHomeDAO();
		}
		return instance;
	}
	
	//Connection Pool 설정 ( Tomcat Server 제공 사용 )
	private static DataSource ds;
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public String checkLogin(MyHomeDTO dto) {
		String name = null;
		
		String sql = "select name from member where id = ? and password = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return name;
	}
}
