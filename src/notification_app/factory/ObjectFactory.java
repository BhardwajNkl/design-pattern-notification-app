package notification_app.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import notification_app.mock_db.DataRepository;
import notification_app.service.AppFacade;
import notification_app.service.AppFacadeImpl;
import notification_app.service.Caller;
import notification_app.service.NotificationService;
import notification_app.service.NotificationServiceImpl;
import notification_app.service.SenderService;
import notification_app.service.SenderServiceImpl;
import notification_app.service.SenderStrategy;
import notification_app.service.SubscriptionService;
import notification_app.service.SubscriptionServiceImpl;
import notification_app.service.UserService;
import notification_app.service.UserServiceImpl;

public class ObjectFactory {
	
	private static Caller caller;
	
	
	public static DataRepository getDataRepository() {
		return DataRepository.getInstance();
	}
	
	public static UserService getUserService() {
		return UserServiceImpl.getInstance();
	}
	
	public static SubscriptionService getSubscriptionService() {
		return SubscriptionServiceImpl.getInstance();
	}
	
	public static NotificationService getNotificationService() {
		return NotificationServiceImpl.getInstance();
	}
	
	public static SenderService getSenderService() {
		return SenderServiceImpl.getInstance();
	}
	
	public static AppFacade getAppFacade() {
		return AppFacadeImpl.getInstance();
	}
	
//	public static SendByEmail getSendByEmail() {
//		return SendByEmail.getInstance();
//	}
//	
//	public static SendBySms getSendBySMS() {
//		return SendBySms.getInstance();
//	}
	
	public static SenderStrategy getSenderStrategy(String type) {
		type = type.substring(0,1).toUpperCase()+type.substring(1);
		try {
			Class<?> SenderStrategyClass = Class.forName("notification_app.service.SendBy"+type);
			Method getInstanceMethod = SenderStrategyClass.getMethod("getInstance");
			return (SenderStrategy) getInstanceMethod.invoke(null);
		} catch(ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
//			System.out.println(ex.getMessage());
			return null;
		}
		
	}
	
	synchronized public static Caller getCaller() {
		if(caller==null) {
			caller = new Caller();
		}
		return caller;
	}
	
	
	
}
