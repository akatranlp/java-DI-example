package com.example.jakarta_cdi_demo.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

// Solange die Application läuft, gibt es nur dieses Objekt
@ApplicationScoped
public class MyApplication {
    // Field Injection der benötigten Klassen

    // Die Instanz ändert sich nicht, da ApplicationScope
    @Inject
    private Database db;

    // Die Instanz ändert sich per Session, da SessionScope
    @Inject
    private Logger logger;

    // Die Instanz ändert sich per Request, da RequestScope
    @Inject
    private OneTime oneTime;

    // Die Instanz ändert sich nicht, da es keinen Scope hat
    @Inject
    private OtherRandom otherRandom;

    // keine Constructor Injection möglich, da es sich um @ApplicationScoped handelt
    public MyApplication() { }

    private Logger logger2;

    // Method Injection
    @Inject
    public void setLogger(Logger logger) {
        logger2 = logger;
    }

    public Database getDb() {
        return db;
    }

    public Logger getLogger() {
        return logger;
    }

    public Logger getLogger2() {
        return logger2;
    }

    public OneTime getOneTime() {
        return oneTime;
    }

    public OtherRandom getOtherRandom() {
        return otherRandom;
    }
}
