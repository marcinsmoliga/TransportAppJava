import com.example.model.Car;
import com.example.model.Person;

import io.DataReader;

public class Main {
	public static void main(String[] args) {
		DataReader dataReader = new DataReader();

		Car[] cars = new Car[100];
		cars[0] = dataReader.createCar();

		Person[] people = new Person[100];
		people[0] = dataReader.createPerson();

		cars[0].printInfo();
		people[0].printInfo();
	}
}
