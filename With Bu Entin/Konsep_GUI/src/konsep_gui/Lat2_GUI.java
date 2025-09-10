/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konsep_gui;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author pian
 */
public class Lat2_GUI {
    public static void main(String[] args) {
        Frame f2 = new Frame("TEXT");
        TextField t = new TextField();
        
        f2.setSize(500, 200);
        f2.setLocationRelativeTo(null);
        f2.add(t);
        f2.setVisible(true);
        
        f2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
