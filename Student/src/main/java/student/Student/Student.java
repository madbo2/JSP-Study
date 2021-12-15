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
	StudentDAO dao = new StudentDAO();  //드라이버 로딩
	StudentDTO dto = new StudentDTO();
	
	public void menu() {
		
		System.out.println("**************");
		System.out.println(" 1. Insert \n 2. select \n 3. delete \n 4. exit");
		System.out.println("**************");
		System.out.print("번호선택 : ");
		int choose = sc.nextInt();
		
		switch(choose){
			case 1:
				System.out.println("**************");
				System.out.println("1. 학생 \n 2.교수 \n 3. 관리자 \n 4. 이전으로");
				System.out.println("**************");
				System.out.print("번호선택 : ");
				code = sc.nextInt();
				
				System.out.print("이름입력 : ");
				name = sc.next();
				
				if(code ==1) {
					System.out.print("학번입력 : ");
					value = sc.next();
				} else if (code == 2) {
					System.out.print("과목입력 : ");
					value = sc.next();
				} else if (code == 3) {
					System.out.print("부서입력 : ");
					value = sc.next();
				}
				
				dto.setName(name);
				dto.setCode(code);
				dto.setValue(value);
				dao.insertArticle(dto);
				break;
			case 2:
				System.out.println("**************");
				System.out.println("1. 이름검색 \n 2. 코드검색 \n 3. 전체검색 \n 4. 이전으로");
				System.out.println("**************");
				System.out.print("번호선택 : ");
				int choose1 = sc.nextInt();
				
				switch(choose1) {
					case 1:
						System.out.print("이름 입력 : ");
						this.name = sc.next();
						dto.setName(this.name);
						dao.selectArticle(dto,choose1);
						break;
					case 2:
						System.out.print("코드 입력 : ");
						this.code = sc.nextInt();
						dto.setCode(this.code);
						dao.selectArticle(dto,choose1);
						break;
					case 3:
						dao.selectArticle(dto,choose1);
				}
				
				break;
			case 3:
				System.out.print("삭제를 원하는 이름 입력 : ");
				String name = sc.next();
				
				dto.setName(name);
				dao.deleteArticle(dto);
				break;
			case 4:
				System.exit(0);
		}
		
	}
}
