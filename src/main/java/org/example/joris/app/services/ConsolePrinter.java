package org.example.joris.app.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

@Dependent
public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("printing message to console: " + message);
    }
}
