package notification_app.service;

import java.util.List;

public interface SubscriptionService {
	boolean addSubscriber(String name);
	boolean deleteSubscriber(String name);
	
	List<String> getSubscribers();
}
