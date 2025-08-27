/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inherit;

/**
 *
 * @author pian
 */
public class Main {
    public static void main(String[] args) {
        Tabung tbg = new Tabung(1, 10);
        System.out.println(tbg.volumeTabung());
        
        Kerucut krc = new Kerucut (1, 10);
        System.out.println(krc.volumeKerucut());
    }
}
