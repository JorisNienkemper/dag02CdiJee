package org.example.joris.app.services;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("printing message to console: " + message);
    }
}
