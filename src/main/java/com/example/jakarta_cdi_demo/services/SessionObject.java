package com.example.jakarta_cdi_demo.services;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
public class SessionObject implements Serializable {

    private Logger logger;
    private Map<String, Integer> objects;

    // wird ausgeführt, nachdem alle Objekte in dieses Injected wurde,
    // aber bevor es selbst in andere Objekte injected wird
    @PostConstruct
    private void init() {
        logger.log("Session Start!!!");
        objects = new HashMap<>();
        objects.put("anzahl", 0);
    }

    // keine Constructor Injection möglich, da es sich um @SessionScoped handelt
    public SessionObject() { }

    @Inject
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public int getValue(String key) {
        logger.log("GET[" + key + "]");
        return objects.get(key);
    }

    public void setValue(String key, int value) {
        logger.log("SET[" + key + "] = " + value);
        objects.put(key, value);
    }
}
