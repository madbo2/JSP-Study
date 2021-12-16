package student.studentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.StudentDTO.StudentDTO;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##jsp";
		String password = "oracle";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insert(StudentDTO dto) {
		boolean check = false;
		
		String sql = "insert into student values(?,?,?)";
		
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getvalue());
			ps.setInt(3, dto.getCode());
			if(ps.executeUpdate() != 0 ) {
				check = true;
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(con !=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	public void select(StudentDTO dto,int choose) {
		
		String sql = sqlSelect(choose);
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(choose ==1) ps.setString(1, dto.getName());
			else if (choose ==2) ps.setInt(1, dto.getCode());
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				
				System.out.println(name+"\t"+value+"\t"+code+"\t");
			}
			
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
			
		
	}
	private String sqlSelect(int choose) {
		String sql = null;
		if(choose == 1) {
			sql = "select * from Student where name like '%?%'";
			
		} else if (choose == 2) {
			sql = "select * from Student where code = ?";
			
		} else {
			sql = "select * from Student";
		}
		return sql;
	}
	
	public boolean delete(StudentDTO dto) {
		boolean check = false;
		
		String sql = "delete from Student where name=?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			if(ps.executeUpdate() != 0 ) {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
				if(con !=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
}
