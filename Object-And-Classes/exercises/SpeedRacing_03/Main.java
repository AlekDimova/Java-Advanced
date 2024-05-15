package objectAndClasses.exercises.SpeedRacing_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 1; i <= countCars; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            //"{Model} {FuelAmount} {FuelCostFor1km}".split(" ") -> ["{Model}", "{FuelAmount}", "{FuelCostFor1km}"]
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double consumption = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, consumption);
            //listOfCars.add(car);
            cars.put(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            //command = "Drive {CarModel} {amountOfKm}".split(" ") -> ["Drive", "{CarModel}", "{amountOfKm}"]
            String carModelToDrive = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

            Car carToDrive = cars.get(carModelToDrive);

            if (!carToDrive.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }

        for (Car car : cars.values()) {
            //"{Model} {fuelAmount} {distanceTraveled}"
            System.out.println(car.toString());
        }
    }
}
