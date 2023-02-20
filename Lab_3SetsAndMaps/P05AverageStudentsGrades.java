package Lab_3SetsAndMaps;

import java.util.*;

public class P05AverageStudentsGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, ArrayList<Double>> studentGradesMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {

            String [] tokens = scanner.nextLine().split("\\s+");

            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            if (!studentGradesMap.containsKey(studentName)){

                studentGradesMap.put(studentName,new ArrayList<>());
                studentGradesMap.get(studentName).add(grade);
            }else {

                studentGradesMap.get(studentName).add(grade);
            }
        }

        for (Map.Entry<String, ArrayList<Double>> entry : studentGradesMap.entrySet()) {

            int gradesCounter = 0;
            double avg = 0;
            for (Double grade : entry.getValue()) {

                gradesCounter++;
                avg += grade;
            }
            double averageGrade = avg / gradesCounter;

            System.out.printf("%s -> ",entry.getKey());
            for (Double grade : entry.getValue()) {

                System.out.printf("%.2f ",grade);
            }
            System.out.printf("(avg: %.2f)%n",averageGrade);
        }

    }
}
