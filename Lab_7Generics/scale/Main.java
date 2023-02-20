package Lab_7Generics.scale;

public class Main {

    public static void main(String[] args) {


        Scale<String> scale = new Scale<>("12","11");
        System.out.println(scale.getHeavier());
    }
}
