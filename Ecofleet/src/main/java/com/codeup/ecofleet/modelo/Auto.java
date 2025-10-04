package com.codeup.ecofleet.modelo;

public class Auto extends Vehiculo {
    private int puertas;

    public Auto() {}

    public Auto(int id, String marca, String modelo, String placa, boolean disponible, int puertas) {
        // 👇 Aquí pasamos "AUTO" como tipo fijo
        super(id, "AUTO", marca, modelo, placa, disponible);
        this.puertas = puertas;
    }

    public int getPuertas() { return puertas; }
    public void setPuertas(int puertas) { this.puertas = puertas; }
}
