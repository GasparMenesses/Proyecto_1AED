package org.example.model;
import org.example.utils.*;

public class Experiment {
    
    private String id;
    private DataSet dataset;    
    private Model modelo;
    private String estado; //pendiente o ejecutado

    double exactitud = 0; 
    double precision = 0; 
    
    public Experiment(String id, DataSet dataset, Model modelo, String estado) {
        this.id = id;
        this.dataset = dataset;
        this.modelo = modelo;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataSet getDataset() {
        return dataset;
    }

    public void setDataset(DataSet dataset) {
        this.dataset = dataset;
    }

    public Model getModelo() {
        return modelo;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
