/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Coder
 */
public class Bicicleta extends Vehiculo {
    private boolean electrica;

    public Bicicleta() {}

    public Bicicleta(int id, String marca, String modelo, String placa, boolean disponible, boolean electrica) {
        super(id, marca, modelo, placa, disponible);
        this.electrica = electrica;
    }

    public boolean isElectrica() { return electrica; }
    public void setElectrica(boolean electrica) { this.electrica = electrica; }
}
    

