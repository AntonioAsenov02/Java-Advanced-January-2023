package ClassesExercises.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity){
            this.data.add(animal);
        }

    }

    public boolean remove(String name) {

        for (Animal animal : data) {

            if (animal.getName().equals(name)) {
                return this.data.remove(animal);
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {

        Animal animal = null;
        for (Animal currentAnimal : data) {

            if (currentAnimal.getName().equals(name) && currentAnimal.getCaretaker().equals(caretaker)) {
                animal = currentAnimal;
            }
        }
        return animal;
    }

    public Animal getOldestAnimal(){

        Animal animal = null;

        int oldestAnimal = Integer.MIN_VALUE;

        for (Animal currentAnimal : data) {

            if (currentAnimal.getAge() > oldestAnimal){

                oldestAnimal = currentAnimal.getAge();
                animal = currentAnimal;
            }
        }
        return animal;
    }

    public Integer getCount(){

        return data.size();
    }

    public String getStatistics(){

        StringBuilder builder = new StringBuilder();

        builder.append("The ClassesExercises.shelter has the following animals:").append("\n");

        for (Animal animal : data) {
            builder.append(animal.getName()).append(" ").append(animal.getCaretaker()).append("\n");
        }
        return builder.toString().trim();
    }
}
