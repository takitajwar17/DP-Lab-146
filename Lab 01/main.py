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

# Request a ride
trip = rider.request_ride("Farmgate", "Airport", "Luxury")

# Driver accepts the ride
driver.accept_ride(trip)

# Complete the trip and payment
trip.complete_trip()

# Rating the driver and rider
rider.rate_driver(driver, 5)
driver.rate_rider(rider, 4)
