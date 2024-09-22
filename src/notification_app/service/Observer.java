package notification_app.service;

import notification_app.mock_db.model.Notification;

public interface Observer {
	void update(Notification notification);
}
