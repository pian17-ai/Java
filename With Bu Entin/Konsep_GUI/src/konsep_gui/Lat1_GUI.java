/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konsep_gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author pian
 */
public class Lat1_GUI {
    public static void main(String[] args) {
        Frame f1 = new Frame();
        
        f1.setTitle("Contoh Frame");
        f1.setSize(300, 200);
        f1.setResizable(true);
        f1.setVisible(true);
        
        f1.addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
