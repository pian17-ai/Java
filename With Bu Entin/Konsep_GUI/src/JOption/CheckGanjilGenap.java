/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JOption;

import javax.swing.JOptionPane;

/**
 *
 * @author pian
 */
public class CheckGanjilGenap {
    public static void main(String[] args) {
        while (true) {
            String angka = JOptionPane.showInputDialog("Inputkan angka : ");
            int nilaiAngka = Integer.parseInt(angka);
            
            if (nilaiAngka % 2 == 0) {
                JOptionPane.showMessageDialog(null, nilaiAngka + " = bilangan genap");
            } else {
                JOptionPane.showMessageDialog(null, nilaiAngka + " = bilangan ganjil");
            }
            
            int jawab = JOptionPane.showConfirmDialog(null, "Ulangi? : ", "", JOptionPane.YES_NO_OPTION);
            if (jawab == JOptionPane.NO_OPTION) {
                break;
            }
        }
    }
}
