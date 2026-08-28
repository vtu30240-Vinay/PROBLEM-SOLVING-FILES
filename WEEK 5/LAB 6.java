import java.util.*;

public class Main {

    static class Ride {
        String rider, driver, pickup, destination;
        double fare;

        Ride(String rider, String driver, String pickup,
             String destination, double fare) {
            this.rider = rider;
            this.driver = driver;
            this.pickup = pickup;
            this.destination = destination;
            this.fare = fare;
        }

        void display() {
            System.out.println("\n--- Ride Details ---");
            System.out.println("Rider: " + rider);
            System.out.println("Driver: " + driver);
            System.out.println("From: " + pickup);
            System.out.println("To: " + destination);
            System.out.println("Fare: Rs." + fare);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rider Name: ");
        String rider = sc.nextLine();

        System.out.print("Driver Name: ");
        String driver = sc.nextLine();

        System.out.print("Pickup: ");
        String pickup = sc.nextLine();

        System.out.print("Destination: ");
        String destination = sc.nextLine();

        System.out.print("Distance (km): ");
        double distance = sc.nextDouble();

        double fare = 50 + distance * 15;

        Ride ride = new Ride(rider, driver, pickup, destination, fare);
        ride.display();

        sc.close();
    }
}

Rider Name: VINAY
Driver Name: SRIRAM
Pickup: AVADI
Destination: VELTECH JUNCTION
Distance (km): 7

--- Ride Details ---
Rider: VINAY
Driver: SRIRAM
From: AVADI
To: VELTECH JUNCTION
Fare: Rs.155.0

=== Code Execution Successful ===
