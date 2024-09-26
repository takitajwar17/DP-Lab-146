class Rider:
    def __init__(self, name):
        self.name = name
        self.rating = None
        self.preferred_payment_method = None

    def request_ride(self, pickup_location, dropoff_location, ride_type):
        # Now returns ride request details instead of creating a Trip instance
        print(f"{self.name} requested a {ride_type} ride from {pickup_location} to {dropoff_location}.")
        return (pickup_location, dropoff_location, ride_type)

    def rate_driver(self, driver, rating):
        driver.rating = rating
        print(f"{self.name} rated {driver.name} with {rating} stars.")

    def set_payment_method(self, payment_method):
        self.preferred_payment_method = payment_method
        print(f"{self.name}'s payment method has been updated to {type(payment_method).__name__}.")
