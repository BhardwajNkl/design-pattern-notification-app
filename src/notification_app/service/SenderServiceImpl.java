package notification_app.service;

import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.RED_BOLD;

import notification_app.factory.AppContext;
import notification_app.factory.SenderStrategyFactory;
import notification_app.mock_db.model.Notification;

public class SenderServiceImpl implements SenderService, Observer {
	
	private static SenderServiceImpl INSTANCE;
	
	private SubscriptionService subscriptionService;
	
	private NotificationServiceImpl subject;
	private Notification notification;
	private SenderStrategy senderStrategy;
	
	private SenderServiceImpl() {
		this.subscriptionService = AppContext.getObject(SubscriptionService.class);
		this.subject = (NotificationServiceImpl) AppContext.getObject(NotificationService.class);
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
		senderStrategy = SenderStrategyFactory.getSenderStrategy(notification.getChannel());
		
		if(senderStrategy!=null) {
			subscriptionService.getSubscribers().stream()
			.map(subs->subscriptionService.getUserAssociatedWithSubscriber(subs)) // map subscriber to the respective user
			.forEach(user->{
				// if this subscriber is not active on given channel, we cannot send.
				if(user.getUserChannelMap().containsKey(notification.getChannel())) {
					senderStrategy.send(user, notification);
				} else {
					System.out.println(RED_BOLD+"Skipping User: "+user.getName() + " [ User is not available on channel: "+notification.getChannel()+"]"+DEFAULT+"\n");
				}
			});
		} else {
			System.out.println(RED_BOLD+"Cannot send notification on this channel! [ Unknown channel: "+notification.getChannel()+"]"+DEFAULT+"\n");
		}
	}

}
