package main.java.com.tigratius.concurrentfilereader.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOUtil {

    public synchronized static void printInfo(File file, int value)
    {
        System.out.println("--------------------------------------------");
        System.out.println("currentThreadName : " + Thread.currentThread().getName());
        System.out.println("Sleep (сек.) : " + value);
        System.out.println("Name : " + file.getName());
        System.out.println("Extension : " + getFileExtension(file));
        System.out.println("Size (bytes) : " + getFileSize(file));
        System.out.println("--------------------------------------------");
    }

    public static List<File> getFilesFromFolder(String path){

        List<File> files;

        try (Stream<Path> paths = Files.walk(Paths.get(path))) {

            files = paths.filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return files;
    }

    public static String GetAbsolutePath()
    {
        return Paths.get("").toAbsolutePath() +"";
    }

    private static String getFileExtension(File file) {
        String extension = "";

        if (file != null && file.exists()) {
            String name = file.getName();
            extension = name.substring(name.lastIndexOf("."));
        }

        return extension;
    }

    private static Long getFileSize(File file) {
        long size = 0;

        if (file != null && file.exists()) {
            size = file.length();
        }

        return size;
    }
}
