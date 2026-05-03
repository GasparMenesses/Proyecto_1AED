package org.example.model;
import org.example.utils.*;

public class Experiment {
    private final int id;
    private final Model model;
    private final Dataset dataset;
    private String state;
    private double accuracy;
    private double precision;

    public Experiment(int id, Model model, Dataset dataset) {
        this.id = id;
        this.model = model;
        this.dataset = dataset;
        this.state = "pendiente";
    }

    public int getId() {
        return id;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public Model getModel() {
        return model;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
