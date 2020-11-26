package org.example.joris.app.services;

@File
public class FilePrinter implements Printer {

    public void print(String message) {
        System.out.println("printing message to file: " + message);
    }
}
