/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import java.text.DecimalFormat;
import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author pian
 */
public class Lingkaran {
    double r;
    
    public Lingkaran(double r) {
        if (r <= 0) {
            System.out.println("Jari Jari tidak boleh <=0");
            this.r = 1;
        } else {
            this.r = r;
        }
        
    }
    
    public double luas () {
        double luas = Math.PI * this.r * this.r;
        return luas;
    }
    
    public static void main(String[] args) {
        Scanner inptr = new Scanner(System.in);
        DecimalFormat dcf = new DecimalFormat("0.00");
        
        System.out.print("Jari Jari : ");
        double jari = inptr.nextInt();
        
        Lingkaran ling = new Lingkaran(jari);
        System.out.print("Hasil luas lingkaran yang mempunyai jari jari " + jari + " adalah : ");
        System.out.println(dcf.format(ling.luas()));
    }
}
