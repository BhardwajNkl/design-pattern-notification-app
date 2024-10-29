package notification_app.factory;

import java.util.HashMap;
import java.util.Map;

import notification_app.mock_db.DataRepository;
import notification_app.service.AppFacade;
import notification_app.service.AppFacadeImpl;
import notification_app.service.NotificationService;
import notification_app.service.NotificationServiceImpl;
import notification_app.service.SenderService;
import notification_app.service.SenderServiceImpl;
import notification_app.service.SubscriptionService;
import notification_app.service.SubscriptionServiceImpl;
import notification_app.service.UserService;
import notification_app.service.UserServiceImpl;

/**
 * This class serves as a central object factory for our application.
 * It holds all the necessary objects that any component of the application may require.
 * 
 * This class ensures that any class registered here, a singleton instance[However in our application, most classes are singleton themselves] of that class can be fetched any time.
 * So this is helpful in dependency injection, as we can, in the constructor of any class, ask for it's dependencies from this factory.
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */

public class AppContext {
	
	/*
	 * A map with class names as key and an instance of respective class as value.
	 */
	private static Map<Class<?>, Object> map = new HashMap<>();
	
	/**
	 * Initialize the map with the essential objects.
	 */
	public static void initialize() {
		getObject(AppFacade.class);
		getObject(DataRepository.class);
		getObject(UserService.class);
		getObject(NotificationService.class);
		getObject(SenderService.class);
		getObject(SubscriptionService.class);

	}
	
	/**
	 * @param type The name of the class whose instance is required.
	 * @return An object of the given class.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObject(Class<T> type){
		if(!map.containsKey(type)) {
			if(type == DataRepository.class) {
				map.put(DataRepository.class, DataRepository.getInstance());
			}
			if(type == UserService.class) {
				map.put(UserService.class, UserServiceImpl.getInstance());
			}
			if(type == SubscriptionService.class) {
				map.put(SubscriptionService.class, SubscriptionServiceImpl.getInstance());
			}
			if(type == NotificationService.class) {
				map.put(NotificationService.class, NotificationServiceImpl.getInstance());
			}
			if(type == SenderService.class) {
				map.put(SenderService.class, SenderServiceImpl.getInstance());
			}
			if(type == AppFacade.class) {
				map.put(AppFacade.class, AppFacadeImpl.getInstance());
			}
		}
		
		return (T) map.get(type);
	}
	
	
}
