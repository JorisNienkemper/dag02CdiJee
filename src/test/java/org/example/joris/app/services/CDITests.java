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
        werker.setPrinter(consolePrinter);
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

    @Test
    void vraagWerker2OpBijDeContainerMetHetInterfacePrinter() {
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();
        WeldInstance<Werker2> handle = cdiContainer.select(Werker2.class);
        Werker2 werker2 = handle.get();
        werker2.doTask();
        cdiContainer.shutdown();
    }
    @Test
    void hoeveelPrintersHebIkNu() {
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();
        Werker1 werker1a = cdiContainer.select(Werker1.class).get();
        Werker1 werker1b = cdiContainer.select(Werker1.class).get();
        Werker1 werker1c = cdiContainer.select(Werker1.class).get();
        Werker2 werker21 = cdiContainer.select(Werker2.class).get();
        Werker2 werker22 = cdiContainer.select(Werker2.class).get();
        Werker2 werker23 = cdiContainer.select(Werker2.class).get();

        werker1a.doTask();
        werker1b.doTask();
        werker1c.doTask();

        werker21.doTask();
        werker22.doTask();
        werker23.doTask();


        cdiContainer.shutdown();
    }

    @Test
    void printNamen() {
        Weld weld = new Weld();
        WeldContainer cdiContainer = weld.initialize();
        NaamConsumer naamConsumer = cdiContainer.select(NaamConsumer.class).get();
        naamConsumer.showNamen();
    }
}
