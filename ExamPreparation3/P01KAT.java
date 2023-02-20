package ExamPreparation3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01KAT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlates = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> cars = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int days = 0;
        int countOfRegisteredCars = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()){


            if (licensePlates.getFirst() / 2 > cars.getLast()){

                int remainingLicensePlates = licensePlates.getFirst() - cars.getLast() * 2;
                licensePlates.removeFirst();
                licensePlates.add(remainingLicensePlates);
                countOfRegisteredCars += cars.getLast();
                cars.removeLast();
            }else if (licensePlates.getFirst() / 2 < cars.getLast()){

                int remainingCars = cars.getLast() - licensePlates.getFirst() / 2;
                cars.removeLast();
                cars.addFirst(remainingCars);
                countOfRegisteredCars += licensePlates.getFirst() / 2;
                licensePlates.removeFirst();
            }else {

                countOfRegisteredCars += cars.getLast();
                licensePlates.removeFirst();
                cars.removeLast();
            }

            days++;
        }

        System.out.printf("%d cars were registered for %d days!%n",countOfRegisteredCars,days);

        int countOfLicensePlate = 0;
        if (!licensePlates.isEmpty()){

            for (Integer plates : licensePlates) {

                countOfLicensePlate += plates;
            }
            System.out.printf("%d license plates remain!%n",countOfLicensePlate);
        }

        int carsRemaining = 0;
        if (!cars.isEmpty()){

            for (Integer car : cars) {

                carsRemaining += car;
            }
            System.out.printf("%d cars remain without license plates!%n",carsRemaining);
        }

        if (cars.isEmpty() && licensePlates.isEmpty()){

            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
