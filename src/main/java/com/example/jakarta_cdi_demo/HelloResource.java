package com.example.jakarta_cdi_demo;

import com.example.jakarta_cdi_demo.services.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class HelloResource {
    // Field Injection aller benötigten Klassen

    // Die Instanz ändert sich nicht, da ApplicationScope
    @Inject
    MyApplication appl;

    // Die Instanz ändert sich nicht, da ApplicationScope
    @Inject
    SessionObject session;

    // Die Instanz ändert sich nicht, da ApplicationScope
    // und ist dieselbe wie in appl.db
    @Inject
    Database db;

    // Die Instanz ändert sich per Session, da SessionScope
    // und ist dieselbe wie in appl.logger und appl.logger2
    @Inject
    Logger logger;

    // Die Instanz ändert sich per Request, da RequestScope
    // und ist dieselbe wie in appl.oneTime
    @Inject
    OneTime random;

    // Die Instanz ändert sich bei jedem Inject, da sie keinen Scope hat
    // und ist ungleich appl.otherRandom
    // appl.otherRandom bleibt aber immer gleich, da sie in appl fest verankert ist
    @Inject
    OtherRandom otherRandom;


    // Test Endpoints für Ergebnisse
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAll(){
        logger.log(db.toString());
        logger.log(logger.toString());
        logger.log(random.toString());
        logger.log("" + random.random());
        return db.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("id") int id){
        logger.log(db.toString());
        logger.log(logger.toString());
        logger.log(random.toString());
        logger.log("" + random.random());
        return db.getOne(id);
    }

    // Hier werden die Speicheradressen der einzelnen Objekte ausgegeben
    @GET
    @Path("/addresses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAddresses(){
        session.setValue("anzahl", session.getValue("anzahl") + 1);

        List<String> list = new ArrayList<>(16);
        list.add(db.toString());
        list.add(logger.toString());
        list.add(random.toString());
        list.add("" + random.random());
        list.add(otherRandom.toString());
        list.add("" + otherRandom.random());
        list.add(appl.toString());
        list.add(appl.getDb().toString());
        list.add(appl.getLogger().toString());
        list.add(appl.getLogger2().toString());
        list.add(appl.getOneTime().toString());
        list.add("" + appl.getOneTime().random());
        list.add(appl.getOtherRandom().toString());
        list.add("" + appl.getOtherRandom().random());
        list.add(session.toString());
        list.add("" + session.getValue("anzahl"));
        return list;
    }
}