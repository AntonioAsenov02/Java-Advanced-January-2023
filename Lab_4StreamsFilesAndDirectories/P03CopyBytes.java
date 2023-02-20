package Lab_4StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {

    public static void main(String[] args) throws IOException {

        String pathIn = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();
        while (oneByte >= 0){

            if (oneByte == 32 || oneByte == 10){

                out.write((char) oneByte);
            }else {

                String text = String.valueOf(oneByte);
                for (int i = 0; i < text.length(); i++) {

                    out.write(text.charAt(i));
                }
            }
            oneByte = in.read();
        }
    }
}
