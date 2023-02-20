package Exercises4_StreamsFilesAndDirectories;

import java.io.File;

public class P08GetFolderSize {

    public static void main(String[] args) {


        String path = "C:\\Users\\User\\Desktop\\JavaAdvanced-January2022\\src\\05\\ Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        File [] allFilesInFolder = folder.listFiles();

        int allFilesSize = 0;
        if (allFilesInFolder != null){
        for (File file : allFilesInFolder) {


                allFilesSize += file.length();
            }
        }

        System.out.println("Folder size: " + allFilesSize);
    }
}
