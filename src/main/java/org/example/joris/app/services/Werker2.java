package org.example.joris.app.services;

import javax.inject.Inject;

public class Werker2 {
    // Console printer is hier een dependency
//    private ConsolePrinter consolePrinter = new ConsolePrinter();
//    @Inject
//    @File
    private Printer printer;

    public Werker2() {
        System.out.println("De default constructor Werker2() is gebruikt");

    }

    @Inject
    public Werker2(@File Printer printer) {
        System.out.println("De constructor Werker2(ConsolePrinter consolePrinter) is gebruikt");
        this.printer = printer;
    }

    public void doTask() {
        printer.print("FP Wi ben ik: " + printer.toString());
    }


    public void setPrinter(ConsolePrinter printer) {
        System.out.println("De default setConsolePrinter(ConsolePrinter consolePrinter) is gebruikt");

        this.printer = printer;
    }
}
