package org.example.components;

public class Dataset {

    private final int id;
    private final String name;
    private final int size;
    private final String problemType;

    // constructor
    public Dataset(int id, String name, int size, String problemType) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.problemType = problemType;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getProblemType() {
        return problemType;
    }

}
