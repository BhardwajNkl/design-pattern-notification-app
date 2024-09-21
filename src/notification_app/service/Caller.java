package notification_app.service;

// this provides a call channel, you can send messages by call.
// we need an adapter class for this to be used in our system[to be used inside sender service]
public class Caller {
	public void call(String mobileNumber, String message) {
		System.out.println("Calling to: "+mobileNumber);
	}
}
