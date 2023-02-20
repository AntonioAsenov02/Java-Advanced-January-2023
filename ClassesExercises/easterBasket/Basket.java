package ClassesExercises.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg(Egg egg){

        if (data.size() < this.capacity){
            data.add(egg);
        }
    }
    public boolean removeEgg(String color){

        for (Egg egg : data) {
            if (egg.getColor().equals(color)){
                return data.remove(egg);
            }
        }
        return false;
    }
    public Egg getStrongestEgg(){

        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }
    public Egg getEgg(String color){

        Egg egg = null;
        for (Egg currentEgg : data) {

            if (currentEgg.getColor().equals(color)){
                egg = currentEgg;
            }
        }
        return egg;
    }
    public int getCount(){

        return data.size();
    }
    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s basket contains:%n",this.material));
        for (Egg egg : data) {
            builder.append(egg).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
