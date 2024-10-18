package notification.models;

import notification.interfaces.INotifier;

public class SMSNotification implements INotifier {
    @Override
    public void sendNotification(String phoneNumber, String message) {
        System.out.println("Sending SMS to: " + phoneNumber);
        System.out.println("Message: " + message);
    }
}