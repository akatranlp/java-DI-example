package com.example.jakarta_cdi_demo.services;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
// ist eine Alternative Version für Database und wird im Normalfall nicht herangezogen
// Unterschied zwischen Singleton und ApplicationScoped ist nicht ganz klar
@Alternative
public class OtherDatabase implements Database {
    List<String> stringList;

    private Logger logger;

    // Constructor Injection möglich, da es sich nicht um ein @ApplicationScoped, sondern um ein Singleton handelt
    @Inject
    public OtherDatabase(Logger logger) {
        this.logger = logger;
        stringList = new ArrayList<>();
        stringList.add("OtherDatabase");
    }

    @Override
    public List<String> getAll() {
        return stringList;
    }

    @Override
    public String getOne(int index) {
        if (index >= stringList.size())
            return null;
        return stringList.get(index);
    }
}
