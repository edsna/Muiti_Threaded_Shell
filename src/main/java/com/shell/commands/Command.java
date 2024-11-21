package com.shell.commands;

public interface Command {
    void execute(String[] args);
    String getHelp();
}
