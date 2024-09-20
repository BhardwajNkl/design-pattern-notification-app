package notification_app.service;

import notification_app.mock_db.Notification;

public interface SenderStrategy {
	void send(String subscriber, Notification notification);
}
