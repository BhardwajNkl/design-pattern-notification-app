package notification_app.service;

import static notification_app.util.ConsoleColors.BLUE_BOLD;
import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.GREEN_BOLD;

import notification_app.mock_db.model.Notification;
import notification_app.mock_db.model.User;

/**
 * This class implements the SenderStrategy interface and it is used to send notifications to subscribers via email.
 * @author nikhilbhardwaj01
 * @version 1.0
 */
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
	public void send(User subscriber, Notification notification) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(BLUE_BOLD+"Sending Email to: "+DEFAULT+GREEN_BOLD+subscriber+DEFAULT);
		System.out.println(BLUE_BOLD+"Notification is:"+DEFAULT);
		System.out.println(BLUE_BOLD+notification+DEFAULT);
		
		// let's simulate the sending by printing stars to indicate some process.
		// we use a random time interval as 'email send time'. Instead of considering random time, we can just pick random number of stars to print.
		int starsToPrint = (int) (Math.random()*10) + 4; // 4 to 14 stars to print meaning around 2 to 7 second interval. 
		Thread starPrinter = new Thread(()->{
			// 20 stars in 10 seconds
			for(int i=1;i<=starsToPrint;i++) {
				System.out.print(GREEN_BOLD);
				System.out.print("* ");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		starPrinter.start();
		
		try {
			starPrinter.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(" Sent\n"+DEFAULT);
	}

}
