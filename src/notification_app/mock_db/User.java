package notification_app.mock_db;

public class User {
//	private int id;
	private String name;
	public User(String name) {
//		this.id=id;
		this.name=name;
	}
	
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public int getId() {
//		return this.id;
//	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
	
}
