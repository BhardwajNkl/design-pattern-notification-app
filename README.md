# Notification App
## 1. Overview
A console based core java application. The application simulates sending mass notifications to users who have subscribed.
Different design patterns have been utilized in this application.

## 2. Running the application
- Step 1: Download the project
- Step 2: Run the JAR located inside JAR folder as below:

```bash
java -jar JAR/notification_app.jar
```

## 3. Design patterns used:
### Singleton pattern
- DataRepository
- AppFacadeImpl
- NotificationServiceImpl
- SendByEmail, SendBySMS, SendByCall, SendByTelegram
- SenderServiceImpl
- SubscriptionServiceImpl
- UserServiceImpl

### Observer pattern
- Subject interface and Observer interface.
- NotificationServiceImpl as an implementation of subject(observable).
- SenderServiceImpl as an implementation of observer.

### Facade pattern
- AppFacadeImpl

### Adapter Pattern
- Caller and SendByCall
- SendByCall is the adapter class for the Caller class.

### Factory pattern
- SenderStrategyFactory

### Strategy pattern
- SenderStrategy Interface
- Through the implementation classes SendByEmail, SendBySms, etc.
