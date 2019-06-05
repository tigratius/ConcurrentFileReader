package main.java.com.tigratius.concurrentfilereader.service;

import main.java.com.tigratius.concurrentfilereader.task.FileBackupTask;
import main.java.com.tigratius.concurrentfilereader.util.IOUtil;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BackupService {

    private final static String path = IOUtil.GetAbsolutePath()+ "\\src\\main\\resources\\files\\";

    public BackupService() {
    }

    public void run()
    {
        List<File> filesInFolder = IOUtil.getFilesFromFolder(path);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (File f : filesInFolder
        ) {
            service.submit(new FileBackupTask(f));
        }

        service.shutdown();
    }
}
