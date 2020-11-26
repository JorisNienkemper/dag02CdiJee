package org.example.joris.app.services;

import javax.inject.Inject;

public class Werker1 {
    // Console printer is hier een dependency
//    private ConsolePrinter consolePrinter = new ConsolePrinter();
    @Inject
    private ConsolePrinter consolePrinter;

    public void doTask() {
        consolePrinter.print("CP Wie ben ik: " + consolePrinter.toString());
    }
}
