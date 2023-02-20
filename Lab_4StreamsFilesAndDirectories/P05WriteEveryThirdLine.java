package Lab_4StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05WriteEveryThirdLine {

    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";


        Scanner in = new Scanner(new FileInputStream(pathIn));
        PrintWriter out = new PrintWriter(new FileOutputStream(pathOut));

        String currentLine = in.nextLine();
        int counter = 1;
        while (in.hasNextLine()){

            if (counter % 3 == 0){

                out.println(currentLine);
            }
            counter++;
            currentLine = in.nextLine();
        }

        out.close();
    }
}
