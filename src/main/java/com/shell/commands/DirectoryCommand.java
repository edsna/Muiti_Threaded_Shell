package com.shell.commands;

import java.io.File;
import java.util.Arrays;
import com.shell.utils.DateUtil;
import com.shell.utils.TimeUtil;

public class DirectoryCommand {
    public void execute(String[] args) {
        String path = args.length > 0 ? args[0] : ".";
        File directory = new File(path);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                printFileInfo(file);
            }
        }
    }

    private void printFileInfo(File file) {
        String type = file.isDirectory() ? "<DIR>" : "     ";
        String name = file.getName();
        String date = new DateUtil().getCurrentDate();
        String time = new TimeUtil().getCurrentTime();
        long size = file.length();
        
        System.out.printf("%s  %s  %s  %10d  %s%n", 
            date, time, type, size, name);
    }
}
