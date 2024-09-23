package notification_app.service;

import notification_app.mock_db.model.Notification;
import notification_app.mock_db.model.User;

/**
 * 
 * @author nikhilbhardwaj01
 * 
 * This class is an adapter class for 'Caller' class.
 *
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
		String mobileNuber = subscriber+"_mobile_number[placeholder]"; // just for demo.
		String message = notification.getMessage();
		caller.call(mobileNuber, message);
	}
	
}
