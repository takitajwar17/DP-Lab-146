from models.trip import Trip

class Rider:
    def __init__(self, name):
        self.name = name
        self.rating = None
        self.preferred_payment_method = None

    def request_ride(self, pickup_location, dropoff_location, ride_type):
        print(f"{self.name} requested a {ride_type} ride from {pickup_location} to {dropoff_location}.")
        # Create a new trip instance of the Trip class
        trip = Trip(self, pickup_location, dropoff_location, ride_type)
        return trip

    def rate_driver(self, driver, rating):
        driver.rating = rating
        print(f"{self.name} rated {driver.name} with {rating} stars.")

    def set_payment_method(self, payment_method):
        self.preferred_payment_method = payment_method
        print(f"{self.name}'s payment method has been updated to {type(payment_method).__name__}.")
