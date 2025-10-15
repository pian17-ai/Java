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
public class PrintName {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Mau berapa nama? : ");
        
        int n = Integer.parseInt(input);

        while (n > 0) {
            String name = JOptionPane.showInputDialog(null, "Inputkan nama " + n);
            JOptionPane.showMessageDialog(null, "Nama saya : " + name);
            System.out.println("Nama " + n + " : " + name);
            n -= 1;
        }
    }
    
}
