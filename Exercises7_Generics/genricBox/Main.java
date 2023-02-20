package Exercises7_Generics.genricBox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        GenericBox<String> box = new GenericBox<>();

        for (int i = 0; i < n; i++) {

            String text = scanner.nextLine();

            box.add(text);
        }


        System.out.println(box);
    }
}
