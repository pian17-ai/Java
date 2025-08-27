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
public class PercabanganSwitch {

    public static void admin(String[] args) {
        System.out.println("Login Admin");
    }

    public static void main(String[] args) {
        String ulang = "y";

        while (ulang.equalsIgnoreCase("y")) {
            System.out.println("1. Merah, 2. Kuning, 3. Hijau");
            Scanner input = new Scanner(System.in);
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("Berhenti");
                    break;
                case 2:
                    System.out.println("Hati hati");
                    break;
                case 3:
                    System.out.println("Berjalan");
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        }
        System.out.println("Ulang ? (y/n)");
        Scanner inputss = new Scanner(System.in);
        ulang = inputss.next(ulang);

//        LOGIN USER / ADMIN
//        System.out.println("Pilih 1 = Admin, 2 = User");
//        Scanner inputs = new Scanner (System.in);
//        int login = inputs.nextInt();
//        switch (login) {
//            case 1 :
    

////                admin();
//                break;
//            case 2 :
//                break;
//            default : 
//                System.out.println("Error");
//                break;
//        }
    }
}
