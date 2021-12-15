package student.studentDTO;

import java.util.Scanner;

public class StudentDTO {
	
	Scanner sc = new Scanner(System.in);
	
	private String name;
	private String value;
	private int code;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(int code) {
		this.code = code;	
	}
	
	public StudentDTO(String name) {
		this.name = name;
	}
	public StudentDTO(String name, String value, int code) {
		this.name = name;
		this.value = value;
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public String getvalue() {
		return value;
	}
	public int getCode() {
		return code;
	}
}
