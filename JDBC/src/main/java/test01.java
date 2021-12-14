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
		
		String name = null;
		int age = 0;
		double height = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. Insert \t 2.update \t 3. select");
		int Choose = sc.nextInt();
		
		switch(Choose){
			case 1:
				System.out.print("�̸� �Է� : ");
				name = sc.next();
				
				System.out.print("���� �Է� : ");
				age = sc.nextInt();
				
				System.out.print("Ű �Է�: ");
				height = sc.nextDouble();
				
				DBTestDTO dto = new DBTestDTO(name, age, height);
				DBTestDAO dao = new DBTestDAO();
				
				int su = dao.insert(dto);
				
				if(su != 0) {
					System.out.println("�Է� ����");
				} else {
					System.out.println("�Է� ����");
				}
				
				
				break;
			case 2:
				System.out.print("������ �̸� �Է� : ");
				name = sc.next();
				
				System.out.print("���� �Է� : ");
				age = sc.nextInt();
				
				System.out.print("Ű �Է�: ");
				height = sc.nextDouble();
				
				su = dao.update(dto);
				
				if(su != 0) {
					System.out.println("�Է� ����");
				} else {
					System.out.println("�Է� ����");
				}
				
				break;
			case 3:
				dao.select();
				
		}
		
		
		
		sc.close();
		
		
		
	} //main �� ����
	
		
}
