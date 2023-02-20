package Exercises6_DefiningClasses.P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String,Person> peopleData = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){

            String [] parameters = input.split("\\s+");

            String personName = parameters[0];

            if (!peopleData.containsKey(personName)){

                peopleData.put(personName,new Person());
            }
            String typeCommand = parameters[1];

            switch (typeCommand){

                case "company" :

                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);

                    Company company = new Company(companyName,department,salary);
                    peopleData.get(personName).setCompany(company);
                    break;
                case "car" :

                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);

                    Car car = new Car(carModel,carSpeed);
                    peopleData.get(personName).setCar(car);
                    break;
                case "children" :

                    String childName = parameters[2];
                    String childBirthday = parameters[3];

                    Children child = new Children(childName,childBirthday);
                    peopleData.get(personName).getChildren().add(child);
                    break;
                case "parents" :

                    String parentName = parameters[2];
                    String parentBirthday = parameters[3];

                    Parents parent = new Parents(parentName,parentBirthday);
                    peopleData.get(personName).getParents().add(parent);
                    break;
                case "pokemon" :

                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];

                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                    peopleData.get(personName).getPokemons().add(pokemon);
                    break;
            }

            input = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = peopleData.get(searchedPerson);
        System.out.println(personalData);
    }
}
