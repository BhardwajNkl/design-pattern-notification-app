package notification_app;

import static notification_app.util.ConsoleColors.BLUE_BOLD;
import static notification_app.util.ConsoleColors.DEFAULT;
import static notification_app.util.ConsoleColors.GREEN_BOLD;
import static notification_app.util.ConsoleColors.PURPLE_BOLD;
import static notification_app.util.ConsoleColors.RED_BOLD;
import static notification_app.util.ConsoleColors.RESET;
import static notification_app.util.ConsoleColors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import notification_app.factory.AppContext;
import notification_app.mock_db.model.User;
import notification_app.service.AppFacade;public class Main {
	public static void main(String args[]) throws IOException {
		
		AppContext.initialize();

		AppFacade appFacade = AppContext.getObject(AppFacade.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String command = "";
		System.out.print(DEFAULT);

		showMenu(); // only shown in the beginning. latter only when user enters invalid commands or
					// when the user needs help.

		do {
			System.out.print(PURPLE_BOLD + "command " + YELLOW_BOLD+"$ ");
			input = br.readLine();
			System.out.print(DEFAULT);
			
			String[] inputTokens = sanitizeInputTokens(input);

			command = inputTokens[0];

			switch (command) {
			case "add_user": {
				// for this command, the input is like: add_user "name" "email" "smsNumber"
				if (inputTokens.length < 2) {
					System.out.println(
							RED_BOLD + "Incorrect command syntax: Please pass the name of the user." + DEFAULT);
					showMenu();
				} else {
					String userName = inputTokens[1];
					String userEmail = null;
					String userSmsNumber = null;
					try {
						userEmail = inputTokens[2];
						userSmsNumber = inputTokens[3];
					} catch(Exception e) {
						
					}
					appFacade.addUser(new User(userName, userEmail, userSmsNumber));
				}
				break;
			}

			case "delete_user": {
				// for this command, the input is like: delete_user "name"
				if (inputTokens.length < 2) {
					System.out.println(
							RED_BOLD + "Incorrect command syntax: Please pass the name of the user." + DEFAULT);
					showMenu();
				} else {
					String userName = inputTokens[1];
					appFacade.deleteUser(userName);
				}
				break;
			}

			case "add_subscriber": {
				// for this command, the input is like: add_subscriber "user_name"
				if (inputTokens.length < 2) {
					System.out.println(
							RED_BOLD + "Incorrect command syntax: Please pass the name of the subscriber." + DEFAULT);
					showMenu();
				} else {
					String subscriberName = inputTokens[1];
					appFacade.addSubscriber(subscriberName);
				}
				break;
			}

			case "delete_subscriber": {
				// for this command, the 2nd token of input is the name of subscriber/user
				if (inputTokens.length < 2) {
					System.out.println(
							RED_BOLD + "Incorrect command syntax: Please pass the name of the subscriber." + DEFAULT);
					showMenu();
				} else {
					String subscriberName = inputTokens[1];
					appFacade.deleteSubscriber(subscriberName);
				}
				break;
			}

			case "get_users": {
				List<User> users = appFacade.getUsers();
				System.out.print(GREEN_BOLD);
				users.forEach(System.out::println);
				System.out.print(DEFAULT);
				break;
			}

			case "get_subscribers": {
				List<String> subscribers = appFacade.getSubscribers();
				System.out.print(GREEN_BOLD);
				subscribers.forEach(System.out::println);
				System.out.print(DEFAULT);
				break;
			}

			case "add_notification": {
				if(inputTokens.length<4) {
					System.out.println(
							RED_BOLD + "Incorrect command syntax: Please pass all arguments." + DEFAULT);
					showMenu();
				} else {
					appFacade.addNotification(inputTokens[1], inputTokens[2], inputTokens[3]);
				}
				break;
			}
			
			case "add_user_channel": {
				if(inputTokens.length<4) {
					System.out.println(
							RED_BOLD + "Incorrect command syntax: Please pass all arguments." + DEFAULT);
					showMenu();
				} else {
					appFacade.addUserAvailabilityChannel(inputTokens[1], inputTokens[2], inputTokens[3]);
				}
				break;
			}

			case "exit": {
				System.out.println(BLUE_BOLD + "Okay, Bye!" + RESET);
				break;
			}

			case "menu": {
				showMenu();
				break;
			}

			default:
				System.out.println(RED_BOLD + "Invalid command: " + command + DEFAULT);
				showMenu();
			
			}

		} while (!command.equalsIgnoreCase("exit"));
		
		System.out.print(RESET);
	}
	
	private static void showMenu() {
		System.out.println("|===========================================================================================|");
		System.out.println("| Enter your command. Syntax is as below.                                                   |");
		System.out.println("| 1. To add user: "+YELLOW_BOLD+"add_user <name> <email_optional> <sms_number_optional>"+DEFAULT+"                    |");
		System.out.println("| 2. To delete user: "+YELLOW_BOLD+"delete_user <name>"+DEFAULT+"                                                     |");
		System.out.println("| 3. To add subscriber: "+YELLOW_BOLD+"add_subscriber <user's name>"+DEFAULT+"                                        |");
		System.out.println("| 4. To delete subscriber: "+YELLOW_BOLD+"delete_subscriber <user's name>"+DEFAULT+"                                  |");
		System.out.println("| 5. To add notification: "+YELLOW_BOLD+"add_notification <subject> <message> <channel>"+DEFAULT+"                    |");
		System.out.println("| 6. To get list of users: "+YELLOW_BOLD+"get_users"+DEFAULT+"                                                        |");
		System.out.println("| 7. To get list of subscribers: "+YELLOW_BOLD+"get_subscribers"+DEFAULT+"                                            |");
		System.out.println("| 8. To add new contact channel for a user: "+YELLOW_BOLD+"add_user_channel <user's name> <channel> <value>"+DEFAULT+"|");
		System.out.println("| 9. To Exit: "+YELLOW_BOLD+"exit"+DEFAULT+"                                                                          |");
		System.out.println("| 10.To get this menu: "+YELLOW_BOLD+"menu"+DEFAULT+"                                                                 |");
		System.out.println("|===========================================================================================|");
	}
	
	private static String[] sanitizeInputTokens(String input) {
		
		input = input.trim().toLowerCase();
		String[] inputTokens = input.split("\"");
		
		List<String> updatedTokens = new ArrayList<>();
		
		// the first word is command so no need to do anything on that. The arguments are inside double quotes so we need to remove that.
		updatedTokens.add(inputTokens[0].trim());
		
		if(inputTokens.length>1) {
			for(int i=1; i<inputTokens.length;i++) {
				String token = inputTokens[i].trim();
				if(token.length()==0) continue;
				updatedTokens.add(token);
			}
		}
		
		return updatedTokens.toArray(new String[0]);
	}
}
