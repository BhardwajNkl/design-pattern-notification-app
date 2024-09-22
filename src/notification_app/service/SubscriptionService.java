package notification_app.service;

import java.util.List;

public interface SubscriptionService {
	void addSubscriber(String name);
	void deleteSubscriber(String name);
	
	List<String> getSubscribers();
}
