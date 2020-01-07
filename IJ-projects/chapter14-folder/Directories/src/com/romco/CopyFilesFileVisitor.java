package com.romco;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFilesFileVisitor extends SimpleFileVisitor<Path> {
    private Path sourceRoot, targetRoot;
    
    public CopyFilesFileVisitor(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path path = sourceRoot.relativize(dir);
        Path copyDir = targetRoot.resolve(path);
        try {
            Files.copy(dir, copyDir);
        } catch (IOException e) {
            e.printStackTrace();
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        this.preVisitDirectory(file, attrs);
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("error accessing file: " + file.toAbsolutePath() + ": " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
