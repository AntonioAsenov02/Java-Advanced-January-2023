package Exercises4_StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt2"));

        List<String> allLines = Files.readAllLines(Path.of(path));

        int count = 1;
        for (String line : allLines) {

            writer.write(count + ". " + line);
            count++;
            writer.newLine();
        }
        writer.close();
    }
}
