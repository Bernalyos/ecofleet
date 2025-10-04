/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Coder
 */
public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto() {}

    public Auto(int id, String marca, String modelo, String placa, boolean disponible, int numeroPuertas) {
        super(id, marca, modelo, placa, disponible);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() { return numeroPuertas; }
    public void setNumeroPuertas(int numeroPuertas) { this.numeroPuertas = numeroPuertas; }
}
