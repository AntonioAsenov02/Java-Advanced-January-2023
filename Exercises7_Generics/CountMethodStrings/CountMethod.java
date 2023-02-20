package Exercises7_Generics.CountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class CountMethod<T extends Comparable<T>>  {
    private List<T> list;


    public CountMethod(){
        this.list = new ArrayList<>();
    }

    public void add(T element){

        list.add(element);
    }

    public int countGreaterThan(T element){

        int count = 0;

        for (T currentElement : this.list) {

            if (currentElement.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

}
