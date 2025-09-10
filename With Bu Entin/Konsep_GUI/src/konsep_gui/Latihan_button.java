/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konsep_gui;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author pian
 */
public class Latihan_button {
    public static void main(String[] args) {
        JFrame jf = new JFrame("btn");
        JButton jb = new JButton("click me");
        
        jf.setLayout(null);
        jf.setSize(500, 500);
        jf.setTitle("BUTTON");
        jf.setVisible(true);
        jf.setResizable(true);
        jf.add(jb);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jb.setBounds(175, 150, 150, 30);
    }
}
