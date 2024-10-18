import notification.adapters.*;
import notification.interfaces.*;
import notification.models.*;
import notification.thirdparty.*;

public class Main {
    public static void main(String[] args) {
        INotifier emailNotifier = new EmailNotification();
        INotifier smsNotifier = new SMSNotification();

        PostalMailAPI postalMailAPI = new PostalMailAPI();
        INotifier postalMailNotifier = new PostalMailAdapter(postalMailAPI);

        // Send notifications
        emailNotifier.sendNotification("user@example.com", "Hello via email!");
        smsNotifier.sendNotification("+1234567890", "Hello via SMS!");

        // For postal mail, we need to provide recipient details
        String postalRecipient = "John Doe|123 Main St|New York|10001|USA";
        postalMailNotifier.sendNotification(postalRecipient, "Hello via postal mail!");
    }
}