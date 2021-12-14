package dbtest.dbtestdto; //클래스는 반드시 특정 패키지 소속이어야 한다.

import java.sql.Date;

public class DBTestDTO {
	
	//Property DTO의 멤버변수는 Property(프로퍼티)라고 부른다..
	
	// Property명은 반드시 테이블의 컬럼명과 동일하여야 한다..
	// Property의 접근 지정자는 반드시 private이어야 한다...
	private String name;
	private int age;
	private double height;
	private Date logtime;
	
	//반드시 디폴트 생성자는 존재하여야 한다..
	public DBTestDTO() {
		
	}
	public DBTestDTO(String name, int age, double height) {
		this.name = name;
		this.height = height;
		this.age = age;
	}
	
	public DBTestDTO(String name, int age, double height,Date logtime) {
		this.name = name;
		this.height = height;
		this.age = age;
		this.logtime = logtime;
	}
	
	
	// Property마다 getter와 setter는 존재하여야 한다..
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	public Date getLogtime() {
		return logtime;
	}
	
	
	
}
