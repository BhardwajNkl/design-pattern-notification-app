package notification_app.mock_db.model;

import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.RED_BOLD;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a model for users.
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */
public class User {
	
	private String name;
	
	/**
	 * A map with user availability channels(such as email, telegram) as key and the respective contact info(such as raju@gmail.com) as value.
	 */
	private Map<String, String> userChannelMap;
	
	public User(String name, String email, String smsNumber) {
		this.name=name;
		userChannelMap = new HashMap<>();
		if(email!=null) userChannelMap.put("email", email);
		if(smsNumber!=null) userChannelMap.put("sms", smsNumber);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addAvailabilityChannel(String channelName, String contactValue) {
		if(!userChannelMap.containsKey(channelName)) {
			userChannelMap.put(channelName, contactValue);
		}
		else {
			System.out.println(RED_BOLD + "User has already added this availability channel!" + DEFAULT);
		}
	}
	
	public Map<String, String> getUserChannelMap(){
		return userChannelMap;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", userChannelMap=" + userChannelMap + "]";
	}
	
	
	
}
