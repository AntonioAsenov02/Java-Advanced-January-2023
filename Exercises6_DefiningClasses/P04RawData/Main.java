package Exercises6_DefiningClasses.P04RawData;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < n ; i++) {

            String [] parameters = scanner.nextLine().split("\\s+");

            String carModel = parameters[0];
            int engineSpeed = Integer.parseInt(parameters[1]);
            int enginePower = Integer.parseInt(parameters[2]);
            int cargoWeight = Integer.parseInt(parameters[3]);
            String cargoType = parameters[4];
            double tirePressure1 = Double.parseDouble(parameters[5]);
            int tireAge1 = Integer.parseInt(parameters[6]);
            Tire tire = new Tire(tirePressure1,tireAge1);
            tires.add(tire);
            double tirePressure2 = Double.parseDouble(parameters[7]);
            int tireAge2 = Integer.parseInt(parameters[8]);
            Tire tire2 = new Tire(tirePressure2,tireAge2);
            tires.add(tire2);
            double tirePressure3 = Double.parseDouble(parameters[9]);
            int tireAge3 = Integer.parseInt(parameters[10]);
            Tire tire3 = new Tire(tirePressure3,tireAge3);
            tires.add(tire3);
            double tirePressure4 = Double.parseDouble(parameters[11]);
            int tireAge4 = Integer.parseInt(parameters[12]);
            Tire tire4 = new Tire(tirePressure4,tireAge4);
            tires.add(tire4);


            Engine engine = new Engine(engineSpeed,enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);

            Car car = new Car(carModel,engine,cargo,tires);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")){

            cars.stream().filter(car -> car.getCargo().getCargoType().equals(cargoType))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                    .forEach(car -> System.out.println(car.getCarModel()));

        } else if (cargoType.equals("flamable")) {

            cars.stream().filter(car -> car.getCargo().getCargoType().equals(cargoType))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getCarModel()));
        }
    }
}
