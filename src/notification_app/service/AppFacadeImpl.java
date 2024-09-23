package notification_app.service;

import java.util.List;

import notification_app.factory.AppContext;
import notification_app.mock_db.model.User;

public class AppFacadeImpl implements AppFacade {
	
	private static AppFacadeImpl INSTANCE;
	
	private final UserService userService;
	private final SubscriptionService subscriptionService;
	private final NotificationService notificationService;
	
	private AppFacadeImpl() {
		this.userService = AppContext.getObject(UserService.class);
		this.subscriptionService = AppContext.getObject(SubscriptionService.class);
		this.notificationService= AppContext.getObject(NotificationService.class);
	}
	
	
	synchronized public static AppFacade getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new AppFacadeImpl();
		}
		return INSTANCE;
	}
	
	@Override
	public void addUser(User user) {
		userService.addUser(user);
	}
	
	@Override
	public void deleteUser(String name) {
		userService.deleteUser(name);
	}

	@Override
	public void addSubscriber(String name) {
		subscriptionService.addSubscriber(name);
	}
	
	@Override
	public void deleteSubscriber(String name) {
		subscriptionService.deleteSubscriber(name);
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


	@Override
	public void addUserAvailabilityChannel(String userName, String channelName, String channelContactValue) {
		userService.addUserAvailabilityChannel(userName, channelName, channelContactValue);
	}


}
