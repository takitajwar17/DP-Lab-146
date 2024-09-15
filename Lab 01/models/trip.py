from models.ride_type import RideType
from services.notification_service import NotificationService
from services.payment_service import PaymentService

class Trip:
    def __init__(self, rider, pickup_location, dropoff_location, ride_type):
        self.rider = rider
        self.pickup_location = pickup_location
        self.dropoff_location = dropoff_location
        self.ride_type = RideType.create_ride(ride_type)
        self.driver = None
        self.fare = self.calculate_fare()
        self.status = "Pending"

    def assign_driver(self, driver):
        self.driver = driver
        self.status = "Driver Assigned"
        NotificationService.send_notification(f"Driver {driver.name} has been assigned to your ride.")

    def calculate_fare(self):
        base_fare = 10.0  # Base fare value
        distance = 5.0  # Placeholder
        fare_multiplier = self.ride_type.get_fare_multiplier()
        return base_fare * distance * fare_multiplier

    def complete_trip(self):
        self.status = "Completed"
        PaymentService.process_payment(self.rider.preferred_payment_method, self.fare)
        NotificationService.send_notification(f"Trip completed. Fare: ${self.fare}")
