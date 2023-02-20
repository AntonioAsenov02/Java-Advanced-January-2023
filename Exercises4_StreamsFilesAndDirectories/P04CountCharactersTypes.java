package Exercises4_StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharactersTypes {

    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        List<String> allLines = Files.readAllLines(Path.of(path));

        int vowelsCount = 0;
        int punctuationMarks = 0;
        int otherSymbols = 0;

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {

                if (symbol == 97 || symbol == 101 || symbol == 105 || symbol == 111 || symbol == 117){

                    vowelsCount++;
                }else if (symbol == 33 || symbol == 46 || symbol == 44 || symbol == 63){

                    punctuationMarks++;
                }else if (symbol == ' '){

                    continue;
                }else {
                    otherSymbols++;
                }
            }
        }
        writer.write("Vowels: " + vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " + otherSymbols);
        writer.newLine();
        writer.write("Punctuation: " + punctuationMarks);
        writer.close();
    }
}
