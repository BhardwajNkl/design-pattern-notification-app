package notification_app.service;

import notification_app.factory.ObjectFactory;
import notification_app.mock_db.Notification;

public class SenderServiceImpl implements SenderService, Observer {
	
	private static SenderServiceImpl INSTANCE;
	
	private SubscriptionService subscriptionService;
	private NotificationServiceImpl subject;
	private Notification notification;
	private SenderStrategy senderStrategy;
	
	private SenderServiceImpl() {
		this.subscriptionService = ObjectFactory.getSubscriptionService();
		this.subject = (NotificationServiceImpl) ObjectFactory.getNotificationService();
		subject.register(this);
	}
	
	synchronized public static SenderServiceImpl getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SenderServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public void update(Notification notification) {
		this.notification = notification;
		send();
	}

	@Override
	public void send() {
		// send the notification to all subscribers
		if(notification.getChannel().equals("email")) {
			senderStrategy = ObjectFactory.getSendByEmail();
		} else {
			senderStrategy = ObjectFactory.getSendBySMS();
		}
		
		subscriptionService.getSubscribers().forEach(subscriber->{
			senderStrategy.send(subscriber, notification);
		});
	}

}
