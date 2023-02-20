package Lab_3SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<Double,Integer> numbersMap = new LinkedHashMap<>();

        double [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToDouble(Double::parseDouble)
                        .toArray();


        for (Double number : numbers) {

            if (!numbersMap.containsKey(number)){

                numbersMap.put(number,1);
            }else {

                int currentValue = numbersMap.get(number);
                numbersMap.put(number,currentValue + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {

            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
