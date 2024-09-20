from models.driver import Driver
from models.rider import Rider
from models.payment_method import CreditCard, PayPal, DigitalWallet

# Sample
print("\nWelcome to AmioJabo!\n")

# Creating Rider and Driver
rider = Rider("Adolt Hitler")
driver = Driver("Sheikh Hasina", "Boardbazar", "Luxury")

# Setting rider's preferred payment method
rider.preferred_payment_method = CreditCard()


# Requesting a ride
trip = rider.request_ride("Farmgate", "Airport", "Luxury")

# Driver accepting the ride
driver.accept_ride(trip)

# Asking the user if they want to change the payment method
credit_card = CreditCard()
paypal = PayPal()
digital_wallet = DigitalWallet()

change_payment = input("Do you want to change the payment method? (yes/no) ").lower()
if change_payment == 'yes':
    print("Select a payment method: 1. Credit Card, 2. PayPal, 3. Digital Wallet")
    choice = input("Enter choice (1, 2, or 3): ")
    if choice == '1':
        rider.set_payment_method(credit_card)
    elif choice == '2':
        rider.set_payment_method(paypal)
    elif choice == '3':
        rider.set_payment_method(digital_wallet)
    else:
        print("Invalid choice, proceeding with the default payment method.")
else:
    print("Proceeding with the default payment method.")


# Completing the trip and payment
trip.complete_trip()

# Rating the driver and rider
rider.rate_driver(driver, 5)
driver.rate_rider(rider, 4)
