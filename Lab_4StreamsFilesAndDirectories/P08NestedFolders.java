package Lab_4StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {

    public static void main(String[] args) {

        String path = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        File root = new File(path);

        Deque<File> directories = new ArrayDeque<>();
        directories.offer(root);

        int count = 0;
        while (!directories.isEmpty()){

            File current = directories.poll();

            File [] nestedFiles = current.listFiles();

            for (File nestedFile : nestedFiles) {

                if (nestedFile.isDirectory()){

                    directories.offer(nestedFile);
                    count++;

                    System.out.println(current.getName());
                }

            }
        }
        System.out.println(count + " folders");
    }
}
