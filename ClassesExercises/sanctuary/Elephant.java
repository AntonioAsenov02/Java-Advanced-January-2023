package ClassesExercises.sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retireFrom;

    public Elephant(String name, int age, String retireFrom) {
        this.name = name;
        this.age = age;
        this.retireFrom = retireFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRetireFrom() {
        return retireFrom;
    }

    public void setRetireFrom(String retireFrom) {
        this.retireFrom = retireFrom;
    }

    @Override
    public String toString(){

        return String.format("%s %d - %s",getName(),getAge(),getRetireFrom());
    }
}
