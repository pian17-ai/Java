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
public class PercabanganIfElse {

    public static void main(String[] args) {
        System.out.print("Cek nilai anda : ");
        Scanner input = new Scanner (System.in);
        
        int nilai = input.nextInt();

        if (nilai == 100) {
            System.out.println("Excelent");
        } else if (nilai > 80) {
            System.out.println("Good");
        } else {
            System.out.println("Nice Try");
        }
//        GANJIL GENAP

        System.out.print("Cek ganjil genap : ");
        
        Scanner inputs = new Scanner (System.in);
        int angka = inputs.nextInt();
        
        if (angka % 2 == 0) {
            System.out.println(angka + " = Genap");
        } else {
            System.out.println(angka + " = Ganjil");
        }

        //        ACCOUT 
        String username = "admin";
        String password = "admin1234";

        //        LOGIN
        System.out.println("Login admin");

        Scanner inputUsername = new Scanner(System.in);
        Scanner inputPassword = new Scanner(System.in);

        System.out.print("Masukkan Username : ");
        String usernameLogin = inputUsername.next();
        System.out.print("Masukkan Password : ");
        String passwordLogin = inputPassword.next();

        if (usernameLogin.equals(username) && passwordLogin.equals(password)) {
            System.out.println("Login Success");
        } else {
            
            System.out.println("Username atau Password salah");
        }
    }
}
