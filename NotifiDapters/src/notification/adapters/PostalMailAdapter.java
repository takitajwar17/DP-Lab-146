// src/notification/adapters/PostalMailAdapter.java
package notification.adapters;

import notification.interfaces.INotifier;
import notification.thirdparty.PostalMailAPI;

public class PostalMailAdapter implements INotifier {
    private PostalMailAPI postalMailAPI;

    public PostalMailAdapter(PostalMailAPI postalMailAPI) {
        this.postalMailAPI = postalMailAPI;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        // Parse recipient string in format: "name|address|city|postalCode|country"
        String[] recipientDetails = recipient.split("\\|");
        if (recipientDetails.length != 5) {
            throw new IllegalArgumentException("Invalid recipient format for postal mail");
        }

        postalMailAPI.sendPostalMail(
                recipientDetails[0], // name
                recipientDetails[1], // address
                recipientDetails[2], // city
                recipientDetails[3], // postal code
                recipientDetails[4], // country
                message
        );
    }
}