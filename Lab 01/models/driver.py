class Driver:
    def __init__(self, name, location, vehicle_type):
        self.name = name
        self.location = location
        self.vehicle_type = vehicle_type
        self.rating = None
        self.available = True

    def accept_ride(self, trip):
        if self.available:
            self.available = False
            print(f"{self.name} has accepted the ride.")
            trip.assign_driver(self)
        else:
            print(f"{self.name} is not available for the ride.")

    def update_location(self, new_location):
        self.location = new_location

    def rate_rider(self, rider, rating):
        rider.rating = rating
        print(f"{self.name} rated {rider.name} with {rating} stars.")
