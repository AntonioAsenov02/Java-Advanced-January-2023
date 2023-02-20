package ClassesExercises.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){

        if (data.size() < capacity){
            data.add(pet);
        }
    }

    public boolean remove(String name){

        for (Pet pet : data) {

            if (pet.getName().equals(name)){
                return data.remove(pet);
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner){

        Pet pet = null;
        for (Pet currentPet : data) {

            if (currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)){

                pet = currentPet;
            }
        }
        return pet;
    }
    public Pet getOldestPet(){

        return data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }

    public int getCount(){

        return data.size();
    }
    public String getStatistics(){

        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:").append("\n");

        for (Pet pet : data) {
            builder.append(String.format("%s %s%n",pet.getName(),pet.getOwner()));
        }
        return builder.toString();
    }
}
