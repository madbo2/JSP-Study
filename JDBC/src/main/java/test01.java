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
		
		/* Class.forName�� ���� https://jongminlee0.github.io/2019/06/29/reflection/
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
		
		// ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
		} catch(ClassNotFoundException e ) {
			System.out.println("�ε� ����");
			e.printStackTrace();
		}
		
		//Connection ��ü ����
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##jsp";
		String password = "oracle";
		
		try {
			con = DriverManager.getConnection(url,user,password);
			System.out.println("���� ����");
		} catch(SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		System.out.print("Ű �Է�: ");
		double height = sc.nextDouble();
		
		sc.close();
		
		/*Statement
		
		Statement stmt = null;
		
		String sql = "insert into dbtest values('"+name+"',"+age+","+height+",sysdate)";
		
		try {
			stmt = con.createStatement();
			int su = stmt.executeUpdate(sql);
			if(su != 0 ) {
				System.out.println("�Է� ����");
			} else {
				System.out.println("�Է� ����");
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
				System.out.println("�Է� ����");
			} else {
				System.out.println("�Է� ����");
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
		// �̸��� ���ؼ� ���̿� Ű ���� 
		PreparedStatement ps = null;
		String sql = "update dbtest set age=?, height=? where name=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, age);
			ps.setDouble(2, height);
			ps.setString(3, name);
			
			int su = ps.executeUpdate();
			if(su != 0 ) {
				System.out.println("�Է� ����");
			} else {
				System.out.println("�Է� ����");
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
		
	} //main �� ����
		
}
