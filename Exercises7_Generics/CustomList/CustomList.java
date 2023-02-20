package Exercises7_Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        return this.list.remove(index);
    }

    public boolean contains(T element){
        if (list.contains(element)){
            return true;
        }
        return false;
    }

    public void swap(int index1,int index2){

        T firstElement = list.get(index1);
        T secondElement = list.get(index2);

        list.set(index1,secondElement);
        list.set(index2,firstElement);
    }

    public int countGreater(T element){

        int count = 0;

        for (T currentElement : list) {

            if (currentElement.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax(){
        return Collections.max(list);
    }

    public T getMin(){
        return Collections.min(list);
    }



    public void print(){

       for (T element : list) {

           System.out.println(element);
       }
   }
}
