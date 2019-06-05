package main.java.com.tigratius.concurrentfilereader.task;

import main.java.com.tigratius.concurrentfilereader.util.IOUtil;

import java.io.File;
import java.util.Random;

public class FileReaderTask implements Runnable {

    private File file;
    private Random r;

    public FileReaderTask(File file) {
        this.file = file;
        r = new Random();
    }

    @Override
    public void run() {
        try {
            int value = (r.nextInt(5) + 1);
            IOUtil.printInfo(file, value);
            Thread.sleep(value*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
