package main.java.com.tigratius.concurrentfilereader;

import main.java.com.tigratius.concurrentfilereader.service.BackupService;

public class MainConsole {

    public static void main(String[] args) {
        BackupService service = new BackupService();
        service.run();
    }
}
