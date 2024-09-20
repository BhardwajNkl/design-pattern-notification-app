package notification_app.service;

import java.util.List;

import notification_app.factory.ObjectFactory;
import notification_app.mock_db.DataRepository;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static SubscriptionServiceImpl INSTANCE;

	private final DataRepository repository;
	
	public SubscriptionServiceImpl() {
		this.repository = ObjectFactory.getDataRepository();
	}
	
	synchronized public static SubscriptionServiceImpl getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SubscriptionServiceImpl();
		}
		
		return INSTANCE;
	}
	
	@Override
	public boolean addSubscriber(String name) {
		repository.addSubscriber(name);
		return true;
	}
	
	@Override
	public boolean deleteSubscriber(String name) {
		repository.deleteSubscriber(name);
		return true;
	}
	
	@Override
	public List<String> getSubscribers(){
		return repository.getSubscribers();
	}
}
