import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.batch.FileSystem;

import dbtest.dbtestdao.DBTestDAO;
import dbtest.dbtestdto.DBTestDTO;

public class test01 {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력: ");
		double height = sc.nextDouble();
		
		sc.close();
		
		
		DBTestDTO dto = new DBTestDTO(name, age, height);
		DBTestDAO dao = new DBTestDAO();
		
		int su = dao.insert(dto);
		
		if(su != 0) {
			System.out.println("입력 성공");
		} else {
			System.out.println("입력 실패");
		}
		
	} //main 끝 지점
		
}
