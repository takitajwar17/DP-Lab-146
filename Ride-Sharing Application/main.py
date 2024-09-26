from models.driver import Driver
from models.rider import Rider
from models.payment_method import PaymentMethodFactory

# Sample
print("\nWelcome to AmioJabo!\n")

# Creating Rider and Driver
rider = Rider("Adolf Hitler")
driver = Driver("Sheikh Hasina", "Boardbazar", "Luxury")

# Setting rider's default preferred payment method using the factory
rider.preferred_payment_method = PaymentMethodFactory.get_payment_method("CreditCard")

# Requesting a ride details
pickup_location, dropoff_location, ride_type = rider.request_ride("Farmgate", "Airport", "Luxury")

# Driver accepting the ride and creating the Trip
trip = driver.accept_ride(rider, pickup_location, dropoff_location, ride_type)

if trip:
    # Asking the user if they want to change the payment method
    change_payment = input("Do you want to change the payment method? (yes/no) ").lower()
    if change_payment == 'yes' or change_payment == 'y':
        payment_options = {
            '1': "CreditCard",
            '2': "PayPal",
            '3': "DigitalWallet"
        }
        print("Select a payment method: 1. Credit Card, 2. PayPal, 3. Digital Wallet")
        choice = input("Enter choice (1, 2, or 3): ")
        method = payment_options.get(choice)
        if method:
            rider.set_payment_method(PaymentMethodFactory.get_payment_method(method))
        else:
            print("Invalid choice, proceeding with the default payment method.")
    else:
        print("Proceeding with the default payment method.")

    # Completing the trip and payment
    trip.complete_trip()

    # Rating the driver and rider
    rider.rate_driver(driver, 5)
    driver.rate_rider(rider, 4)
else:
    print("No trip was initiated as the driver was not available.")
