package MyHomeDTO;

public class MyHomeDTO {
	private int no;
	private String id;
	private String password;
	private String name;
	private String email;
	private String tel1;
	private String tel2;
	private String tel3;
	
	public MyHomeDTO() {
		
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	
	public int getNo() {
		return no;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getTel1() {
		return tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public String getTel3() {
		return tel3;
	}
}