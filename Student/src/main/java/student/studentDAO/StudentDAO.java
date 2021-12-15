package student.studentDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import student.studentDTO.StudentDTO;

public class StudentDAO {
	
	Scanner sc = new Scanner(System.in);
	int code;
	String name;
	String value;
	
	
	public StudentDAO() {
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
	
	public void insertArticle(StudentDTO dto) {
			
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into Student values(?,?,?)";
		int su = 0;
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getvalue());
			ps.setInt(3, dto.getCode());
			
			su = ps.executeUpdate();
			
			if(su != 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void selectArticle(StudentDTO dto, int choose) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql1 = "select * from Student where name like '%?%'";
		String sql2 = "select * from Student where code = ?";
		String sql3 = "select * from Student";
		
		if(choose ==1) {
			try {
				con = this.getConnection();
				ps = con.prepareStatement(sql1);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					String name = rs.getString("name"); //columindex
					String value = rs.getString("Value");
					int code = rs.getInt("code");
		
			
					System.out.println(name+"\t"+value+"\t"+code+"\t");
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
			
		} else if(choose ==2) {
			try {
				con = this.getConnection();
				ps = con.prepareStatement(sql2);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					String name = rs.getString("name"); //columindex
					String value = rs.getString("Value");
					int code = rs.getInt("code");
		
			
					System.out.println(name+"\t"+value+"\t"+code+"\t");
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
		} else if(choose ==3) {
			try {
				con = this.getConnection();
				ps = con.prepareStatement(sql3);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					String name = rs.getString("name"); //columindex
					String value = rs.getString("Value");
					int code = rs.getInt("code");
		
			
					System.out.println(name+"\t"+value+"\t"+code+"\t");
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
		} else {
		}
	}
		
		
	public void deleteArticle(StudentDTO dto) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from Student where name=?";
		int su = 0;
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			
			su = ps.executeUpdate();
			if(su != 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch(SQLException e) {
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
