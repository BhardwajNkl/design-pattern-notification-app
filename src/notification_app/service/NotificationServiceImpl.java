package notification_app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import notification_app.mock_db.Notification;

/**
 * 
 * @author nikhilbhardwaj01
 * notification service has a state: messages
 * it is the subject class being observed by message sender service.
 * whenever a message comes, message sender is updated and that service sends mails/sms to all subscribers.
 *
 */

public class NotificationServiceImpl implements NotificationService, Subject {
	
	private static NotificationServiceImpl INSTANCE;
	
	// state
	List<Notification> notifications = new ArrayList<>();
	
	// observers
	Set<Observer> observers = new HashSet<>();
	
	private NotificationServiceImpl() {
		
	}
	
	synchronized public static NotificationServiceImpl getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new NotificationServiceImpl();
		}
		
		return INSTANCE;
	}
	
	
	@Override
	public boolean addNotification(String subject, String message, String channel) { 
		Notification notification = new Notification(subject, message, channel);
		notifications.add(notification);
		updateObservers();
		return true;
	}

	@Override
	public void register(Observer observer) {
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void unRegister(Observer observer) {
		if(observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	@Override
	public void updateObservers() {
		observers.forEach(observer->observer.update(notifications.get(notifications.size()-1))); // latest notification
	}
}
