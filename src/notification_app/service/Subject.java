package notification_app.service;

public interface Subject {
	void register(Observer observer);
	void unRegister(Observer observer);
	void updateObservers();
}
