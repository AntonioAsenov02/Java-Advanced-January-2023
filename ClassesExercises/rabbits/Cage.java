package ClassesExercises.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

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

    public void add(Rabbit rabbit){

        if (data.size() < capacity){
            data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){

        for (Rabbit rabbit : data) {

            if (rabbit.getName().equals(name)){
                return data.remove(rabbit);
            }
        }
        return false;
    }
    public void removeSpecies(String species){

        for (Rabbit rabbit : data) {

            if (rabbit.getSpecies().equals(species)){
                data.remove(rabbit);
            }
        }
    }
    public Rabbit sellRabbit(String name){

        Rabbit result = null;
        for (Rabbit rabbit : data) {

            if (rabbit.getName().equals(name)){
                result = rabbit;
                rabbit.setAvailable(false);
            }
        }
        return result;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){

        List<Rabbit> list = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)){
                list.add(rabbit);
                rabbit.setAvailable(false);
            }
        }
        return list;
    }
    public int count(){
        return data.size();
    }
    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Rabbits available at %s:%n",getName()));
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()){
                builder.append(rabbit).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
