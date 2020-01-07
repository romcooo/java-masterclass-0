package com.romco;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static final String file1 = "file1.txt";
    public static final String file2 = "file2.txt";
    public static final String file3 = "file3.dat";
    private static final String SPRTR = File.separator;

    public static void main(String[] args) {
    
//        System.out.println(SPRTR);
//        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
////                new DirectoryStream.Filter<Path>() {
////                    @Override
////                    public boolean accept(Path path) throws IOException {
////                        return (Files.isRegularFile(path));
////                    }
////                };
//        Path directory = FileSystems.getDefault().getPath("FileTree"+ SPRTR +"Dir2");
//        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
//            for (Path path : contents) {
//                System.out.println(path.getFileName());
//            }
////            Path[] paths =  {
////                    FileSystems.getDefault().getPath("FileTree", "Dir1", file1),
////                    FileSystems.getDefault().getPath("FileTree", "Dir1", file2),
////                    FileSystems.getDefault().getPath("FileTree", file1),
////                    FileSystems.getDefault().getPath("FileTree", file2),
////                    FileSystems.getDefault().getPath("FileTree", "Dir2", file1),
////                    FileSystems.getDefault().getPath("FileTree", "Dir2", file2),
////                    FileSystems.getDefault().getPath("FileTree", "Dir2", file3),
////                    FileSystems.getDefault().getPath("FileTree", "Dir2", "Dir3", file1),
////                    FileSystems.getDefault().getPath("FileTree", "Dir2", "Dir3", file2),
////                    FileSystems.getDefault().getPath("FileTree", "Dir4", file3),
////            };
////
////            for (Path path : paths) {
////                Files.createFile(path);
////            }
//
//        } catch (IOException | DirectoryIteratorException e) {
//            e.printStackTrace();
//        }
//
////        try {
////            Path tempFile = Files.createTempFile("myapp", ".appext");
////            System.out.println("Temp file path: " + tempFile.toAbsolutePath());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
//        for (FileStore store : stores) {
//            System.out.println(store);
//            System.out.println(store.name());
//        }
//
//        System.out.println("-----------");
//
//        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
//        for (Path path : rootPaths) {
//            System.out.println(path);
//        }
    
//        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + SPRTR + "Dir2");
//        try {
//            Files.walkFileTree(dir2Path, new PrintNamesFileVisitor());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Copying--------");
//        Path copyPath = FileSystems.getDefault().getPath("FileTree", "Dir4", "Dir2Copy");
//        Path sourcePath = FileSystems.getDefault().getPath("FileTree", "Dir2");
//        try {
//            Files.walkFileTree(sourcePath, new CopyFilesFileVisitor(sourcePath, copyPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        // old IO vs NIO
        File file = new File("\\Example\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("Converted path: " + convertedPath);
    
        File parent = new File("\\Example");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());
    
        resolvedFile = new File("\\Example", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());
    
        Path parentPath = Paths.get("\\Example");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));
    
        System.out.println("-------------------");
        
        File workingDir = new File("").getAbsoluteFile();
        System.out.println(workingDir);
    
        System.out.println("-------------");
        File dir2File = new File(workingDir, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        if (dir2Contents != null) {
            for (String dirC : dir2Contents) {
                System.out.println(dirC);
            }
        }
    
        File[] dirFiles = dir2File.listFiles();
        if (dirFiles != null) {
            for (File f : dirFiles) {
                System.out.println(f.getName());
            }
        }
    }
}
