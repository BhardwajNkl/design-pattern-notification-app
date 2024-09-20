package notification_app.mock_db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataRepository {
	private List<User> users = new ArrayList<>();
	
	private List<String> subscribers = new ArrayList<>();
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public void addSubscriber(String name) {
		// check if user with given name exists
		this.subscribers.add(name);
	}
	
	public List<String> getSubscribers(){
		return this.subscribers;
	}

	public void deleteUser(String name) {
		this.users = this.users.stream().filter(user->!user.getName().equals(name)).collect(Collectors.toList());
		// remove from subscribers also, if the user had subscribed.
		this.deleteSubscriber(name);
	}

	public void deleteSubscriber(String name) {
		this.subscribers = this.subscribers.stream().filter(subscriber->!subscriber.equals(name)).collect(Collectors.toList());
	}
}
