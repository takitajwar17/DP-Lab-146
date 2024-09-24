# Lab 01: AmioJabo-Ride-Sharing-Application

## 1. **Project Overview**

This Python-based Ride-Sharing Application is designed to model the core functionalities of a ride-sharing platform. The system allows users to book different types of rides (e.g., Carpool, Luxury, Bike), and drivers can accept the requests. The application supports payment processing, a rating system, and notifications, while also providing an admin panel for managing drivers and riders.

## 2. **Project Structure**

The project is structured in directories for models, services, and the main execution file. Each class and function is divided based on its responsibility.

### Directory Structure:
```
ride_sharing/
│
├── models/
│   ├── __init__.py
│   ├── driver.py
│   ├── rider.py
│   ├── trip.py
│   ├── payment_method.py
│   ├── ride_type.py
│   └── admin.py
│
├── services/
│   ├── __init__.py
│   ├── notification_service.py
│   └── payment_service.py
│
└── main.py
```

## 3. **Core Components**

### 3.1. **Models**
The core entities are represented as Python classes in the `models` directory.

- **Driver** (`driver.py`): Manages driver attributes (name, location, vehicle type) and behaviors such as accepting rides, updating location, and rating riders.
- **Rider** (`rider.py`): Handles the rider's request for rides, preferred payment method, and rating of drivers.
- **Trip** (`trip.py`): Handles trip-specific details such as pickup/dropoff locations, fare calculation, assigning drivers, and completing trips.
- **RideType** (`ride_type.py`): Defines different ride types (Carpool, Luxury, Bike), each with its own fare multiplier.
- **PaymentMethod** (`payment_method.py`): Abstracts different payment methods and how they process payments (Credit Card, PayPal, Digital Wallet).
- **Admin** (`admin.py`): Provides admin functionality to manage drivers, riders, and trip data.

### 3.2. **Services**
The services directory contains utility classes that handle background tasks such as payments and notifications.

- **NotificationService** (`notification_service.py`): Sends notifications (via SMS, Email, In-App) for events like ride request confirmation, trip start, and completion.
- **PaymentService** (`payment_service.py`): Processes payments by interfacing with different payment methods.


## 4. **Design Patterns**

The project implements the following design patterns to ensure flexibility, maintainability, and scalability:

1. **Factory Pattern**: Used in `RideType` to create different ride types dynamically (Carpool, Luxury, Bike).
2. **Strategy Pattern**: Applied in `PaymentMethod` to allow flexible payment options (Credit Card, PayPal, Digital Wallet).
3. **Dependency Injection**: Injected payment methods into the trip class to handle payments without tightly coupling the `Trip` class to specific payment types.
4. **Service Pattern**: `NotificationService` and `PaymentService` handle non-core functionalities like sending notifications and processing payments.


Thank You!
