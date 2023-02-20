package Exercises6_DefiningClasses.P05CarSalesMan;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model,Engine engine,int weight,String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append(this.model).append(":").append(System.lineSeparator());
        builder.append(this.engine.getModel()).append(":").append(System.lineSeparator());
        builder.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());
        builder.append("Displacement: ");
        if (this.engine.getDisplacement() == 0){

            builder.append("n/a").append(System.lineSeparator());
        }else {

            builder.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }

        builder.append("Efficiency: ");
        if (this.engine.getEfficiency() == null){

            builder.append("n/a").append(System.lineSeparator());
        }else {

            builder.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }

        builder.append("Weight: ");
        if (this.weight == 0){

            builder.append("n/a").append(System.lineSeparator());
        }else {

            builder.append(this.weight).append(System.lineSeparator());
        }

        builder.append("Color: ");
        if (this.color == null){

            builder.append("n/a").append(System.lineSeparator());
        }else {

            builder.append(this.color).append(System.lineSeparator());
        }

        return builder.toString();
    }
}
