package notification_app.service;

import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.RED_BOLD;

import java.util.List;

import notification_app.factory.AppContext;
import notification_app.mock_db.DataRepository;
import notification_app.mock_db.model.User;

/**
 * This class provides methods related with user management.
 * @author nikhilbhardwaj01
 *
 */
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

	@Override
	public void addUserAvailabilityChannel(String userName, String channelName, String channelContactValue) {
		User user = repository.getUserByName(userName);
		if(user!=null) {
			user.addAvailabilityChannel(channelName, channelContactValue);
		} else {
			System.out.println(RED_BOLD + "User does not exist!" + DEFAULT);
		}
	}
}
