package notification_app.mock_db;

import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.RED_BOLD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import notification_app.mock_db.model.User;

public class DataRepository {
	private static DataRepository INSTANCE;
	
	private List<User> users = new ArrayList<>();
	
	private List<String> subscribers = new ArrayList<>();
	
	private DataRepository() {
		
	}
	
	synchronized static public DataRepository getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new DataRepository();
		}
		
		return INSTANCE;
	}
	
	public void addUser(User user) {
		// check if the user already exists
		boolean userExists = users.stream().anyMatch(u->u.getName().equalsIgnoreCase(user.getName()));
		
		if(userExists) {
			System.out.println(RED_BOLD + "User with same name exists!" + DEFAULT);
			return;
		}
		
		users.add(user);
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public void addSubscriber(String name) {
		// check if user with given name exists
		boolean userExists = users.stream().anyMatch(u->u.getName().equalsIgnoreCase(name));
		if(!userExists) {
			System.out.println(RED_BOLD + "User does not exist!" + DEFAULT);
			return;
		}
		
		// check if the user is already a subscriber
		boolean subscriberExists = subscribers.stream().anyMatch(subs->subs.equalsIgnoreCase(name));
		if(subscriberExists) {
			System.out.println(RED_BOLD + "The user is already a subscriber!" + DEFAULT);
			return;
		}
		
		subscribers.add(name);
	}
	
	public List<String> getSubscribers(){
		return subscribers;
	}

	public void deleteUser(String name) {
		// check if the user exists
		boolean userExists = users.stream().anyMatch(u->u.getName().equalsIgnoreCase(name));
		if(!userExists) {
			System.out.println(RED_BOLD + "User does not exist!" + DEFAULT);
			return;
		}
		
		users = users.stream().filter(user->!user.getName().equals(name)).collect(Collectors.toList());
		
		// remove from subscribers also, in case the user had subscribed.
		subscribers = subscribers.stream().filter(subscriber->!subscriber.equals(name)).collect(Collectors.toList());
	}

	public void deleteSubscriber(String name) {
		// check if the subscriber exists
		boolean subscriberExists = subscribers.stream().anyMatch(subs->subs.equalsIgnoreCase(name));
		if(!subscriberExists) {
			System.out.println(RED_BOLD + "Subscriber does not exist!" + DEFAULT);
			return;
		}
		
		subscribers = subscribers.stream().filter(subscriber->!subscriber.equals(name)).collect(Collectors.toList());
	}
}
