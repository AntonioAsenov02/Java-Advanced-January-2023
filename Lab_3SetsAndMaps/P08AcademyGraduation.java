package Lab_3SetsAndMaps;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, List<Double>> studentMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {

            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                                                    .map(Double::parseDouble)
                                                    .collect(Collectors.toList());


                studentMap.put(name,new ArrayList<>());
                studentMap.put(name,grades);

        }
        Map<String,Double> newStudentMap = new TreeMap<>();

        for (Map.Entry<String, List<Double>> entry : studentMap.entrySet()) {

            int counterGrades = 0;
            double allGrades = 0;
            for (Double grade : entry.getValue()) {

                counterGrades++;
                allGrades += grade;
            }

            double averageGrade = allGrades / counterGrades;


            newStudentMap.put(entry.getKey(),averageGrade);

        }

        DecimalFormat format = new DecimalFormat("0.##########");
        for (Map.Entry<String, Double> newEntry : newStudentMap.entrySet()) {

            System.out.printf("%s is graduated with %s%n",newEntry.getKey(),format.format(newEntry.getValue()));
        }


    }
}
