package notification_app.service;

import java.util.List;

import notification_app.factory.ObjectFactory;
import notification_app.mock_db.DataRepository;
import notification_app.mock_db.User;

public class UserServiceImpl implements UserService {
	
	private static UserServiceImpl INSTANCE;
	
	private DataRepository repository;
	
	private UserServiceImpl() {
		this.repository = ObjectFactory.getDataRepository();
	}
	
	synchronized public static UserServiceImpl getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new UserServiceImpl();
		}
		
		return INSTANCE;
	}
	
	@Override
	public boolean addUser(User user) {
		repository.addUser(user);
		return true;
	}
	
	@Override
	public boolean deleteUser(String name) {
		repository.deleteUser(name);
		return true;
	}
	
	@Override
	public List<User> getUsers(){
		return repository.getUsers();
	}
}
