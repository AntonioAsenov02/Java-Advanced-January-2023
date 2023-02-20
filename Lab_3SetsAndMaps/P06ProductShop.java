package Lab_3SetsAndMaps;

import java.util.*;

public class P06ProductShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String,Map<String,Double>> productsMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")){

            String [] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!productsMap.containsKey(shop)){

                productsMap.put(shop,new LinkedHashMap<>());
                productsMap.get(shop).put(product,price);
            }else {

                productsMap.get(shop).put(product,price);
            }



            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : productsMap.entrySet()) {

            System.out.printf("%s->%n",entry.getKey());
            for (Map.Entry<String, Double> newEntry : entry.getValue().entrySet()) {

                System.out.printf("Product: %s, Price: %.1f%n",newEntry.getKey(),newEntry.getValue());
            }

        }
    }
}
