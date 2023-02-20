package ClassesExercises.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot){

        if (data.size() < getCapacity()){
            data.add(parrot);
        }
    }
    public boolean remove(String name){

        for (Parrot parrot : data) {

            if (parrot.getName().equals(name)){
                return data.remove(parrot);
            }
        }
        return false;
    }
    public Parrot sellParrot(String name){

        Parrot parrot = null;
        for (Parrot currentParrot : data) {

            if (currentParrot.getName().equals(name)){
                parrot = currentParrot;
                currentParrot.setAvailable(false);
            }
        }
        return parrot;
    }
    public List<Parrot> sellParrotBySpecies(String species){

        List<Parrot> list = new ArrayList<>();

        for (Parrot parrot : data) {

            if (parrot.getSpecies().equals(species)){
                parrot.setAvailable(false);
                list.add(parrot);
            }
        }
        return list;
    }
    public int count(){

        return data.size();
    }
    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Parrots available at %s:",this.name)).append(System.lineSeparator());
        for (Parrot parrot : data) {
            if (parrot.isAvailable()){
                builder.append(parrot).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
