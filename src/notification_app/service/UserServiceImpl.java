package notification_app.service;

import java.util.List;

import notification_app.mock_db.DataRepository;
import notification_app.mock_db.User;

public class UserServiceImpl implements UserService {
	private final DataRepository repository;
	
	public UserServiceImpl(DataRepository repository) {
		this.repository = repository;
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
