package Exercises7_Generics.GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class Box <T>{
    private List<T> list;


    public Box(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        list.add(element);
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        for (T element : list) {

            builder.append(element.getClass().getName() + ": " + element).append("\n");
        }
        return builder.toString();
    }
}
