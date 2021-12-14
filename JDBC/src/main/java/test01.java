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
		
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		System.out.print("Ű �Է�: ");
		double height = sc.nextDouble();
		
		sc.close();
		
		
		DBTestDTO dto = new DBTestDTO(name, age, height);
		DBTestDAO dao = new DBTestDAO();
		
		int su = dao.insert(dto);
		
		if(su != 0) {
			System.out.println("�Է� ����");
		} else {
			System.out.println("�Է� ����");
		}
		
	} //main �� ����
		
}
