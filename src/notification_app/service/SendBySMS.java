package notification_app.service;

import static notification_app.util.ConsoleColors.BLUE_BOLD;
import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.GREEN_BOLD;

import notification_app.mock_db.model.Notification;

public class SendBySms implements SenderStrategy {
	private static SendBySms INSTANCE;
	
	private SendBySms() {
		
	}
	
	synchronized public static SendBySms getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SendBySms();
		}
		return INSTANCE;
	}
	
	@Override
	public void send(String subscriber, Notification notification) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(BLUE_BOLD+"Sending SMS to: "+DEFAULT+GREEN_BOLD+subscriber+DEFAULT);
		System.out.println(BLUE_BOLD+"Notification is:"+DEFAULT);
		System.out.println(BLUE_BOLD+notification+DEFAULT);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(GREEN_BOLD+"***Sent***\n"+DEFAULT);
	}
}
