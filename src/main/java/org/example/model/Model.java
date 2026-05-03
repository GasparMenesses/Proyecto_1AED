package org.example.model;

import java.io.BufferedReader;
import java.nio.Buffer;

import org.example.ConsoleManager.BufferReader;

public class Model {
    Integer id;
    String name;
    String type;
    String Parameters;

    public Model(Integer id, String name, String type, String parameters) {

        this.id = id;
        this.name = name;
        this.type = type;
        Parameters = parameters;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getParameters() {
        return Parameters;
    }

}
