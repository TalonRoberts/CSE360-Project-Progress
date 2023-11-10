package application;

public class Employee {
	private int id;
	private String name;
	private String password;
	
	public Employee(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		password = "";
	}
	
	public void setid(int newid) {
		id = newid;
	}
	
	public void setName(String newname) {
		name = newname;
	}
	public void setPassword(String newpassword) {
		password = newpassword;
	}
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getId() {
		return id;
	}
}
