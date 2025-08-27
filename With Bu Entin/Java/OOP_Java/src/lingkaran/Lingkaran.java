/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author pian
 */
public class Lingkaran {
    double r;
    
    public Lingkaran(double r) {
        this.r = r;
    }
    
    public double luas () {
        double luas = Math.PI * this.r * this.r;
        return luas;
    }
    
    public static void main(String[] args) {
        Scanner inptr = new Scanner(System.in);
        
        System.out.print("Jari Jari : ");
        double jari = inptr.nextInt();
        
        Lingkaran ling = new Lingkaran(jari);
        System.out.print("Hasil luas lingkaran yang mempunyai jari jari " + jari + " adalah : ");
        System.out.println(ling.luas());
    }
}
