package notification_app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import notification_app.mock_db.model.Notification;

/**
 * It is an 'observable' class.
 * NotificationService has a state: 'notifications'.
 * whenever a notification is added, all the subscribers are updated about it.
 * 
 * In this application, SenderService is an observer of this observable. Whenever a notification is added, the sender service pushes it to all the users who have subscribed.
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
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
	public void addNotification(String subject, String message, String channel) { 
		Notification notification = new Notification(subject, message, channel);
		notifications.add(notification);
		updateObservers();
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
