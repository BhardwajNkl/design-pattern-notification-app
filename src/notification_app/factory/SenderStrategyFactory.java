package notification_app.factory;

import notification_app.service.SendByCall;
import notification_app.service.SendByEmail;
import notification_app.service.SendBySms;
import notification_app.service.SendByTelegram;
import notification_app.service.SenderStrategy;

public class SenderStrategyFactory {
	
/**
 * If we agree on a particular class naming format, the below factory method 1 will be better because we will just need to have the class in the source.
 * Otherwise, we have the 2nd method. We will need to modify and add one more 'case' every time we add a new channel.
 */
	
// FACTORY 1
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
	
	
// FACTORY 2
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
