/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package percabangan;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class PercabanganIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Inputkan Nilai : ");
        int nilai = input.nextInt();
        
        if (nilai >= 80) {
            System.out.println("Tuntas");
        } else {
            System.out.println("Tidak Tuntas");
        }
    }
}
