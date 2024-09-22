package notification_app.service;

import java.util.List;

import notification_app.factory.AppContext;
import notification_app.mock_db.DataRepository;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static SubscriptionServiceImpl INSTANCE;

	private final DataRepository repository;
	
	public SubscriptionServiceImpl() {
		this.repository = AppContext.getObject(DataRepository.class);
	}
	
	synchronized public static SubscriptionServiceImpl getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SubscriptionServiceImpl();
		}
		
		return INSTANCE;
	}
	
	@Override
	public void addSubscriber(String name) {
		repository.addSubscriber(name);
	}
	
	@Override
	public void deleteSubscriber(String name) {
		repository.deleteSubscriber(name);
	}
	
	@Override
	public List<String> getSubscribers(){
		return repository.getSubscribers();
	}
}
