package org.example.model;

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
