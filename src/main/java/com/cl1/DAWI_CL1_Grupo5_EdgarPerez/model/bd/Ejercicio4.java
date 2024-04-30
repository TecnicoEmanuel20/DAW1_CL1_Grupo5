package com.cl1.DAWI_CL1_Grupo5_EdgarPerez.model.bd;

import lombok.Data;

@Data
public class Ejercicio4 {
    private int numeroOriginal;
    private int cuadrado;
    private double mitad;

    public Ejercicio4(int numeroOriginal, int cuadrado, double mitad) {
        this.numeroOriginal = numeroOriginal;
        this.cuadrado = cuadrado;
        this.mitad = mitad;
    }
}
