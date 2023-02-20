package Lab_7Generics.listUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(400);
        list.add(-120);
        list.add(-439);
        list.add(545);

        System.out.println(ListUtils.getMax(list));
        System.out.println(ListUtils.getMin(list));

    }
}
