package org.example.joris.app.services;

import javax.inject.Inject;
import java.util.List;

public class NaamConsumer {

    @Inject
    private List<String> namen;

    public void showNamen() {
        for (String naam : namen) {
            System.out.println(naam);
        }
    }
}
