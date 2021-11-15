package com.example.jakarta_cdi_demo.services;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

// Solange eine Session mit dem Client besteht, bleibt auch das Objekt gleich
// unterschiedliche Browser erhalten unterschiedliche Objekte
@SessionScoped
public class Logger implements Serializable {
    public void log(String msg){
        System.out.println("LOG: " + msg);
    }
}
