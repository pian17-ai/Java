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
public class PercabanganIfElseIf {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("Masukkan nilai anda : ");
        int nilai = input.nextInt();

        if (nilai > 90) {
            System.out.println("Excellent");
        } else if (nilai > 80) {
            System.out.println("Great");
        } else if (nilai > 70) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }
}