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
public class Tarif {

    private int jamAwal, jamBerikut, denda;
/**
 * Konstruktor untuk menginstansiasi jam awal dan jam berikutnya
 */
    public Tarif() {
        
    }
/**
 * Function yang mengembalikan jam awal
 * @return jam awal
 */
    public int getJamAwal() {
        return jamAwal;
    }
/**
 * Method yang menginstansiasi jam awal
 * @param jamAwal int
 */
    public void setJamAwal(int jamAwal) {
        this.jamAwal = jamAwal;
    }
/**
 * Function yang mengembalikan jam berikutnya
 * @return jam berikutnya
 */
    public int getJamBerikut() {
        return jamBerikut;
    }
/**
 * Method untuk menginstansiasi jam berikut
 * @param jamBerikut int
 */
    public void setJamBerikut(int jamBerikut) {
        this.jamBerikut = jamBerikut;
    }
/**
 * Function yang mengembalikan biaya denda
 * @return denda
 */
    public int getDenda() {
        return denda;
    }
/**
 * Method untuk menginstansiasi biaya denda
 * @param denda int
 */
    public void setDenda(int denda) {
        this.denda = denda;
    }


}
