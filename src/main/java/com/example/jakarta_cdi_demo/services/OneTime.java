package com.example.jakarta_cdi_demo.services;

import javax.enterprise.context.RequestScoped;
import java.util.Random;

// Pro Request wird immer dasselbe Objekt verwendet
@RequestScoped
public class OneTime {
    private final int random;

    // keine Constructor Injection möglich, da es sich um @RequestScoped handelt
    public OneTime(){
        random = new Random().nextInt(100);
    }

    public int random() {
        return random;
    }
}
