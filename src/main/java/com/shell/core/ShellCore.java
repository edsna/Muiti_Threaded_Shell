package com.shell.core;

import com.shell.commands.*;
import com.shell.utils.*;
import java.util.concurrent.*;
import java.io.*;

public class ShellCore {
    private final ExecutorService executorService;
    
    public ShellCore() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
        ShellCore shell = new ShellCore();
        shell.start();
    }

    public void start() {
        // Original main method logic goes here
        // We'll refactor this next
    }

    @Override
    protected void finalize() {
        executorService.shutdown();
    }
}
