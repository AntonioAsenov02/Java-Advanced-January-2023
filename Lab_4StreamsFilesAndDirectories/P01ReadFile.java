package Lab_4StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P01ReadFile {

    public static void main(String[] args) {

        String path = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream in = new FileInputStream(path)){

            int oneByte = in.read();
            while (oneByte >= 0){

                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e){

            System.out.println("Io exception");
        }

    }
}
