package com.xuge.sampletest.service;

import java.io.Serializable;

public class SerializableImplement implements Serializable {

    private static final long serialVersionUID = -1060750974510310608L;
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
