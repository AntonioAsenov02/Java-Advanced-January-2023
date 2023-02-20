package Exercises6_DefiningClasses.P07Google;

public class Children {
    private String childName;
    private String childBirth;


    public Children(String childName, String childBirth) {
        this.childName = childName;
        this.childBirth = childBirth;
    }

    @Override
    public String toString(){

        return childName + " " + childBirth;
    }
}
