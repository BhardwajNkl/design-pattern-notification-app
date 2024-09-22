package notification_app.mock_db.model;

public class Notification {
	
	private String subject;
	private String message;
	private String channel;
	
	public Notification(String subject, String message, String channel) {
		super();
		this.subject = subject;
		this.message = message;
		this.channel = channel;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "Message [subject=" + subject + ", message=" + message + ", channel=" + channel + "]";
	}
	
	
}
