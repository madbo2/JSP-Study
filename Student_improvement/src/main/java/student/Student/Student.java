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
	
	private void menu() { //Ŭ���� �ȿ����� �����ϹǷ� Private
		while(true){
			System.out.print("****************\r\n" + 
					"   ����\r\n" + 
					"****************\r\n" + 
					"  1. �Է�\r\n" + 
					"  2. �˻�\r\n" + 
					"  3. ����\r\n" + 
					"  4. ����\r\n" + 
					"  5. ����\r\n" + 
					"****************\r\n" + 
					"  ��ȣ���� : ");
			
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
				exit(); // ���� �޼ҵ� �ۼ�
				break;
			default:
				System.out.println("�߸��� �޴� �Է�!");
			}
		}
	}
	private void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		sc.close();
		System.exit(0);
	}
	
	private void insertArticle() {
		int code = codeInput(); 			// Ȯ�强�� ���� �Է� �޼ҵ� �ۼ�
		if(code==4) {
			return;
		} else if(code <1 || code >4) {
			System.out.println("�߸��� �����Դϴ�");
			return;
		}
		
		String name = nameInput("");
		String value = valueInput(code);
		
		StudentDTO dto = new StudentDTO(name, value, code);
		
		StudentDAO dao = StudentDAO.getInstance();
		
		boolean check = dao.insert(dto);		//���â ����� ���� Boolean
		
		
		if(check) {
			System.out.println(name + "���� ������ �߰� �Ǿ����ϴ�.");
		}else {
			System.out.println("���� �߰��� �����Ͽ����ϴ�.");
		}
		
	}
	
	//1���� �ٲ� Select Function
	private void selectArticle() {
		int choose = chooseInput();
		
		if(choose==4) {
			return;
		} else if(choose < 1 || choose > 4) {
			System.out.println("�߸��� �����Դϴ�");
			return;
		}
		
		if(choose==1) {
			String name = nameInput("�˻���");
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
	
	//2���� ������ Select Function
	private void selectArticle1() {
		int select = chooseInput();
		
		if(select == 4) {
			System.out.println("���� �޴��� ���ư��ϴ�.");
		} else if(select <1 || select >4) {
			System.out.println("�߸��� �����Դϴ�. �����޴��� ���ư��ϴ�");
			return;
		}
		
		StudentDTO dto = null;
		
		if(select == 1) {
			dto = new StudentDTO();
			System.out.println("�˻��� �̸� �Է� : ");
			dto.setName(sc.next());
		} else if (select == 2) {
			int code = codeInput();
			if(select ==4) {
				System.out.println("���� �޴���");
				return;
			} else if( select <1 || select > 4) {
				System.out.println("�߸��� �����Դϴ�.");
				return;
			}
			dto = new StudentDTO();
			dto.setCode(code);
		}
		StudentDAO dao = StudentDAO.getInstance();
		
		List<StudentDTO> list = dao.select();
		
		if(list == null) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			for(StudentDTO d : list) {
				System.out.print("�̸� : " + d.getName() + "\t");
				if(d.getCode() == 1) {
					System.out.println("�й� : " + d.getvalue());
				}else if(d.getCode() == 2) {
					System.out.println("���� : " + d.getvalue());
				}else if(d.getCode() == 3) {
					System.out.println("�μ� : " + d.getvalue());
				}
			}
		}
	}
	
	// 1�� ���� �ڵ�
	private void updateArticle() {
		String name = nameInput("������ ");
		int code = codeInput();
		String value = valueInput(code);
		
		StudentDTO dto = new StudentDTO(name,value, code);
		StudentDAO dao = StudentDAO.getInstance();
		
		dao.select(dto, 1);
		
		int su = dao.update(dto);
		
		if(su!=0) {
			System.out.println(name + "���� ������ ���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("���� �۾��� �����Ͽ����ϴ�.");
		}
	}
	//2�� ���� �ڵ�
	private void updateArticle2() {
		String name  = nameInput("������ ");
		
		StudentDAO dao = StudentDAO.getInstance();
		
		StudentDTO dto = dao.selectOne(name); // 1���� ���ڵ常�˻��ϴ� �޼ҵ�
		
		if(dto == null) {
			System.out.println("�˻� ���� �����޴��� ���ư��ϴ�.");
			return;
		}
		System.out.println(dto.getName()+"���� ����");
		System.out.println(valueString(dto.getCode())+dto.getvalue());
		
		int code = codeInput();
		
		if(code == 4) {
			return;
		}else if(code < 1 || code > 4) {
			System.out.println("�߸��� ����!..���� �޴���..");
			return;
		}
		
		String value = valueInput(code);
		
		dto.setValue(value);
		dto.setCode(code);
		
		int su = dao.update(dto);
		
		if(su!=0) {
			System.out.println(name + "���� ������ ���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("���� �۾��� �����Ͽ����ϴ�.");
		}
		
	}
	private String valueString(int code) {
		if(code == 1) {
			return "�й� : ";
		} else if (code==2) {
			return "���� : ";
		} else {
			return "�μ� : ";
		}
	}
	
	
	private void deleteArticle() {
		String name = nameInput("");
		
		StudentDTO dto = new StudentDTO(name);
		StudentDAO dao = StudentDAO.getInstance();
		
		boolean check = dao.delete(name);
		
		if(check) {
			System.out.println(name + "���� ������ ���� �Ǿ����ϴ�.");
		}else {
			System.out.println("���� ������ �����Ͽ����ϴ�.");
		}
		
	}
	
	private int chooseInput() {
		System.out.print(
				"****************\r\n" + 
				"  1. �̸��˻�\r\n" + 
				"  2. �ڵ�˻�\r\n" + 
				"  3. ��ü�˻�\r\n" + 	
				"  4. ��������\r\n" + 
				"****************\r\n" + 
				"  ��ȣ���� : ");
		int select = sc.nextInt();
		
		return select; 
	}
	private int codeInput() {
		System.out.print("****************\r\n"
				+ "   1. �л�\r\n"
				+ "   2. ����\r\n"
				+ "   3. ������\r\n"
				+ "   4. �����޴�\r\n"
				+ "****************\r\n"
				+ "   ��ȣ���� : ");
		int code = sc.nextInt();
		
		return code;
	}
	
	private String nameInput(String msg) {
		System.out.print(msg + "�̸� �Է� : ");
		String name = sc.next();
		return name;
	}
	private String valueInput(int code) {
		if(code==1) {
			System.out.print("�й� �Է� : ");
		} else if (code==2) {
			System.out.print("���� �Է� : ");
		} else {
			System.out.print("�μ� �Է� : ");
		}
		return sc.next();
	}
}
