package Exercises7_Generics.CountMethodDoubble;

import java.util.ArrayList;
import java.util.List;

public class CountMethod <T extends Comparable<T>>{
    private List<T> list;

    public CountMethod(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public int greaterElementsCount(T element){

        int count = 0;

        for (T currentElement : list) {

            if (currentElement.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
