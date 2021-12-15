package student.Student;

import java.util.Scanner;
import student.studentDAO.*;
import student.studentDTO.StudentDTO;

public class Student {
	
	
	int code;
	String name;
	String value;
	
	public Student() {
		
	}
	
	Scanner sc = new Scanner(System.in);
	StudentDAO dao = new StudentDAO();  //����̹� �ε�
	StudentDTO dto = new StudentDTO();
	
	public void menu() {
		
		System.out.println("**************");
		System.out.println(" 1. Insert \n 2. select \n 3. delete \n 4. exit");
		System.out.println("**************");
		System.out.print("��ȣ���� : ");
		int choose = sc.nextInt();
		
		switch(choose){
			case 1:
				System.out.println("**************");
				System.out.println("1. �л� \n 2.���� \n 3. ������ \n 4. ��������");
				System.out.println("**************");
				System.out.print("��ȣ���� : ");
				code = sc.nextInt();
				
				System.out.print("�̸��Է� : ");
				name = sc.next();
				
				if(code ==1) {
					System.out.print("�й��Է� : ");
					value = sc.next();
				} else if (code == 2) {
					System.out.print("�����Է� : ");
					value = sc.next();
				} else if (code == 3) {
					System.out.print("�μ��Է� : ");
					value = sc.next();
				}
				
				dto.setName(name);
				dto.setCode(code);
				dto.setValue(value);
				dao.insertArticle(dto);
				break;
			case 2:
				System.out.println("**************");
				System.out.println("1. �̸��˻� \n 2. �ڵ�˻� \n 3. ��ü�˻� \n 4. ��������");
				System.out.println("**************");
				System.out.print("��ȣ���� : ");
				int choose1 = sc.nextInt();
				
				switch(choose1) {
					case 1:
						System.out.print("�̸� �Է� : ");
						this.name = sc.next();
						dto.setName(this.name);
						dao.selectArticle(dto,choose1);
						break;
					case 2:
						System.out.print("�ڵ� �Է� : ");
						this.code = sc.nextInt();
						dto.setCode(this.code);
						dao.selectArticle(dto,choose1);
						break;
					case 3:
						dao.selectArticle(dto,choose1);
				}
				
				break;
			case 3:
				System.out.print("������ ���ϴ� �̸� �Է� : ");
				String name = sc.next();
				
				dto.setName(name);
				dao.deleteArticle(dto);
				break;
			case 4:
				System.exit(0);
		}
		
	}
}
