package org.example.joris.app.services;

import javax.inject.Inject;

public class Werker2 {
    // Console printer is hier een dependency
//    private ConsolePrinter consolePrinter = new ConsolePrinter();
    @Inject
    private ConsolePrinter consolePrinter;

    public Werker2() {
        System.out.println("De default constructor Werker2() is gebruikt");

    }


    public Werker2(ConsolePrinter consolePrinter) {
        System.out.println("De constructor Werker2(ConsolePrinter consolePrinter) is gebruikt");
        this.consolePrinter = consolePrinter;
    }

    public void doTask() {
        consolePrinter.print("Start met task");
        consolePrinter.print("Hard aan het werk ...");
        consolePrinter.print("Task afgerond");
    }


    public void setConsolePrinter(ConsolePrinter consolePrinter) {
        System.out.println("De default setConsolePrinter(ConsolePrinter consolePrinter) is gebruikt");

        this.consolePrinter = consolePrinter;
    }
}
