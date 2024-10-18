
package notification.thirdparty;

public class PostalMailAPI {
    public void sendPostalMail(String name, String address, String city,
                               String postalCode, String country, String content) {
        System.out.println("Sending Postal Mail:");
        System.out.println("To: " + name);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("Postal Code: " + postalCode);
        System.out.println("Country: " + country);
        System.out.println("Content: " + content);
    }
}