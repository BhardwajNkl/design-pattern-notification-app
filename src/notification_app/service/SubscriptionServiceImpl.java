package notification_app.service;

import java.util.List;

import notification_app.mock_db.DataRepository;

public class SubscriptionServiceImpl implements SubscriptionService {

	private final DataRepository repository;
	
	public SubscriptionServiceImpl(DataRepository repository) {
		this.repository = repository;
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
