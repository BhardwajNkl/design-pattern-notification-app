package notification_app.factory;

import notification_app.mock_db.DataRepository;
import notification_app.service.AppFacade;
import notification_app.service.AppFacadeImpl;
import notification_app.service.NotificationService;
import notification_app.service.NotificationServiceImpl;
import notification_app.service.SendByEmail;
import notification_app.service.SendBySMS;
import notification_app.service.SenderService;
import notification_app.service.SenderServiceImpl;
import notification_app.service.SubscriptionService;
import notification_app.service.SubscriptionServiceImpl;
import notification_app.service.UserService;
import notification_app.service.UserServiceImpl;

public class ObjectFactory {
	
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
	
	public static SendByEmail getSendByEmail() {
		return SendByEmail.getInstance();
	}
	
	public static SendBySMS getSendBySMS() {
		return SendBySMS.getInstance();
	}
}
