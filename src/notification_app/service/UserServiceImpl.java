package notification_app.service;

import java.util.List;

import notification_app.factory.AppContext;
import notification_app.mock_db.DataRepository;
import notification_app.mock_db.model.User;

public class UserServiceImpl implements UserService {
	
	private static UserServiceImpl INSTANCE;
	
	private DataRepository repository;
	
	private UserServiceImpl() {
		this.repository = AppContext.getObject(DataRepository.class);
	}
	
	synchronized public static UserServiceImpl getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new UserServiceImpl();
		}
		
		return INSTANCE;
	}
	
	@Override
	public void addUser(User user) {
		repository.addUser(user);
	}
	
	@Override
	public void deleteUser(String name) {
		repository.deleteUser(name);
	}
	
	@Override
	public List<User> getUsers(){
		return repository.getUsers();
	}
}
