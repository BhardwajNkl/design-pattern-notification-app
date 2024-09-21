package notification_app.service;

import notification_app.factory.ObjectFactory;
import notification_app.mock_db.Notification;

// adapter class for Caller channel

public class SendByCall implements SenderStrategy {

	private static SendByCall INSTANCE;
	private Caller caller;
	
	private SendByCall() {
		this.caller = ObjectFactory.getCaller();
	}
	
	synchronized public static SendByCall getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SendByCall();
		}
		
		return INSTANCE;
	}
	
	@Override
	public void send(String subscriber, Notification notification) {
		// the caller class provides call method which takes mobile number and message.
		String mobileNuber = subscriber+100;
		String message = notification.getMessage();
		caller.call(mobileNuber, message);
	}
	
}
