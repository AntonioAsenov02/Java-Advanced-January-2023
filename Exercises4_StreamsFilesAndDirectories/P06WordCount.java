package Exercises4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class P06WordCount {

    public static void main(String[] args) throws IOException {


        String inputPath = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        List<String> allLines = Files.readAllLines(Path.of(inputPath));

        Map<String,Integer> countWords = new HashMap<>();
        for (String line : allLines) {

            String [] allWords = line.split("\\s+");

            Arrays.stream(allWords).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        String wordsToReadPath = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        List<String> allLines2 = Files.readAllLines(Path.of(wordsToReadPath));

        for (String line : allLines2) {

            String [] wordsToCheck = line.split("\\s+");

            for (String wordToCheck : wordsToCheck) {

                if (countWords.containsKey(wordToCheck)){

                    int currentCount = countWords.get(wordToCheck);

                    countWords.put(wordToCheck,currentCount + 1);
                }
            }
        }

        PrintWriter writer = new PrintWriter("result.txt");

        countWords.entrySet().stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();
    }
}
