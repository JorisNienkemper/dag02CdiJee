package org.example.joris.app.services;

import javax.inject.Inject;

public class Werker1 {
    // Console printer is hier een dependency
//    private ConsolePrinter consolePrinter = new ConsolePrinter();
    @Inject
    private ConsolePrinter consolePrinter;

    public void doTask() {
        consolePrinter.print("Start met task");
        consolePrinter.print("Hard aan het werk ...");
        consolePrinter.print("Task afgerond");
    }
}
