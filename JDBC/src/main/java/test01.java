import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.batch.FileSystem;

public class test01 {
	
	public static void main(String[] args) {
		
		//Class.forName();
		//Object ob = new Object();
		
		/* Class.forName의 예시 https://jongminlee0.github.io/2019/06/29/reflection/
		 * 
		String classPath = "Java.lang.Object";
		try {
			Object ob = Class.forName(classPath).newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		// 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 성동");
		} catch(ClassNotFoundException e ) {
			System.out.println("로딩 실패");
			e.printStackTrace();
		}
		
		//Connection 객체 생성
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
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력: ");
		double height = sc.nextDouble();
		
		sc.close();
		
		/*Statement
		
		Statement stmt = null;
		
		String sql = "insert into dbtest values('"+name+"',"+age+","+height+",sysdate)";
		
		try {
			stmt = con.createStatement();
			int su = stmt.executeUpdate(sql);
			if(su != 0 ) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}*/
		/*
		PreparedStatement ps = null;
		String sql = "insert into dbtest values(?,?,?,sysdate)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setDouble(3, height);
			
			int su = ps.executeUpdate();
			if(su != 0 ) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
			
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
		*/
		// 이름을 통해서 나이와 키 수정 
		PreparedStatement ps = null;
		String sql = "update dbtest set age=?, height=? where name=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, age);
			ps.setDouble(2, height);
			ps.setString(3, name);
			
			int su = ps.executeUpdate();
			if(su != 0 ) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
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
		
	} //main 끝 지점
		
}
