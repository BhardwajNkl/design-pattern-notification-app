package notification_app.factory;

public class ObjectFactoryImpl implements ObjectFactory {

	@Override
	public Object getObject(String type) {
		switch (type) {
		case "DataRepository": {

		}
		
		case "UserService": {

		}
		
		case "SubscriptionService": {

		}
		
		case "NotificationServiceImpl": {

		}
		
		case "SenderServiceImpl": {

		}
		
		case "AppFacadeServiceImpl": {

		}
		
		case "SendByEmail": {

		}
		
		case "SendBySMS": {

		}
		
		default: {
			return null;
		}
		}
	}

}
