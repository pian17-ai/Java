/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inherit;

/**
 *
 * @author pian
 */
public class Lingkaran {
    private double jari;
    
    public Lingkaran (double jari) {
        this.jari = jari;
    }

    public double getJari() {
        return jari;
    }
    
    public double luas () {
        double luas = Math.PI * jari * jari ;
        return luas;
    }
}
