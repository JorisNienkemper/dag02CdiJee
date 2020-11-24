package org.example.joris.app.services;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.Test;

public class CDITests {

    @Test
    void watIsEigelijkEenDepedency() {
        ConsolePrinter printer = new ConsolePrinter();
        printer.print("Hallo Dit is nog geen Dependency injection!");
    }

    @Test
    void worker1DoSomeWork() {
        Werker1 werker1 = new Werker1();
        werker1.doTask();
    }

    @Test
    void worker2DoSomeWorkAndGetDependencyViaConstructor() {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        Werker2 werker = new Werker2(consolePrinter);
        werker.doTask();
    }

    @Test
    void worker2DoSomeWorkAndGetDependencyViaMethodParameter() {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        Werker2 werker = new Werker2();
        werker.setConsolePrinter(consolePrinter);
        werker.doTask();
    }

    @Test
    void maakDeCDIContainerBeschikbaar() {
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();
        WeldInstance<ConsolePrinter> handle = cdiContainer.select(ConsolePrinter.class);
        ConsolePrinter consolePrinter = handle.get();
        consolePrinter.print("doe eens wat?");
        cdiContainer.shutdown();
    }

    @Test
    void maakViaCDIContainerEenWerkerBeschikbaar() {
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();
        WeldInstance<Werker1> handle = cdiContainer.select(Werker1.class);
        Werker1 werker1 = handle.get();
        werker1.doTask();
    }

    @Test
    void hoeVindDeInjectiePlaats() {
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();
        WeldInstance<Werker2> handle = cdiContainer.select(Werker2.class);
        Werker2 werker2 = handle.get();
        werker2.doTask();
    }
}
