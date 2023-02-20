package ClassesExercises.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public String getColor() {
        return color;
    }
    public int getCapacity() {
        return capacity;
    }

    public int count(){
        return data.size();
    }

    public void add(Present present){

        if (data.size() < capacity){
            data.add(present);
        }
    }

    public boolean remove(String name){

        for (Present present : data) {

            if (present.getName().equals(name)){
                return data.remove(present);
            }
        }
        return false;
    }

    public Present heaviestPresent(){

        return data.stream().max(Comparator.comparing(Present::getWeight)).get();
    }
    public Present getPresent(String name){

        Present present = null;

        for (Present currentPresent : data) {

            if (currentPresent.getName().equals(name)){
                present = currentPresent;
            }
        }
        return present;
    }

    public String report(){

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s bag contains:",getColor())).append("\n");

        for (Present present : data) {
            builder.append(present).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
