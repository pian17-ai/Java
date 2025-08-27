/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inherit;

import java.util.Scanner;

/**
 *
 * @author pian
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("");
            System.out.println("Pilih Hitung Tabung(1) Kerucut(2) keluar(0)");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    //Tabung
                    System.out.print("Masukkan Jari : ");
                    double tbjr = input.nextDouble();

                    System.out.print("Masukkan Tinggi : ");
                    double tbtg = input.nextDouble();

                    Tabung tbg = new Tabung(tbjr, tbtg);
                    System.out.println("Volume Tabungnya adalah : " + tbg.volumeTabung());

                    break;

                case 2:
                    //Kerucut
                    System.out.print("Masukkan Jari : ");
                    double kerjr = input.nextDouble();

                    System.out.print("Masukkan Tinggi : ");
                    double kertg = input.nextDouble();

                    Kerucut krc = new Kerucut(kerjr, kertg);
                    System.out.println("Volume Kerucut adalah : " + krc.volumeKerucut());

                    break;

                case 0:
                    System.out.println("Selesai");
                    break;

                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        } while (pilih == 1 || pilih == 2);

    }
}
