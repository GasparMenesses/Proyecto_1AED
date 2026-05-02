package org.example.model;
import org.example.utils.*;

public class Experimento {
    private String id;
    private DataSet dataset;    
    private Modelo modelo;
    private String estado; //pendiente o ejecutado
    double exactitud = 0; 
    double precision = 0; 
}
