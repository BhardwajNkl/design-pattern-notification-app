package notification_app.service;

import java.util.List;

import notification_app.mock_db.model.User;

public interface AppFacade {
	void addUser(User user);
	void deleteUser(String name);
	void addSubscriber(String name);
	void deleteSubscriber(String name);
	List<User> getUsers();
	List<String> getSubscribers();
	void addNotification(String subject, String message, String channel);
}
