/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inherit;

/**
 *
 * @author pian
 */
public class Kerucut extends Lingkaran {
    private double tinggi;
    
    public Kerucut(double jari, double tinggi) {
        super(jari);
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }
    
    public double volumeKerucut(){
        double vol = (super.luas() * tinggi) / 3;
        return vol;
    }
}
