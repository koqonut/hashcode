package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFile(String filePath) {
        System.out.println("Reading file: " + filePath);
        List<String> allLines = new ArrayList<>();
        try {
            Path p = Paths.get(filePath);
            allLines = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lines read: " + allLines.size());
        return allLines;
    }


    public static void writeToFile(String path, String outputFile) {
        try {
            Files.writeString(Paths.get(path), outputFile);
            System.out.println("Write successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
