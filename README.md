# Notification App

![Java](https://img.shields.io/badge/Language-Java-blue)
![Design Patterns](https://img.shields.io/badge/Design%20Patterns-Multiple-orange)
![License](https://img.shields.io/badge/License-Free-lightgrey)

## 1. Overview
**Notification App** is a console-based Java application that simulates sending mass notifications to subscribed users.  
It demonstrates the use of multiple design patterns, ensuring clean, maintainable, and extensible code.

## 2. Features
- Send notifications via Email, SMS, Call, and Telegram.
- Supports subscription management for users.
- Demonstrates multiple design patterns: Singleton, Observer, Facade, Adapter, Factory, and Strategy.
- Can run as a standalone JAR or inside Docker.

## 3. Running the Application
### 3.0 Clone the repository and move to project directory
```bash
git clone https://github.com/BhardwajNkl/design-pattern-notification-app.git

cd design-pattern-notification-app
```
### 3.1 Run Using JAR
Run the JAR file located in the `JAR` folder:
```bash
java -jar JAR/notification_app.jar
```

### 3.2 Run Using Docker

1. **Build the Docker image** using the provided Dockerfile:
```bash
docker build -t notification-app .
```
2. **Run the container in interactive mode**
```bash
docker run -it notification-app
```
> **Note:** The interactive mode allows you to provide input throughout the application's execution.

## 4. Design Patterns Used
### 4.1 Singleton Pattern
- `DataRepository`
- `AppFacadeImpl`
- `NotificationServiceImpl`
- `SendByEmail`, `SendBySMS`, `SendByCall`, `SendByTelegram`
- `SenderServiceImpl`
- `SubscriptionServiceImpl`
- `UserServiceImpl`

### 4.2 Observer Pattern
- `Subject` and `Observer` interfaces
- `NotificationServiceImpl` as Subject (Observable)
- `SenderServiceImpl` as Observer

### 4.3 Facade Pattern
- `AppFacadeImpl` acts as a unified interface simplifying usage

### 4.4 Adapter Pattern
- `Caller` and `SendByCall`
- `SendByCall` acts as an adapter for the `Caller` class

### 4.5 Factory Pattern
- `SenderStrategyFactory` creates sender strategy instances dynamically

### 4.6 Strategy Pattern
- `SenderStrategy` interface
- Implementations: `SendByEmail`, `SendBySMS`, `SendByCall`, `SendByTelegram`

## 5. License
This project is completely open. You can **access, use, learn, and share** it freely without any restrictions.
