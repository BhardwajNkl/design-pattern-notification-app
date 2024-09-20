package notification_app.service;

import static notification_app.util.ConsoleColors.BLUE_BOLD;
import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.GREEN_BOLD;

import notification_app.mock_db.Notification;

public class SendByEmail implements SenderStrategy {
	private static SendByEmail INSTANCE;
	
	private SendByEmail() {
		
	}
	
	synchronized public static SendByEmail getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SendByEmail();
		}
		return INSTANCE;
	}
	
	@Override
	public void send(String subscriber, Notification notification) {
		System.out.println(BLUE_BOLD+"Sending Email to: "+DEFAULT+GREEN_BOLD+subscriber+DEFAULT);
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
