package notification_app.service;

import java.util.List;

import notification_app.mock_db.model.User;

public interface SubscriptionService {
	void addSubscriber(String name);
	void deleteSubscriber(String name);
	
	List<String> getSubscribers();
	User getUserAssociatedWithSubscriber(String subscriber);
}
