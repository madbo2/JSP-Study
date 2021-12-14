package dbtest.dbtestdto; //Ŭ������ �ݵ�� Ư�� ��Ű�� �Ҽ��̾�� �Ѵ�.

import java.sql.Date;

public class DBTestDTO {
	
	//Property DTO�� ��������� Property(������Ƽ)��� �θ���..
	
	// Property���� �ݵ�� ���̺��� �÷���� �����Ͽ��� �Ѵ�..
	// Property�� ���� �����ڴ� �ݵ�� private�̾�� �Ѵ�...
	private String name;
	private int age;
	private double height;
	private Date logtime;
	
	//�ݵ�� ����Ʈ �����ڴ� �����Ͽ��� �Ѵ�..
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
	
	
	// Property���� getter�� setter�� �����Ͽ��� �Ѵ�..
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
