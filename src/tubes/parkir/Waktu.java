/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.parkir;

import java.time.Instant;

/**
 *
 * @author rahmatridhams
 */
public class Waktu {
    private Instant jamMasuk,jamKeluar=null;
/**
 * Konstruktor yang menginstansiasi jam masuk dan jam keluar
 */
    public Waktu() {
    }
/**
 * Function yang mengembalikan jam masuk
 * @return jam masuk
 */    
    public Instant getJamMasuk() {
        return jamMasuk;
    }
/**
 * Method yang menginstansiasi jam masuk
 * @param jamMasuk Instant
 */
    public void setJamMasuk(Instant jamMasuk) {
        this.jamMasuk = jamMasuk;
    }
/**
 * Function yang mengembalikan jam keluar
 * @return jam keluar
 */
    public Instant getJamKeluar() {
        return jamKeluar;
    }
/**
 * Method yang menginstansiasi jam keluar
 * @param jamKeluar Instant
 */
    public void setJamKeluar(Instant jamKeluar) {
        this.jamKeluar = jamKeluar;
    }
    
    
    
}
