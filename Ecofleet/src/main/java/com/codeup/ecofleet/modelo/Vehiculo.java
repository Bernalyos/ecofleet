/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.ecofleet.modelo;

/**
 *
 * @author Coder
 */
public class Vehiculo {
    
    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private String placa; 
    private boolean disponible;
    
    //constructor 
    public Vehiculo(){}
    public Vehiculo( int id, String tipo, String marca, String modelo, String placa, boolean disponible){
        
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.disponible = disponible;
        
    }
    
    //Metodos getters y setters
    
    public int getId (){ return id;}
    public void setId (int id){ this.id = id;}
    
    public String getTipo(){ return tipo;}
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getMarca() { return marca; }
    public void setMarca( String marca){ this.marca = marca;}
    
    public String getModelo(){ return modelo;}
    public void setModelo( String modelo){ this.modelo = modelo;}
    
    public String getPlaca(){ return placa;}
    public void setPlaca( String placa){ this.placa = placa;}
    
    public boolean getDisponible(){ return disponible;}
    public void setDisponible( boolean disponible){ this.disponible = disponible;}
    
    
    
}
