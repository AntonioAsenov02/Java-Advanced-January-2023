package Exercises4_StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {

    public static void main(String[] args) throws IOException {


        String pathOne = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        List<String> allLinesOne = Files.readAllLines(Path.of(pathOne));
        List<String> allLinesTwo = Files.readAllLines(Path.of(pathTwo));

        PrintWriter writer = new PrintWriter("output.txt5");

        for (String line : allLinesOne) {
            
            writer.println(line);
        }

        for (String line : allLinesTwo) {

            writer.println(line);
        }

        writer.close();
    }
}
