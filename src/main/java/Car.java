public class Car {
    String brand;
    String vehicleRegistrationPlate;

    Car(final String brand, final String vehicleRegistrationPlate) {
        this.brand = brand;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
    }

    void printInfo() {
        System.out.println("Brand: " + brand + " Vehicle Registration Plate: " + vehicleRegistrationPlate);
    }
}
