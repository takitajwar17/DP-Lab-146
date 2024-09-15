class RideType:
    @staticmethod
    def create_ride(ride_type):
        if ride_type == "Carpool":
            return CarpoolRide()
        elif ride_type == "Luxury":
            return LuxuryRide()
        elif ride_type == "Bike":
            return BikeRide()

class CarpoolRide:
    def get_fare_multiplier(self):
        return 0.8

class LuxuryRide:
    def get_fare_multiplier(self):
        return 2.0

class BikeRide:
    def get_fare_multiplier(self):
        return 0.5
