package notification_app;

import static notification_app.util.ConsoleColors.BLUE_BOLD;

import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.GREEN_BOLD;
import static notification_app.util.ConsoleColors.RED_BOLD;
import static notification_app.util.ConsoleColors.RESET;
import static notification_app.util.ConsoleColors.YELLOW_BOLD;
import static notification_app.util.ConsoleColors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import notification_app.factory.ObjectFactory;
import notification_app.mock_db.User;
import notification_app.service.AppFacade;public class Main {
	public static void main(String args[]) throws IOException {
		
		ObjectFactory.getSenderService(); // to get a sender service object in the system. it gets registered with notification service object.
		AppFacade appFacadeImpl = ObjectFactory.getAppFacade();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		String command="";
		System.out.print(DEFAULT);
		
		showMenu(); // only shown in the beginning. latter only when user enters invalid commands or when the user needs help.
		
		do {
			System.out.print(PURPLE_BOLD+"command $ "+YELLOW_BOLD);
			input = br.readLine();
			System.out.print(DEFAULT);
			
			input = input.trim().toLowerCase();
			String[] inputTokens = input.split(" ");
			
			command = inputTokens[0];
			
			switch (command) {
			case "add_user": {
				// for this command, the 2nd token of input is the name of user
				if(inputTokens.length<2) {
					System.out.println(RED_BOLD+"Incorrect command syntax: Please pass the name of the user."+DEFAULT);
					showMenu();
				} else {
					String userName = inputTokens[1];
					appFacadeImpl.addUser(new User(userName));
				}
				break;
			}
			
			case "delete_user": {
				// for this command, the 2nd token of input is the name of user
				if(inputTokens.length<2) {
					System.out.println(RED_BOLD+"Incorrect command syntax: Please pass the name of the user."+DEFAULT);
					showMenu();
				} else {
					String userName = inputTokens[1];
					appFacadeImpl.deleteUser(userName);
				}
				break;
			}
			
			case "add_subscriber": {
				// for this command, the 2nd token of input is the name of subscriber/user
				if(inputTokens.length<2) {
					System.out.println(RED_BOLD+"Incorrect command syntax: Please pass the name of the subscriber."+DEFAULT);
					showMenu();
				} else {
					String subscriberName = inputTokens[1];
					appFacadeImpl.addSubscriber(subscriberName);
				}
				break;
			}
			
			case "delete_subscriber": {
				// for this command, the 2nd token of input is the name of subscriber/user
				if(inputTokens.length<2) {
					System.out.println(RED_BOLD+"Incorrect command syntax: Please pass the name of the subscriber."+DEFAULT);
					showMenu();
				} else {
					String subscriberName = inputTokens[1];
					appFacadeImpl.deleteSubscriber(subscriberName);
				}
				break;
			}
			
			case "get_users": {
				List<User> users = appFacadeImpl.getUsers();
				System.out.print(GREEN_BOLD);
				users.forEach(System.out::println);
				System.out.print(DEFAULT);
				break;
			}
			
			case "get_subscribers": {
				List<String> subscribers = appFacadeImpl.getSubscribers();
				System.out.print(GREEN_BOLD);
				subscribers.forEach(System.out::println);
				System.out.print(DEFAULT);
				break;
			}
			
			case "add_notification": {
				appFacadeImpl.addNotification(inputTokens[1], inputTokens[2], inputTokens[3]);
				break;
			}
			
			case "exit": {
				System.out.println(BLUE_BOLD+"Okay, Bye!"+RESET);
				break;
			}
			
			case "menu": {
				showMenu();
				break;
			}
			
			default:
				System.out.println(RED_BOLD+"Invalid command: " + command+DEFAULT);
				showMenu();
			}
			
		} while(!command.equalsIgnoreCase("exit"));
		System.out.print(RESET);
	}
	
	private static void showMenu() {
		System.out.println("|=======================================================================|");
		System.out.println("| Enter your command. Syntax is as below.                               |");
		System.out.println("| 1. To add user: "+YELLOW_BOLD+"add_user <name>"+DEFAULT+"                                       |");
		System.out.println("| 2. To delete user: "+YELLOW_BOLD+"delete_user <name>"+DEFAULT+"                                 |");
		System.out.println("| 3. To add subscriber: "+YELLOW_BOLD+"add_subscriber <user's name>"+DEFAULT+"                    |");
		System.out.println("| 4. To delete subscriber: "+YELLOW_BOLD+"delete_subscriber <user's name>"+DEFAULT+"              |");
		System.out.println("| 5. To add notification: "+YELLOW_BOLD+"add_notification <subject> <message> <channel>"+DEFAULT+"|");
		System.out.println("| 6. To get list of users: "+YELLOW_BOLD+"get_users"+DEFAULT+"                                    |");
		System.out.println("| 7. To get list of subscribers: "+YELLOW_BOLD+"get_subscribers"+DEFAULT+"                        |");
		System.out.println("| 8. To Exit: "+YELLOW_BOLD+"exit"+DEFAULT+"                                                      |");
		System.out.println("| 9. To get this menu: "+YELLOW_BOLD+"menu"+DEFAULT+"                                             |");
		System.out.println("|=======================================================================|");
	}
}
