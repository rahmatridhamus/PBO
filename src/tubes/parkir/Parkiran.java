/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.parkir;

import java.util.ArrayList;

/**
 *
 * @author rahmatridhams
 */
public class Parkiran {

    ArrayList<Kendaraan> KendaraanP = new ArrayList<>();
    private int kapasitas;
    private String namaParkiran;

/**
 * Konstruktor yang mengisi nama parkiran dan kapasitas parkir
 * @param namaParkiran String
 * @param kapasitas int
 */
    public Parkiran(String namaParkiran, int kapasitas) {
        this.namaParkiran = namaParkiran;
        this.kapasitas = kapasitas;
    }
/**
 * Method untuk menambah kendaraan, otomatis mengubah status kendaraan di parkiran dan menambah Nkendaraan
 * @param kendaraan Kendaraan
 */
    public void addKendaraan(Kendaraan kendaraan) {
        
        if (KendaraanP.size() < kapasitas) {
            KendaraanP.add(kendaraan);
           
        }
    }
/**
 * Method untuk mencari kendaraan dengan plat nomornya
 * @param platNomor String
 * @return kendaraan yang dicari berdasarkan plat nomor
 */
    public Kendaraan findKendaraan(String platNomor) {
        for (Kendaraan k : KendaraanP) {
            if (k.getPlatNomor().equals(platNomor)) {
                return k;
            }
        }
        return null;
    }
/**
 * Method untuk menghapus kendaraan apabila statusnya sudah lunas
 * @param kendaraan Kendaraan
 */
    public void removeKendaraan(Kendaraan kendaraan) {
        if (kendaraan.isLunas()) {
            KendaraanP.remove(kendaraan);
        }
    }
/**
 * Function yang mengembalikan TRUE apabila status lunas
 * @param kendaraan
 * @return TRUE apabila lunas, FALSE apabila belum lunas
 */
    public boolean isBayar(Kendaraan kendaraan) {
        return kendaraan.isLunas();
    }
/**
 * Function yang mengembalikan kapasitas parkiran
 * @return kapasitas parkiran
 */
    public int getKapasitas() {
        return kapasitas;
    }
/**
 * Function yang mengembalikan nama parkiran
 * @return nama parkiran String
 */
    public String getNamaParkiran() {
        return namaParkiran;
    }
/**
 * Function yang mengembalikan nama parkiran, kapasitas, status kendaraan
 * @return nama parkiran, kapasitas, status kendaraan
 */
    public String toString() {
        String su = null;
        for (Kendaraan k : KendaraanP) {
            su += "\n" + k.toString();
        }
        return su;
    }
    
    
}
