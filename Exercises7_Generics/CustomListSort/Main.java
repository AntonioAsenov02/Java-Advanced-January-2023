package Exercises7_Generics.CustomListSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){

            String [] commandInput = input.split("\\s+");

            String command = commandInput[0];


            switch (command){

                case "Add" :

                    String element = commandInput[1];
                    list.add(element);
                    break;
                case "Remove" :

                    int index = Integer.parseInt(commandInput[1]);
                    list.remove(index);
                    break;
                case "Contains" :

                    String currentElement = commandInput[1];
                    System.out.println(list.contains(currentElement));
                    break;
                case "Swap" :

                    int index1 = Integer.parseInt(commandInput[1]);
                    int index2 = Integer.parseInt(commandInput[2]);

                    list.swap(index1,index2);
                    break;
                case "Greater" :

                    String elementToCompare = commandInput[1];
                    System.out.println(list.countGreater(elementToCompare));
                    break;
                case "Max" :

                    System.out.println(list.getMax());
                    break;
                case "Min" :

                    System.out.println(list.getMin());
                    break;
                case "Print" :

                    list.print();
                    break;
                case "Sort" :
                    list.sort();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}

