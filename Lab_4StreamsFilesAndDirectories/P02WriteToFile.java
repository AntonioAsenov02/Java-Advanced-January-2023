package Lab_4StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P02WriteToFile {

    public static void main(String[] args) {

        String pathIn = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenSymbols = new HashSet<>();

        Collections.addAll(forbiddenSymbols,',','.','!','?');

        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)){

            int oneByte = in.read();

            while (oneByte >= 0){

                char myByteAsChar = (char) oneByte;

                if (!forbiddenSymbols.contains(myByteAsChar)){

                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
