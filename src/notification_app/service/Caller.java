package notification_app.service;

import static notification_app.util.ConsoleColors.BLUE_BOLD;
import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.GREEN_BOLD;

/**
 * This class implements feature to make calls with given message on a given number.
 * 
 * This class will be used in our application to send notifications to subscribers through mobile call.
 * But, this class cannot be used directly. Our application uses channels that implement the SenderStrategy interface. But this class does not do that and hence incompatible.
 * So, we will use the adapter pattern and create an adaptor class so that we can send notifications to our subscribers using this Caller class.
 * 
 * The adapter class is: SendByCall.java
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */

public class Caller {
	public void call(String mobileNumber, String message) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(BLUE_BOLD+"Calling On: "+DEFAULT+GREEN_BOLD+mobileNumber+DEFAULT);
		System.out.println(BLUE_BOLD+"Audio message is:"+DEFAULT);
		System.out.println(BLUE_BOLD+message+DEFAULT);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(GREEN_BOLD+"***Call finished***\n"+DEFAULT);
	}
}
