package MyHomeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
}
