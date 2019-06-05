package main.java.com.tigratius.concurrentfilereader.task;

import main.java.com.tigratius.concurrentfilereader.util.IOUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileBackupTask implements Runnable {

    private final String targetPath = IOUtil.GetAbsolutePath()+"\\src\\main\\resources\\backup\\";
    private File file;

    public FileBackupTask(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            Files.copy(Paths.get(file.getPath()), Paths.get(targetPath + "backup-" + file.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
