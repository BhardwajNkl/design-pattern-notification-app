package notification_app.service;

import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.RED_BOLD;

import notification_app.factory.AppContext;
import notification_app.factory.SenderStrategyFactory;
import notification_app.mock_db.model.Notification;

/**
 * This is an implementation class for SenderService.
 * It is also an observer class that observes the 'NotificationService' observable.
 * When it is notified about a new notification, it sends that notification to all the subscribers who are active on that specified channel(specified in the notification).
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */
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
		// Get the sender strategy object based on the channel specified in the notification.
		senderStrategy = SenderStrategyFactory.getSenderStrategy(notification.getChannel());
		
		if(senderStrategy!=null) {
			subscriptionService.getSubscribers().stream()
			.map(subs->subscriptionService.getUserAssociatedWithSubscriber(subs)) // map subscriber to the respective user
			.forEach(user->{
				// if this subscriber is not active on given channel, we cannot send.
				if(user.getUserChannelMap().containsKey(notification.getChannel())) {
					senderStrategy.send(user, notification);
				} else {
					System.out.println(RED_BOLD+"Skipping Subscriber: "+user.getName() + " [ Subscriber is not available on channel: "+notification.getChannel()+"]"+DEFAULT+"\n");
				}
			});
		} else {
			System.out.println(RED_BOLD+"Cannot send notification on this channel! [ Unknown channel: "+notification.getChannel()+"]"+DEFAULT+"\n");
		}
	}

}
