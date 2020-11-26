package org.example.joris.app.services;

import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.List;

public class NaamProducer {
    @Produces
    public List<String> getNames(){
        return Arrays.asList("Dave","Sam","Evan");
    }
}
