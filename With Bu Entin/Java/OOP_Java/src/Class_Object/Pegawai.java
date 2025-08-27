/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object;

import java.util.Scanner;

/**
 *
 * @author pian
 */
public class Pegawai {
    String nama;
    int umur;
    
    public void showData () {
        System.out.println("Data Pegawai : ");
    }
    
//    public static void main(String[] args) {
//        Pegawai peg = new Pegawai();
//        peg.showData();
//        
//        Scanner input = new Scanner(System.in);
//        
//        
//        int age = input.nextInt();
//        
//        System.out.print("Nama Pegawai : " );
//        peg.nama = name;
//        
//        System.out.print("Umur : " );
//        peg.umur = age;
//        
//        System.out.print("----------------------------");
//        System.out.print("Nama Pegawai : " + name);
//        System.out.print("Umur Pegawai : " + age);
//    }
    
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Pegawai peg = new Pegawai();
        peg.showData();
        
        System.out.println("");
    }
}
