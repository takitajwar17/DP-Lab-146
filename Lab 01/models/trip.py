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
        self.fare = self.calculate_initial_fare()
        self.status = "Pending"

    def assign_driver(self, driver):
        self.driver = driver
        self.status = "Driver Assigned"
        NotificationService.send_notification(f"Driver {driver.name} has been assigned to your ride.")

    def calculate_initial_fare(self):
        base_fare = 10.0
        distance = 5.0
        fare_multiplier = self.ride_type.get_fare_multiplier()
        return base_fare * distance * fare_multiplier

    def calculate_fare_after_discount(self):
        discount = self.rider.preferred_payment_method.get_discount()
        return self.calculate_initial_fare() * (1 - discount)

    def complete_trip(self):
        recalculated_fare = self.calculate_fare_after_discount()
        self.status = "Completed"
        PaymentService.process_payment(self.rider.preferred_payment_method, recalculated_fare)
        NotificationService.send_notification(f"Trip completed. Fare: ${recalculated_fare:.2f}")
        self.driver.update_location(self.dropoff_location)
