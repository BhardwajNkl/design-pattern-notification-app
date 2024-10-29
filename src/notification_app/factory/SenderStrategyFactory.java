package notification_app.factory;

import notification_app.service.SendByCall;
import notification_app.service.SendByEmail;
import notification_app.service.SendBySms;
import notification_app.service.SendByTelegram;
import notification_app.service.SenderStrategy;

/**
 * This class has a factory method to provide a specific SenderStrategy instance.
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */

public class SenderStrategyFactory {
	
/**
 * If we standardize the class naming format, the below factory method will be a better choice because we will just need to have the class in the source.
 * This implementation uses the reflection API for getting the instance of a particular SenderStrategy interface by name.
 */
	
//	public static SenderStrategy getSenderStrategy(String type) {
//		type = type.substring(0,1).toUpperCase()+type.substring(1); // Because for any channel xyz, the class name format is SendByXyz.
//		try {
//			Class<?> SenderStrategyClass = Class.forName("notification_app.service.SendBy"+type);
//			Method getInstanceMethod = SenderStrategyClass.getMethod("getInstance");
//			return (SenderStrategy) getInstanceMethod.invoke(null);
//		} catch(ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
//			return null;
//		}
//	}
	

	/*
	 * Otherwise, we have the below factory method. We will need to modify and add one more 'case' every time we add support for a new channel.
	 */
	public static SenderStrategy getSenderStrategy(String type) {
		
		switch(type) {
		case "email": {
			return SendByEmail.getInstance();
		}
		case "sms":{
			return SendBySms.getInstance();
		}
		case "call": {
			return SendByCall.getInstance();
		}
		case "telegram":{
			return SendByTelegram.getInstance();
		}
		default:{
			return null;
		}
		}
	}
		
}
