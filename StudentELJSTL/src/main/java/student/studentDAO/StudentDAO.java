package student.studentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import student.StudentDTO.StudentDTO;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//singleton 패턴
	// - Program에서 Instance 공간을 하나만 만들어 놓고
	// 가져가 사용할 수 있도록 만드는 프로그램 방식
	private static StudentDAO instance;
	private StudentDAO() {
		
	}
	public static StudentDAO getInstance() {
		if(instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	//Connection Pool 설정
	//DataSource 설정
	private static DataSource ds;
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			// java:comp/env/  = Tomcat 서버 사용시 설정을 불러올때 사용하는 경로
	}catch(NamingException e) {
		e.printStackTrace();
	}
	}
	
	/*public StudentDAO() {
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
	*/
	public boolean insert(StudentDTO dto) {
		boolean check = false;
		
		String sql = "insert into student values(?,?,?)";
		
		
		try {
			con = ds.getConnection();
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
	
	// 1번째 수정한 형식
	public void select(StudentDTO dto,int choose) {
		
		String sql = sqlSelect(choose);
		
		try {
			
			if (choose==1) {
				sql += "'%"+dto.getName()+"%'";
			}
			
			con = ds.getConnection();
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
	//2번째 수정한 코드
	//전체 검색
	public List<StudentDTO> selectAll() {
		// list 처리를 통해 결과값을 반환함.
		// DAO원칙은 DAO내부에서 데이터를 출력하면 안됌.
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql = "select * from student";
		
		try {
			con = ds.getConnection();
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
	
	// 3차 web에 맞게 수정 전체검색
	public List<StudentDTO> select(){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql  = "select * from student";
		
		try {
			con = ds.getConnection();
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
	//3차 수정 코드 코드검색
	public List<StudentDTO> select(int code){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql =  "select * from student where code = ?";
		
		try {
			con = ds.getConnection();
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
	//3차 web에 맞게 수정 이름검색
	public List<StudentDTO> select(String name){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql = "select * from student where name like ?";
		
		try {
			con = ds.getConnection();
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
	
	// SQL 선택문 [ 수정 후 사용x ] 
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
	
	//한개의 레코드를 select하는 Method
	public StudentDTO selectOne(String name) {
		// 하나의 레코드만 조건에 의해 추출하기 때문에 조건에 맞는 값이 없을시 null을 반환하게함
		// 아래를 IF문으로 처리하기 때문에 먼저 지정해 주지않으면 아무것도 반환할 수 없게됨.
		StudentDTO dto = null;
		
		String sql = "select * from student where name = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			// 주의 : 중복된 레코드가 없다는 가정하에 가능한 방법
			// 하나의 레코드만 추출하기 때문에 IF를 통해 다음 레코드가 있는지 확인
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
			con = ds.getConnection();
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
			con = ds.getConnection();
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
