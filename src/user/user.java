package user;

public class user {

	private int id;
	private String tennv;
	private String sdtnv;
	private String username;
	private String password;
	private String role;
	
	
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getSdtnv() {
		return sdtnv;
	}
	public void setSdtnv(String sdtnv) {
		this.sdtnv = sdtnv;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public user(int id, String tennv, String sdtnv, String username, String password, String role) {
		super();
		this.id = id;
		this.tennv = tennv;
		this.sdtnv = sdtnv;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public user() {
		
	}
	
}
