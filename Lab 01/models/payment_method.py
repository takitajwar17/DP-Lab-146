class PaymentMethod:
    def process_payment(self, amount):
        pass

class CreditCard(PaymentMethod):
    def process_payment(self, amount):
        print(f"Processing credit card payment of ${amount}.")

class PayPal(PaymentMethod):
    def process_payment(self, amount):
        print(f"Processing PayPal payment of ${amount}.")

class DigitalWallet(PaymentMethod):
    def process_payment(self, amount):
        print(f"Processing digital wallet payment of ${amount}.")
