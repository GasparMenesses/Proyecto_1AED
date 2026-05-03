package org.example.components;

import org.example.service.ExperimentState;

import org.example.utils.*;

public class Experiment {

    private final int id;
    private final Model model;
    private final Dataset dataset;
    private ExperimentState state;
    private double accuracy;
    private double precision;

    public Experiment(int id, Model model, Dataset dataset, ExperimentState state) {
        this.id = id;
        this.model = model;
        this.dataset = dataset;
        this.state = state.PENDIENTE;
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

    public ExperimentState getState() {
        return state;
    }

    public void setState(ExperimentState state) {
        this.state = state;
    }

}
