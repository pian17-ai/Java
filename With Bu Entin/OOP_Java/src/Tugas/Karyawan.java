/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

import java.util.Scanner;

/**
 *
 * @author pian
 */


import java.util.Scanner;

public class Karyawan {
    private String nama;
    private int gaji;
    private int kehadiran;

    // Getter & Setter Nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter & Setter Kehadiran
    public int getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(int kehadiran) {
        this.kehadiran = kehadiran;
    }

    // Getter & Setter Gaji
    public int getGaji() {
        gaji = this.kehadiran * 200000; // Hitung gaji otomatis
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    // Main Program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama : ");
        String nama = input.nextLine(); // pakai nextLine biar bisa input spasi

        System.out.print("Masukkan Kehadiran : ");
        int kehadiran = input.nextInt();

        // Buat objek
        Karyawan kar = new Karyawan();
        kar.setNama(nama);
        kar.setKehadiran(kehadiran);

        // Output
        System.out.println("\n===== Data Karyawan =====");
        System.out.println("Nama       : " + kar.getNama());
        System.out.println("Kehadiran  : " + kar.getKehadiran());
        System.out.println("Total Gaji : Rp " + kar.getGaji());
    }
}
