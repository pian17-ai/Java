/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

/**
 *
 * @author pian
 */
public class Transaksi implements Bank {
    
    int saldo;

    public int getSaldo() {
        return saldo;
    }
    
    public Transaksi (int saldo) { //Constructor
        this.saldo = saldo;
    }
    
    public void menabung (int simpan) {
        saldo += simpan;
    }
    
    public void transfer (int kirim) {
        saldo -= kirim;
    }
    
    public void menarik (int tarik) {
        saldo -= tarik;
    }
     
}
