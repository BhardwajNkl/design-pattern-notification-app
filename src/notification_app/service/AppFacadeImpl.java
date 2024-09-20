package notification_app.service;

import java.util.List;

import notification_app.mock_db.User;

public class AppFacadeImpl implements AppFacade {
	private final UserService userService;
	private final SubscriptionService subscriptionService;
	private final NotificationService notificationService;
	
	public AppFacadeImpl(UserService userService,
			SubscriptionService subscriptionService,
			NotificationService notificationService) {
		this.userService = userService;
		this.subscriptionService = subscriptionService;
		this.notificationService= notificationService;
	}
	
	
	@Override
	public boolean addUser(User user) {
		return userService.addUser(user);
	}
	
	@Override
	public boolean deleteUser(String name) {
		return userService.deleteUser(name);
	}

	@Override
	public boolean addSubscriber(String name) {
		return subscriptionService.addSubscriber(name);
	}
	
	@Override
	public boolean deleteSubscriber(String name) {
		return subscriptionService.deleteSubscriber(name);
	}

	@Override
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@Override
	public List<String> getSubscribers() {
		return subscriptionService.getSubscribers();
	}

	@Override
	public void addNotification(String subject, String message, String channel) {
		notificationService.addNotification(subject, message, channel);
	}

}
