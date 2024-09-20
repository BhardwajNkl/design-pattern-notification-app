package notification_app.service;

import notification_app.mock_db.Notification;

public class SenderServiceImpl implements SenderService, Observer {
	
	private Notification notification;
	private SubscriptionService subscriptionService;
	private SenderStrategy senderStrategy;
	
	public SenderServiceImpl(Subject subject, SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
		subject.register(this);
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
			senderStrategy = new SendByEmail();
		} else {
			senderStrategy = new SendBySMS();
		}
		
		subscriptionService.getSubscribers().forEach(subscriber->{
			senderStrategy.send(subscriber, notification);
		});
	}

}
