class NotificationService:
    @staticmethod
    def send_notification(message, method="In-App"):
        if method == "SMS":
            print(f"Sending SMS: {message}")
        elif method == "Email":
            print(f"Sending Email: {message}")
        else:
            print(f"In-App Notification: {message}")
