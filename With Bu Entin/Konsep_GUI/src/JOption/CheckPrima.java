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
public class CheckPrima {

    public static void main(String[] args) {
        while (true) {
            String angka = JOptionPane.showInputDialog("Inputkan angka : ");
            int nilaiAngka = Integer.parseInt(angka);
            
            boolean prima = true;
            
            if (nilaiAngka <= 1) {
                prima = false;
            } else {
                for (int i = 2; i <= Math.sqrt(nilaiAngka); i++){
                    if (nilaiAngka % 1 == 0) {
                        prima = false;
                        break;
                    }
                }
            }
            
            if (prima) {
                JOptionPane.showMessageDialog(null, nilaiAngka + " adalah bilangan prima");
            } else {
                JOptionPane.showMessageDialog(null, nilaiAngka + " adalah bilangan bukan prima");
            }

            int jawab = JOptionPane.showConfirmDialog(null, "Ulangi? : ", "", JOptionPane.YES_NO_OPTION);
            if (jawab == JOptionPane.NO_OPTION) {
                break;
            }
        }
    }
}
