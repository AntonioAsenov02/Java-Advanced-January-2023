package Exercises3SetsAmdMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String,Integer>> map = new TreeMap<>();


        String input = scanner.nextLine();
        while (!input.equals("end")){

            String [] tokens = input.split("\\s+");

            String ipAddress = tokens[0].split("=")[1];
            String message = tokens[1].split("=")[1];
            String user = tokens[2].split("=")[1];

            if (!map.containsKey(user)){

                map.put(user,new LinkedHashMap<>());
                map.get(user).put(ipAddress,1);
            }else {

                Map<String, Integer> currentIps = map.get(user);
                if (!currentIps.containsKey(ipAddress)){

                    currentIps.put(ipAddress,1);
                }else {

                    int currentMessages = currentIps.get(ipAddress);
                    currentIps.put(ipAddress,currentMessages + 1);
                }

            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {

            System.out.println(entry.getKey() + ":");

            int currentCount = 0;
            for (Map.Entry<String, Integer> newEntry : map.get(entry.getKey()).entrySet()) {

                int ipsCount = entry.getValue().size();

                if (currentCount < ipsCount - 1){

                    System.out.printf("%s => %d, ",newEntry.getKey(),newEntry.getValue());
                    currentCount++;
                }else {

                    System.out.printf("%s => %d.",newEntry.getKey(),newEntry.getValue());
                }

            }
            System.out.println();
        }

    }
}
