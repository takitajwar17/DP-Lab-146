class PaymentMethod:
    def process_payment(self, amount):
        pass
    def get_discount(self):
        return 0.0

class CreditCard(PaymentMethod):
    def process_payment(self, amount):
        print(f"Processing credit card payment of ${amount:.2f}.")

    def get_discount(self):
        return 0.03  # 3% discount

class PayPal(PaymentMethod):
    def process_payment(self, amount):
        print(f"Processing PayPal payment of ${amount:.2f}.")

    def get_discount(self):
        return 0.02  # 2% discount

class DigitalWallet(PaymentMethod):
    def process_payment(self, amount):
        print(f"Processing digital wallet payment of ${amount:.2f}.")

    def get_discount(self):
        return 0.0  # No discount
