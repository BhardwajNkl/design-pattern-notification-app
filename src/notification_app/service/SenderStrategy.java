package notification_app.service;

import notification_app.mock_db.model.Notification;
import notification_app.mock_db.model.User;

public interface SenderStrategy {
	void send(User subscriber, Notification notification);
}
