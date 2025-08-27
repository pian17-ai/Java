/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelompok;

import java.util.Scanner;

/**
 *
 * @author USER
 */
//    OVERRIDING
//    super class
class Hewan {

    void suara() {
        System.out.println("Hewan Bersuara");
    }
}

//    subclass dengan overriding
class Kucing extends Hewan {

    @Override
    void suara() {
        System.out.println("Miaaauwww");
    }
}

class User {
    void username() {
        System.out.println("username");
    }
    void tanggalLahir() {
        System.out.println("tanggal lahir");
    }
    void jurusan() {
        System.out.println("RPL/DKV");
    }
}

class Pian extends User {
    void username() {
        System.out.println("Alvian Cahyo Pambudi");
    }
    void tanggalLahir () {
        System.out.println("17 April 2009");
    }
    void jurusan() {
        System.out.println("RPL");
    }
}

public class Method {
//    VOID

    static void myMethod(String nama, int age) {
        System.out.println("Your name is " + nama + " and " + age + " years old");
    }

//    NON VOID
    static String ganap(int inp) {
        if (inp % 2 == 0) {
            return "genap";
        } else {
            return "ganjil";
        }
    }

//    OVERLOADING
    void sapa(String nama) {
        System.out.println("Halooo " + nama);
    }

    void sapa(String nama, int umur) {
        System.out.println("Haloooz " + nama + "umur kamuh " + umur + ", benar gak?");
    }

    public static void main(String[] args) {
//        VOID
        System.out.println("Void : ");
        myMethod("Pian", 16);
        myMethod("Adelele", 14);

        System.out.println("");

//        NON VOID
        System.out.println("non Void : ");
        System.out.print("Cek Ganjil/Genap : ");

//        Scanner input = new Scanner(System.in);
//        int intAngka = input.nextInt();
        String hasilGanap = ganap(4);
        System.out.println(hasilGanap);

        System.out.println("");

//        OVERLOADING
        System.out.println("Overloading : ");
        Method obj = new Method();

        obj.sapa("Piann");
        obj.sapa("Adelele", 17);

        System.out.println("");

//        OVERRIDING
        System.out.println("OVERRIDING");
        Hewan kucing = new Hewan();
        kucing.suara();
        
//        OUTPUT
        User Pian = new Pian();
        Pian.username();
        Pian.tanggalLahir();
        Pian.jurusan();
    }
}
