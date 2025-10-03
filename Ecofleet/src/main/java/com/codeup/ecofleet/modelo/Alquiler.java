
package com.codeup.ecofleet.modelo;

import java.time.LocalDateTime;

public class Alquiler {
    private int id;
    private int usuarioId;
    private int vehiculoId;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double kmRecorridos;
    private double costoTotal;

    // Constructor vacío
    public Alquiler() {}

    // Constructor con parámetros
    public Alquiler(int id, int usuarioId, int vehiculoId,
                    LocalDateTime fechaInicio, LocalDateTime fechaFin,
                    double kmRecorridos, double costoTotal) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.vehiculoId = vehiculoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.kmRecorridos = kmRecorridos;
        this.costoTotal = costoTotal;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public int getVehiculoId() { return vehiculoId; }
    public void setVehiculoId(int vehiculoId) { this.vehiculoId = vehiculoId; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    
    public LocalDateTime getFechaFin(){ return fechaFin;}
    public void setFechaFin( LocalDateTime fechaFin){ this.fechaFin = fechaFin;}
    
    public double getKmRecorridos(){ return kmRecorridos;}
    public void setKmRecorridos(){ this.kmRecorridos = kmRecorridos;}
    
    public double getCostoTotal(){ return costoTotal;}
    public void setCostoTotal( double costoTotal){ this.costoTotal = costoTotal;}
    
}
