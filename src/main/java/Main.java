public class Main {
    public static void main(String[] args) {

       Car car = new Car();
       car.vehicleRegistrationPlate = "PK1234";
       car.brand = "Volvo";

       Person person = new Person();
       person.firstName = "Janusz";
       person.lastName = "Cebula";
       person.birthYear = 1968;

        System.out.println(car.brand + " " + car.vehicleRegistrationPlate);
        System.out.println(person.firstName + " " + person.lastName + " " + person.birthYear);
    }
}
