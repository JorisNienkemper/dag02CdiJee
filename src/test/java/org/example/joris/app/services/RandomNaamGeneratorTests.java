package org.example.joris.app.services;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomNaamGeneratorTests {

    @Test
    void getRandomName() {
        String [] namen = new String[]{"De","Da","E","C","J","Ma","Mi","R","Sa","Sj"};
        System.out.println(namen[new Random().nextInt(namen.length)]);
    }
}
