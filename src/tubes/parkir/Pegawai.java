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
public class Pegawai {
    private String namaPegawai,username,password;
/**
 * Konstruktor yang mengisi nama pegawai, username dan password
 * @param namaPegawai String
 * @param username String
 * @param password String
 */
    public Pegawai(String namaPegawai, String username, String password) {
        this.namaPegawai = namaPegawai;
        this.username = username;
        this.password = password;
    }
/**
 * Function yang mengembalikan nama pegawai
 * @return nama pegawai
 */
    public String getNamaPegawai() {
        return namaPegawai;
    }
/**
 * Method untuk mengeset nama pegawai
 * @param namaPegawai String
 */
    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }
/**
 * Function yang mengembalikan username pegawai
 * @return username
 */
    public String getUsername() {
        return username;
    }
/**
 * Method untuk mengatur username pegawai
 * @param username String
 */
    public void setUsername(String username) {
        this.username = username;
    }
/**
 * Function yang mengembalikan password pegawai
 * @return password
 */
    public String getPassword() {
        return password;
    }
/**
 * Method untuk mengatur password pegawai
 * @param password String
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Function yang mengembalikan nama pegawai, username dan passwornya
 * @return nama pegawai, username dan password
 */
    @Override
    public String toString() {
        return "Pegawai{" + "namaPegawai=" + namaPegawai + ", username=" + username + ", password=" + password + '}';
    }
    
    
    
}
