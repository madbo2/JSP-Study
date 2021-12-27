package student.studentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// 1��° ������ ����
	public void select(StudentDTO dto,int choose) {
		
		String sql = sqlSelect(choose);
		
		try {
			
			if (choose==1) {
				sql += "'%"+dto.getName()+"%'";
			}
			
			this.getConnection();
			ps = con.prepareStatement(sql);
			
			if (choose ==2) ps.setInt(1, dto.getCode());
			
			rs = ps.executeQuery();
			
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
	//2��° ������ �ڵ�
	//��ü �˻�
	public List<StudentDTO> selectAll() {
		// list ó���� ���� ������� ��ȯ��.
		// DAO��Ģ�� DAO���ο��� �����͸� ����ϸ� �ȉ�.
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql = "select * from student";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		
		if(list.isEmpty()) {
			list = null;
		} else {
			list.trimToSize();
		}
		return list;
	}
	
	// 3�� web�� �°� ���� ��ü�˻�
	public List<StudentDTO> select(){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql  = "select * from student";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				String name = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				
				list.add(dto);
			}	
		}catch (SQLException e) {
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
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}
	//3�� ���� �ڵ� �ڵ�˻�
	public List<StudentDTO> select(int code){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql =  "select * from student where code = ?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String value = rs.getString("value");

				StudentDTO dt = new StudentDTO(name, value, code);
				
				list.add(dt);
			}	
		}catch (SQLException e) {
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
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}
	//3�� web�� �°� ���� �̸��˻�
	public List<StudentDTO> select(String name){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql = "select * from student where name like ?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+ name + "%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				
				StudentDTO dt = new StudentDTO(name, value, code);
				list.add(dt);
			}	
		}catch (SQLException e) {
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
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}
	
	// SQL ���ù� [ ���� �� ���x ] 
	private String sqlSelect(int choose) {
		String sql = null;
		if(choose == 1) {
			sql = "select * from Student where name like";
			
		} else if (choose == 2) {
			sql = "select * from Student where code = ?";
			
		} else {
			sql = "select * from Student";
		}
		return sql;
	}
	
	//�Ѱ��� ���ڵ带 select�ϴ� Method
	public StudentDTO selectOne(String name) {
		// �ϳ��� ���ڵ常 ���ǿ� ���� �����ϱ� ������ ���ǿ� �´� ���� ������ null�� ��ȯ�ϰ���
		// �Ʒ��� IF������ ó���ϱ� ������ ���� ������ ���������� �ƹ��͵� ��ȯ�� �� ���Ե�.
		StudentDTO dto = null;
		
		String sql = "select * from student where name = ?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			// ���� : �ߺ��� ���ڵ尡 ���ٴ� �����Ͽ� ������ ���
			// �ϳ��� ���ڵ常 �����ϱ� ������ IF�� ���� ���� ���ڵ尡 �ִ��� Ȯ��
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	
	
	public int update(StudentDTO dto) {
		String sql = "update Student set code=? , value=? where name = ?";
		
		int su = 0;
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getCode());
			ps.setString(2, dto.getvalue());
			ps.setString(3, dto.getName());
			su = ps.executeUpdate();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(con !=null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public boolean delete(String name) {
		boolean check = false;
		
		String sql = "delete from Student where name=?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
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
