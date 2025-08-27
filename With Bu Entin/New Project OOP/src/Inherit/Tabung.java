/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inherit;

/**
 *
 * @author pian
 */
public class Tabung extends Lingkaran {
    private double tinggi;
    
    public Tabung(double jari, double tinggi) {
        super(jari);
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }
    
    public double volumeTabung() {
        double vol = super.luas() * tinggi;
        return vol;       
}
}
