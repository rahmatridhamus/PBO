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
public class DaftarPegawai {

    private ArrayList<Pegawai> daftarP = new ArrayList<>();
/**
 * Konstruktor yang menginstansiasi daftar pegawai
 */
    public DaftarPegawai() {
    }
/**
 * Function ini untuk memeriksa apakah daftar kosong atau tidak
 * @return TRUE apabila kosong dan FALSE bila tidak
 */
    public boolean isEmpty()
    {
       return daftarP.isEmpty();
    }
/**
 * Ini adalah method untuk menambah pegawai
 * @param p object pegawai 
 */    
    public void addPegawai(Pegawai p) {
        daftarP.add(p);
    }
/**
 * Method ini digunakan untuk menghapus pegawai
 * @param p object pegawai
 */
    public void removePegawai(Pegawai p) {
        daftarP.remove(p);
    }
/**
 * Method ini berguna untuk mencari pegawai berdasarkan namanya
 * @param name String
 * @return nama pegawai apabila ketemu dan mengembalikan null apabila tidak ketemu
 */
    public Pegawai findPegawai(String name) {
        Pegawai f = null;
        for (Pegawai p : daftarP) {
            if (p.getNamaPegawai().equals(name)) {
                f=p;
            }
        }
        return f;
    }
/**
 * Method ini untuk mencari pegawai berdasarkan username dan passwordnya
 * @param username String
 * @param password String
 * @return daftar pegawai apabila ditemukan dan null apabila tidak ketemu
 */
    public Pegawai findPegawai(String username, String password) {
        Pegawai f = null;
        for (Pegawai p : daftarP) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                f=p;
            }
        }
        return f;
    }
/**
 * Function ini mengembalikan daftar pegawai 
 * @return daftar pegawai
 */
    public String toString() {
        String su = "";
        for (Pegawai p : daftarP) {
            su += p.toString()+"\n";
        }
        return su;
    }

}
