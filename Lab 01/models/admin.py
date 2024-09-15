class Admin:
    def __init__(self, name):
        self.name = name

    def manage_driver(self, driver, action):
        if action == "deactivate":
            driver.available = False
            print(f"{driver.name} has been deactivated.")
        elif action == "activate":
            driver.available = True
            print(f"{driver.name} has been activated.")

    def view_trip_history(self, trips):
        for trip in trips:
            print(f"Trip: {trip.pickup_location} to {trip.dropoff_location}, Status: {trip.status}")
