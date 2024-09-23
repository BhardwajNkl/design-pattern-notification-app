package notification_app.mock_db.model;

public class User {
	
	private String name;
	private String email;
	private String mobile;
	
	public User(String name, String email, String mobile) {
		this.name=name;
		this.email = email;
		this.mobile = mobile;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
		
	
}
