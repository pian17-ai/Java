/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konsep_gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pian
 */
public class Tugas_4 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Latihan Swing");
        JLabel jl = new JLabel("label");
        JTextField jtf = new JTextField();
        JButton jb = new JButton();
        JOptionPane jop = new JOptionPane();
        
        jf.add(jl);
        jf.add(jtf);
        jf.add(jb);
        
        jf.setLayout(null);
        jf.setSize(400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jl.setText("Masukkan nama : ");
        jl.setBounds(50, 70, 300, 30);
        
        jtf.setBounds(50, 120, 300, 30);
        
        jb.setText("Submit");
        jb.setBounds(150, 180, 100, 30);
        jb.addActionListener(e -> {
            String nama = jtf.getText();
            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Nama Tidak Boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(jf, "Halo, " + nama + "!");
            }
        });
    }
}
