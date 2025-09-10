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
public class Lat4_GUI {
    public static void main(String[] args) {
        // menutup app
//        JFrame jf = new JFrame();
//        
//        jf.setTitle("Hello Java");
//        jf.setBounds(400, 100, 600, 800);
//        jf.setVisible(true);
//        jf.setResizable(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button
        JFrame jf = new JFrame("FRAME");
        JButton jb = new JButton("BUTTON");
        
        jf.setSize(400, 500);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setTitle("Halo pian");
        jf.setLocationRelativeTo(null);
        jf.add(jb);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
