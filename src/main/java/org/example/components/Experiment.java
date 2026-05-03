package org.example.components;

public class Experiment {

    private final Model model;
    private final Dataset dataset;
    private ExperimentState state;
    private double accuracy = 0.0;
    private double precision = 0.0;
    private final int id;

    public Experiment(int id, Model model, Dataset dataset, ExperimentState state, double accuracy, double precision) {
        this.id = id;
        this.model = model;
        this.dataset = dataset;
        this.state = state;
        this.accuracy = accuracy;
        this.precision = precision;
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

    public double getAccuracy() {
        return accuracy;
    }

    public double getPrecision() {
        return precision;
    }

    public void setState(ExperimentState state) {
        this.state = state;
    }

    public void setResult(double accuracy, double precision) {
        this.accuracy = accuracy;
        this.precision = precision;
    }

}
