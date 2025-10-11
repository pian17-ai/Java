/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import java.util.Scanner;

/**
 *
 * @author pian
 */
public class UjiBank {
    
    public static void main(String[] args) {
        int kesempatan = 3;
        int pilih = 5;

        Scanner sc = new Scanner(System.in);
        Transaksi ts = new Transaksi(200000);

        do {
            int pin = 1234;

            System.out.print("Masukkan pin ");
            int inputpin = sc.nextInt();

            if (inputpin == pin) {

                do {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("~~~Bank RPL~~~");
                    System.out.println("1. Cek Saldo, 2. Menabung, 3. Tarik, 4. Transfer, 5. Exit");

                    System.out.print("Pilih : ");
                    pilih = sc.nextInt();

                    switch (pilih) {
                        case 1: //cel
                            System.out.println("Saldo anda adalah " + ts.saldo);
                            break;

                        case 2: //nabung
                            System.out.print("Masukkan saldo yang ingin ditabung : ");
                            int tabung = sc.nextInt();
                            ts.menabung(tabung);
                            System.out.println("Saldo " + tabung + " berhasil ditambahkan");
                            System.out.println("Saldo saat ini " + ts.saldo);
                            break;

                        case 3: //tarik
                            System.out.print("Saldo yang ingin di tarik : ");
                            int tarik = sc.nextInt();
                            if (tarik > ts.saldo) {
                                System.out.println("Saldo anda tidak cukup");
                            } else {
                                ts.menarik(tarik);
                                System.out.println("Saldo " + tarik + " Berhasil ditarik");
                                System.out.println("Saldo saat ini : " + ts.saldo);
                            }
                            break;

                        case 4: //transfer2
                            System.out.println("Saldo yang ingin di transfer : ");
                            int transfer = sc.nextInt();
                            if (transfer > ts.saldo) {
                                System.out.println("Saldo anda tidak cukup");
                            } else {
                                ts.transfer(transfer);
                                System.out.println("Saldo " + transfer + " Berhasil di transfer");
                                System.out.println("Saldo saat ini : " + ts.saldo);
                            }
                            break;

                        case 5: // exit
                            System.out.println("Terimakasih sudah menggunakan Bank kami");
                            pilih = 5;
                            kesempatan = 0;
                            break;

                        default:
                            System.out.println("Pilih dengan benar");
                            break;
                    }
                } while (!(pilih == 5));
            } else {
                if (kesempatan > 1) {
                    System.out.println("Pin salah ");
                    kesempatan -= 1;
                    System.out.println("Sisa kesempatan " + kesempatan);
                } else {
                    System.out.println("Kesempatan habis, silahkan hubungi cs");
                    System.out.println("Silahkan hubungi cs");
                    kesempatan -= 1;
                }

            }
        } while (kesempatan > 0 || !(pilih==5));

    }
}
