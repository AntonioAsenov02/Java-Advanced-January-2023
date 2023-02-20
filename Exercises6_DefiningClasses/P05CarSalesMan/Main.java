package Exercises6_DefiningClasses.P05CarSalesMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int enginesCount = Integer.parseInt(scanner.nextLine());

        List<Engine> enginesList = new ArrayList<>();

        for (int i = 0; i < enginesCount; i++) {

            String[] enginesSpecifications = scanner.nextLine().split("\\s+");

            String model = enginesSpecifications[0];
            int power = Integer.parseInt(enginesSpecifications[1]);
            int displacement = 0;
            String efficiency = null;

            if (enginesSpecifications.length == 4) {

                displacement = Integer.parseInt(enginesSpecifications[2]);
                efficiency = enginesSpecifications[3];
            } else if (enginesSpecifications.length == 3) {

                if (Character.isDigit(enginesSpecifications[2].charAt(0))) {

                    displacement = Integer.parseInt(enginesSpecifications[2]);
                } else {

                    efficiency = enginesSpecifications[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesList.add(engine);
        }

        int carsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carsCount; i++) {

            String[] carSpecifications = scanner.nextLine().split("\\s+");

            String carModel = carSpecifications[0];
            String engineModel = carSpecifications[1];
            int weight = 0;
            String color = null;

            if (carSpecifications.length == 4) {

                weight = Integer.parseInt(carSpecifications[2]);
                color = carSpecifications[3];
            } else if (carSpecifications.length == 3) {

                if (Character.isDigit(carSpecifications[2].charAt(0))) {

                    weight = Integer.parseInt(carSpecifications[2]);
                } else {

                    color = carSpecifications[2];
                }
            }

            Engine currentEngine = null;

            for (Engine engine : enginesList) {

                if (engineModel.equals(engine.getModel())){

                    currentEngine = engine;
                    break;
                }
            }
            Car car = new Car(carModel,currentEngine,weight,color);
            System.out.print(car.toString());
        }
    }
}
