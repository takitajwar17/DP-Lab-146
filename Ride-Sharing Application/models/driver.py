from services.notification_service import NotificationService
from models.trip import Trip


class Driver:
    def __init__(self, name, location, vehicle_type):
        self.name = name
        self.location = location
        self.vehicle_type = vehicle_type
        self.rating = None
        self.available = True

    def accept_ride(self, rider, pickup_location, dropoff_location, ride_type):
        if self.available:
            self.available = False
            print(f"{self.name} has accepted the ride.")
            # Creating a Trip instance here
            trip = Trip(rider, pickup_location, dropoff_location, ride_type)
            trip.assign_driver(self)
            return trip
        else:
            print(f"{self.name} is not available for the ride.")
            return None

    def update_location(self, new_location):
        self.location = new_location
        NotificationService.send_notification(f"Driver location updated to {self.location}")

    def rate_rider(self, rider, rating):
        rider.rating = rating
        print(f"{self.name} rated {rider.name} with {rating} stars.")
