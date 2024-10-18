package notification.models;

import notification.interfaces.INotifier;

public class EmailNotification implements INotifier {
    @Override
    public void sendNotification(String email, String message) {
        System.out.println("Sending Email to: " + email);
        System.out.println("Message: " + message);
    }
}