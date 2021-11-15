package com.example.jakarta_cdi_demo.services;

import java.util.Random;

// Ohne Scope wird dieses Objekt bei jedem Aufruf neu erzeugt
public class OtherRandom {
    private final int random;

    public OtherRandom() {
        random = new Random().nextInt(100);
    }

    public int random() {
        return random;
    }
}
