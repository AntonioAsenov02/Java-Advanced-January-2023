package Lab_3SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){

            String [] commandInput = input.split(", ");

            String command = commandInput[0];
            String carNumber = commandInput[1];

            if (command.equals("IN")){

                parkingLot.add(carNumber);

            }else if (command.equals("OUT")){

                parkingLot.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()){

            System.out.println("Parking Lot is Empty");
        }else {

            for (String carNumber : parkingLot) {

                System.out.println(carNumber);
            }

        }
    }
}
