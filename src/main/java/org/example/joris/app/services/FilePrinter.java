package org.example.joris.app.services;

import javax.enterprise.context.ApplicationScoped;

@File
@ApplicationScoped
public class FilePrinter implements Printer {

    public void print(String message) {
        System.out.println("printing message to file: " + message);
    }
}
