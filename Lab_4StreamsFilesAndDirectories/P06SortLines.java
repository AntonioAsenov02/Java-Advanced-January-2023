package Lab_4StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {

    public static void main(String[] args) throws IOException {


        Path input = Paths.get("C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path output = Paths.get("C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);

        Files.write(output,lines);
    }
}
