package JOption;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pian
 */
public class CheckLulus {
        public static void main(String[] args) {
        String nis = JOptionPane.showInputDialog(null, "Masukkan NIS? : ");
        JOptionPane.showMessageDialog(null, "NIS : " + nis);
        System.out.println("NIS" + " : " + nis);

        String name = JOptionPane.showInputDialog(null, "Masukkan Name? : ");
        JOptionPane.showMessageDialog(null, "Nama : " + name);
        System.out.println("Name" + " : " + name);

        String ujian1 = JOptionPane.showInputDialog(null, "Masukkan Nilai Ujian 1? : ");
        JOptionPane.showMessageDialog(null, "Nilai Ujian 1 : " + ujian1);
        System.out.println("Ujian 1" + " : " + ujian1);
        int ujian1INT = Integer.parseInt(ujian1);

        String ujian2 = JOptionPane.showInputDialog(null, "Masukkan Nilai Ujian 2? : ");
        JOptionPane.showMessageDialog(null, "Nilai Ujian 2 : " + ujian2);
        System.out.println("Ujian 2" + " : " + ujian2);
        int ujian2INT = Integer.parseInt(ujian2);

        String nilaitugas = JOptionPane.showInputDialog(null, "Masukkan Nilai Tugas? : ");
        JOptionPane.showMessageDialog(null, "Nilai Tugas : " + nilaitugas);
        System.out.println("Nilai tugas" + " : " + nilaitugas);
        int nilaitugasINT = Integer.parseInt(nilaitugas);

        int nilaiakhir = 35% ujian1INT + 40% ujian2INT + 25% nilaitugasINT;
        
        if (nilaiakhir >= 77) {
            System.out.println("Status ; Lulus");
        } else {
            System.out.println("Status ; Tidak Lulus");
        }
    }
}
