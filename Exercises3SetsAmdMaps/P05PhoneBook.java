package Exercises3SetsAmdMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05PhoneBook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> contactMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {

            String[] tokens = input.split("-");

            String name = tokens[0];
            String phone = tokens[1];

            contactMap.put(name, phone);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if (contactMap.containsKey(input)) {

                String value = contactMap.get(input);
                System.out.printf("%s -> %s%n",input, value);


            } else {

                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
