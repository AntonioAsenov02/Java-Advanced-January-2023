package Lab_7Generics.jar;

public class Main {

    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(10);
        jar.add(20);
        jar.add(30);

        System.out.println(jar.remove());
        System.out.println(jar.remove());

        Jar<String> jar2 = new Jar<>();

        jar2.add("Cookie1");
        jar2.add("Cookie2");

        System.out.println(jar2.remove());
    }
}
