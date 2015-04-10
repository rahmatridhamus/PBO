/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.parkir;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author rahmatridhams
 */
public class Kendaraan {

    private boolean isDiparkiran, isLunas;
    private String platNomor;
    private Transaksi transaksi;
    private Tarif tarif;
    private Waktu waktu;
    private int biaya;
/**
 * Konstruktor kendaraan yang menginstansiasi kendaraan motor dan mobil
 */
    public Kendaraan() {
    }
    
    
/**
 * Konstruktor kendaraan mengisi jam masuk dengan waktu pada saat konstruktor dijalankan dan otomatis membuat objek transaksi dan objek tarif
 * @param platNomor String 
 */
    public Kendaraan(String platNomor) throws IllegalArgumentException{
        waktu = new Waktu();
        if(platNomor.length()>=4 &platNomor.length()<=8){
        this.platNomor = platNomor;
        }else{
            throw new IllegalArgumentException("Plat nomor minimal 4 digit dan maksimal 8 digit!");
        }
        waktu.setJamMasuk(Instant.now());
        tarif = new Tarif();
        transaksi = new Transaksi(platNomor);
    }
/**
 * Function mengembalikan jam masuk kendaraan
 * @param waktu  Waktu
 * @return waktu jam masuk kendaraan
 */
    public Instant getjamMasuk(Waktu waktu) {
        return waktu.getJamMasuk();
    }
/**
 * Function mengembalikan jam keluar kendaraan
 * @return waktu jam keluar kendaraan
 */
    public Instant getjamKeluar() {
        return waktu.getJamKeluar();
    }
/**
 * Function yang mengembalikan plat nomor kendaraan
 * @return plat nomor kendaraan
 */
    public String getPlatNomor() {
        return platNomor;
    }
/**
 * method untuk mengubah posisi kendaraan menjadi di parkiran
 * @param isDiparkiran boolean
 */
    public void setDiparkiran(boolean isDiparkiran) {
        if (isDiparkiran == false) {
            this.isDiparkiran = true;
        } else {
            System.out.println("kendaraan sudah di parkiran");
        }
    }
 /**
 * method untuk mengubah status kendaraan menjadi lunas
 * @param isLunas boolean
 */   
    public void setLunas(boolean isLunas) {
        this.isLunas = isLunas;
    }
/**
 * Function yang mengembalikan TRUE apabila status lunas
 * @return TRUE bila sudah lunas
 */
    public boolean isLunas() {
        return isLunas;
    }
/**
 * Function yang mengembalikan durasi kendaraan di parkiran
 * @param waktu Waktu
 * @return durasi kendaraan di parkiran
 */
    public long getDurasi(Waktu waktu) {
        waktu.setJamKeluar(Instant.now());
        long dur;
        dur = Duration.between(waktu.getJamMasuk(), waktu.getJamKeluar()).getSeconds();
        return dur;
    }
/**
 * Function yang mengembalikan Tarif kendaraan 
 * @param tarif Tarif
 * @return biaya tarif kendaraan
 */
    public int getBiaya(Tarif tarif) {
        int biaya;
        long duration = getDurasi(waktu);
        int jamAwal = tarif.getJamAwal();
        int jamBerikut = tarif.getJamBerikut();
        if (duration > 1) {
            biaya = (int) (jamAwal + (duration - 1) * jamBerikut);
        } else {
            biaya = jamAwal;
        }
        if(transaksi.isDenda())
        {
            System.out.println("Tarif :"+biaya);
            System.out.println("Denda :"+tarif.getDenda());
            biaya=biaya+tarif.getDenda();
        }
        this.biaya = biaya;
        return biaya;
    }
/**
 * Function ini mengecek apakah kendaraan kena denda atau tidak
 * @return TRUE atau FALSE
 */    
    public boolean isDenda()
    {
        return transaksi.isDenda();
    }
        
/**
 * Ini adalah method bayar yang akan membuat status kendaraan menjadi lunas
 */
    public void bayar() {
        transaksi.setStatus("lunas");
        setLunas(true);
    }
 /**
  * Method yang mengeset jumlah biaya denda
  */   
    public void denda()
    {
        transaksi.setDenda(true);
    }
/**
 * Function yang mengembalikan string riwayat transaksi kendaraan, yakni plat nomor, biaya, jam masuk, jam keluar
 * @return plat nomor, jam masuk, jam keluar, danbiaya tarif parkir
 */
    public String toString() {
        if (waktu.getJamKeluar().equals(null)) {
            return null;
        } else {
            return "Kendaraan : " + getPlatNomor() + " Jam Masuk : " + waktu.getJamMasuk() + " Jam Keluar : " + waktu.getJamKeluar() + " Biayanya : " + biaya;
        }
    }
}
