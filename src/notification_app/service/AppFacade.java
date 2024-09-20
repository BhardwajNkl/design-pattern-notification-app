package notification_app.service;

import java.util.List;

import notification_app.mock_db.User;

public interface AppFacade {
	boolean addUser(User user);
	boolean deleteUser(String name);
	boolean addSubscriber(String name);
	boolean deleteSubscriber(String name);
	List<User> getUsers();
	List<String> getSubscribers();
	void addNotification(String subject, String message, String channel);
}
