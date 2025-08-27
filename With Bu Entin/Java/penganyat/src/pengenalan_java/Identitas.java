/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengenalan_java;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Identitas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Nama :");
        String nama = input.next();
        System.out.println("Kelas :");
        String kelas = input.next();
        System.out.println("Umur :");
        int umur = input.nextInt();
        
        System.out.println("Jadi nama kamu adalah " + nama + ", Kamu kelas " + kelas + " dan kamu umurnya itu " + umur);
    }
}
