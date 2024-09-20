package notification_app.service;

public interface NotificationService {
	boolean addNotification(String subject, String message, String channel);
}
