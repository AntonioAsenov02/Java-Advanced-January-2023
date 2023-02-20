package Exercises7_Generics.SwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class SwapMethod <T>{
    private List<T> list;


    public SwapMethod(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        list.add(element);
    }

    public void swap(int index1,int index2){

        T firstElement = this.list.get(index1);
        T secondElement = this.list.get(index2);

        list.set(index1,secondElement);
        list.set(index2,firstElement);
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
