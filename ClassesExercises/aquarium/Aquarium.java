package ClassesExercises.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {

        boolean contains = false;
        for (Fish currentFish : fishInPool) {
            if (currentFish.getName().equals(fish.getName())) {
                contains = true;
            }
        }
        if (!contains) {
            if (fishInPool.size() < getCapacity()) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {

        for (Fish currentFish : fishInPool) {
            if (currentFish.getName().equals(name)) {
                return fishInPool.remove(currentFish);
            }
        }
        return false;
    }
    public Fish findFish(String name) {

        Fish fish = null;
        for (Fish currentFish : fishInPool) {
            if (currentFish.getName().equals(name)) {
                fish = currentFish;
            }
        }
        return fish;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Aquarium: %s ^ Size: %d%n", getName(), getSize()));

        for (Fish fish : fishInPool) {
            builder.append(fish).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
