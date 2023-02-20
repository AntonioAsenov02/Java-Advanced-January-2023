package Lab_4StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";


        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter myFileOutput = new PrintWriter(new FileOutputStream(pathOut));

        while (scanner.hasNext()){

            if (scanner.hasNextInt()){

                int myNumber = scanner.nextInt();

                myFileOutput.println(myNumber);
            }
            scanner.next();
        }
        myFileOutput.close();
    }
}
