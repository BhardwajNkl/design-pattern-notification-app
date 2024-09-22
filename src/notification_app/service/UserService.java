package notification_app.service;

import java.util.List;

import notification_app.mock_db.model.User;

public interface UserService {
	void addUser(User user);
	void deleteUser(String name);
	List<User> getUsers();
}
