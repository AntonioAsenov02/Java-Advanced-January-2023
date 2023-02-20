package Lab_3SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Set<String> guestsSet = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")){

            guestsSet.add(input);

            input = scanner.nextLine();
        }

        while (!input.equals("END")){

            if (guestsSet.contains(input)){

                guestsSet.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(guestsSet.size());

        for (String guest : guestsSet) {

            System.out.println(guest);
        }
    }
}
