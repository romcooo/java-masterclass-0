package com.romco;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "createdFile.txt");
//            Files.createFile(fileToCreate);
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "createdDir");
//            Files.createDirectory(dirToCreate);
//            Path dirsToCreate = FileSystems.getDefault().getPath("Examples", "dir1\\dir2\\dir3");
//            Files.createDirectories(dirsToCreate);
    
            Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
            BasicFileAttributes atts = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Size = " + atts.size());
            System.out.println("Last Modified = " + atts.lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
////        path = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
//        path = Paths.get(".", "files", "SubdirectoryFile.txt");
//        printFile(path);
//        path = Paths.get("C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter14-folder\\outThere.txt");
//        printFile(path);
//        Path path1 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path1.normalize());
//        printFile(path1.normalize());
    }
    
    private static void printFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("-------");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
