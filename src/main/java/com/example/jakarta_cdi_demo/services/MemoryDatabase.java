package com.example.jakarta_cdi_demo.services;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

// ist die Standard-Version für Database und wird im Normalfall herangezogen
// Unterschied zwischen Singleton und ApplicationScoped ist nicht ganz klar
@Singleton
public class MemoryDatabase implements Database {
    List<String> stringList;

    private Logger logger;

    // Constructor Injection möglich, da es sich nicht um ein @ApplicationScoped, sondern um ein Singleton handelt
    @Inject
    public MemoryDatabase(Logger logger) {
        this.logger = logger;
        stringList = new ArrayList<>();
        stringList.add("MemoryDatabase");
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
