package Lab_6DefiningClasses.P01CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();

        for (int i = 1; i <= count ; i++) {

            String [] inputArr = scanner.nextLine().split("\\s+");

            Car car;

            if (inputArr.length == 1){

                car = new Car(inputArr[0]);
            }else {

                car = new Car(inputArr[0],inputArr[1],Integer.parseInt(inputArr[2]));
            }


            carsList.add(car);
        }

        carsList.forEach(car -> System.out.println(car.carInfo()));
    }
}
