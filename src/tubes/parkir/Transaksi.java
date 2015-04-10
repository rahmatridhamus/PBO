/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.parkir;

/**
 *
 * @author rahmatridhams
 */
public class Transaksi {

    private String noTransaksi, status;
    private boolean denda=false;
/**
 * Konstruktor yang mengisi nomor transaksi dengan plat nomor
 * @param noTransaksi 
 */
    public Transaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
/**
 * Method untuk menginstansiasi status menjadi lunas atau belum
 * @param status Sting
 */
    public void setStatus(String status) {
        this.status = status;
    }
/**
 * Function yang mengembalikan status sudah lunas atau belum
 * @return status
 */
    public String getStatus() {
        return status;
    }
/**
  * Function ini mengembalikan nilai false apabila kena denda
  * @return flase atau true
  */
    public boolean isDenda() {
        return denda;
    }
/**
 * Method yang mengisi denda
 * @param denda boolean
 */
    public void setDenda(boolean denda) {
        this.denda = denda;
    }
}
 