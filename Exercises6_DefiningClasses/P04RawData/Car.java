package Exercises6_DefiningClasses.P04RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String carModel, Engine engine, Cargo cargo, List<Tire> tires) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tires  = new ArrayList<>();
        this.tires.addAll(tires);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getCarModel() {
        return carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTires() {
        return tires;
    }
}
