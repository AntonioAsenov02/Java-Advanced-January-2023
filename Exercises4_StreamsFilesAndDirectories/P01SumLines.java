package Exercises4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLines {

    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {

            int sum = 0;
            for (Character symbol : line.toCharArray()) {

                sum += (int) symbol;

            }
            System.out.println(sum);
        }
    }
}
