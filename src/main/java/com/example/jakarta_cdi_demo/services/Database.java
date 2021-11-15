package com.example.jakarta_cdi_demo.services;

import java.util.List;

public interface Database {
    List<String> getAll();
    String getOne(int index);
}
