package notification_app.service;

import notification_app.mock_db.model.Notification;
import notification_app.mock_db.model.User;

/**
 * This class implements the SenderStrategy interface and it is used to send notifications to subscribers via call.
 * It is an adapter class for 'Caller.java' class.
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */

public class SendByCall implements SenderStrategy {

	private static SendByCall INSTANCE;
	private Caller caller;
	
	private SendByCall() {
		this.caller = new Caller();
	}
	
	synchronized public static SendByCall getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SendByCall();
		}
		
		return INSTANCE;
	}
	
	@Override
	public void send(User subscriber, Notification notification) {
		// the caller class provides call method which takes mobile number and message.
		String mobileNuber = subscriber.getUserChannelMap().get("call");
		String message = notification.getMessage();
		caller.call(mobileNuber, message);
	}
	
}
