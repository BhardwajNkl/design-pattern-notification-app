package notification_app.service;

import java.util.List;

import notification_app.mock_db.User;

public interface UserService {
	boolean addUser(User user);
	boolean deleteUser(String name);
	List<User> getUsers();
}
