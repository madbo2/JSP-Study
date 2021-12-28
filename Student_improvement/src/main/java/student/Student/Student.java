package student.Student;

import java.util.List;
import java.util.Scanner;

import student.StudentDTO.StudentDTO;
import student.studentDAO.StudentDAO;

public class Student {
	private final Scanner sc = new Scanner(System.in);
	
	public Student() {
		menu();
	}
	
	private void menu() { //클래스 안에서만 동작하므로 Private
		while(true){
			System.out.print("****************\r\n" + 
					"   관리\r\n" + 
					"****************\r\n" + 
					"  1. 입력\r\n" + 
					"  2. 검색\r\n" + 
					"  3. 수정\r\n" + 
					"  4. 삭제\r\n" + 
					"  5. 종료\r\n" + 
					"****************\r\n" + 
					"  번호선택 : ");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :
				insertArticle();
				break;
			case 2:
				selectArticle1();
				break;
			case 3:
				updateArticle2();
				break;
			case 4:
				deleteArticle();
				break;
			case 5:
				exit(); // 종료 메소드 작성
				break;
			default:
				System.out.println("잘못된 메뉴 입력!");
			}
		}
	}
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();
		System.exit(0);
	}
	
	private void insertArticle() {
		int code = codeInput(); 			// 확장성을 위한 입력 메소드 작성
		if(code==4) {
			return;
		} else if(code <1 || code >4) {
			System.out.println("잘못된 선택입니다");
			return;
		}
		
		String name = nameInput("");
		String value = valueInput(code);
		
		StudentDTO dto = new StudentDTO(name, value, code);
		
		StudentDAO dao = StudentDAO.getInstance();
		
		boolean check = dao.insert(dto);		//결과창 출력을 위한 Boolean
		
		
		if(check) {
			System.out.println(name + "님의 정보가 추가 되었습니다.");
		}else {
			System.out.println("정보 추가에 실패하였습니다.");
		}
		
	}
	
	//1차로 바꾼 Select Function
	private void selectArticle() {
		int choose = chooseInput();
		
		if(choose==4) {
			return;
		} else if(choose < 1 || choose > 4) {
			System.out.println("잘못된 선택입니다");
			return;
		}
		
		if(choose==1) {
			String name = nameInput("검색할");
			StudentDTO dto = new StudentDTO(name);
			StudentDAO dao = StudentDAO.getInstance();
			dao.select(dto, choose);
		} else if( choose==2) {
			int code = codeInput();
			StudentDTO dto = new StudentDTO(code);
			StudentDAO dao = StudentDAO.getInstance();
			dao.select(dto,choose);
		} else {
			StudentDTO dto = new StudentDTO();
			StudentDAO dao = StudentDAO.getInstance();
			dao.select(dto,choose);
		}
	}
	
	//2차로 수정한 Select Function
	private void selectArticle1() {
		int select = chooseInput();
		
		if(select == 4) {
			System.out.println("이전 메뉴로 돌아갑니다.");
		} else if(select <1 || select >4) {
			System.out.println("잘못된 선택입니다. 이전메뉴로 돌아갑니다");
			return;
		}
		
		StudentDTO dto = null;
		
		if(select == 1) {
			dto = new StudentDTO();
			System.out.println("검색할 이름 입력 : ");
			dto.setName(sc.next());
		} else if (select == 2) {
			int code = codeInput();
			if(select ==4) {
				System.out.println("이전 메뉴로");
				return;
			} else if( select <1 || select > 4) {
				System.out.println("잘못된 선택입니다.");
				return;
			}
			dto = new StudentDTO();
			dto.setCode(code);
		}
		StudentDAO dao = StudentDAO.getInstance();
		
		List<StudentDTO> list = dao.select();
		
		if(list == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(StudentDTO d : list) {
				System.out.print("이름 : " + d.getName() + "\t");
				if(d.getCode() == 1) {
					System.out.println("학번 : " + d.getvalue());
				}else if(d.getCode() == 2) {
					System.out.println("과목 : " + d.getvalue());
				}else if(d.getCode() == 3) {
					System.out.println("부서 : " + d.getvalue());
				}
			}
		}
	}
	
	// 1차 수정 코드
	private void updateArticle() {
		String name = nameInput("수정할 ");
		int code = codeInput();
		String value = valueInput(code);
		
		StudentDTO dto = new StudentDTO(name,value, code);
		StudentDAO dao = StudentDAO.getInstance();
		
		dao.select(dto, 1);
		
		int su = dao.update(dto);
		
		if(su!=0) {
			System.out.println(name + "님의 정보가 성공적으로 수정되었습니다.");
		} else {
			System.out.println("수정 작업에 실패하였습니다.");
		}
	}
	//2차 수정 코드
	private void updateArticle2() {
		String name  = nameInput("수정할 ");
		
		StudentDAO dao = StudentDAO.getInstance();
		
		StudentDTO dto = dao.selectOne(name); // 1개의 레코드만검색하는 메소드
		
		if(dto == null) {
			System.out.println("검색 실패 이전메뉴로 돌아갑니다.");
			return;
		}
		System.out.println(dto.getName()+"님의 정보");
		System.out.println(valueString(dto.getCode())+dto.getvalue());
		
		int code = codeInput();
		
		if(code == 4) {
			return;
		}else if(code < 1 || code > 4) {
			System.out.println("잘못된 선택!..이전 메뉴로..");
			return;
		}
		
		String value = valueInput(code);
		
		dto.setValue(value);
		dto.setCode(code);
		
		int su = dao.update(dto);
		
		if(su!=0) {
			System.out.println(name + "님의 정보가 성공적으로 수정되었습니다.");
		} else {
			System.out.println("수정 작업에 실패하였습니다.");
		}
		
	}
	private String valueString(int code) {
		if(code == 1) {
			return "학번 : ";
		} else if (code==2) {
			return "과목 : ";
		} else {
			return "부서 : ";
		}
	}
	
	
	private void deleteArticle() {
		String name = nameInput("");
		
		StudentDTO dto = new StudentDTO(name);
		StudentDAO dao = StudentDAO.getInstance();
		
		boolean check = dao.delete(name);
		
		if(check) {
			System.out.println(name + "님의 정보가 삭제 되었습니다.");
		}else {
			System.out.println("정보 삭제에 실패하였습니다.");
		}
		
	}
	
	private int chooseInput() {
		System.out.print(
				"****************\r\n" + 
				"  1. 이름검색\r\n" + 
				"  2. 코드검색\r\n" + 
				"  3. 전체검색\r\n" + 	
				"  4. 이전으로\r\n" + 
				"****************\r\n" + 
				"  번호선택 : ");
		int select = sc.nextInt();
		
		return select; 
	}
	private int codeInput() {
		System.out.print("****************\r\n"
				+ "   1. 학생\r\n"
				+ "   2. 교수\r\n"
				+ "   3. 관리자\r\n"
				+ "   4. 이전메뉴\r\n"
				+ "****************\r\n"
				+ "   번호선택 : ");
		int code = sc.nextInt();
		
		return code;
	}
	
	private String nameInput(String msg) {
		System.out.print(msg + "이름 입력 : ");
		String name = sc.next();
		return name;
	}
	private String valueInput(int code) {
		if(code==1) {
			System.out.print("학번 입력 : ");
		} else if (code==2) {
			System.out.print("과목 입력 : ");
		} else {
			System.out.print("부서 입력 : ");
		}
		return sc.next();
	}
}
