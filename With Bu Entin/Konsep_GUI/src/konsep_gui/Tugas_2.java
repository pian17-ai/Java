/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konsep_gui;

import java.awt.TextField;
import javax.swing.JFrame;

/**
 *
 * @author pian
 */
public class Tugas_2 {
    public static void main(String[] args) {
        String nama = null;
        
        JFrame jf = new JFrame("Latihan AWT");
        TextField tf = new TextField();
        
        jf.setLayout(null);
        jf.setSize(400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.add(tf);
        
        tf.setText(nama);
        tf.setBounds(100, 100, 200, 20);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
