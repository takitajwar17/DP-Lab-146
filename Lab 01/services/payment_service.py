class PaymentService:
    @staticmethod
    def process_payment(payment_method, amount):
        payment_method.process_payment(amount)
