/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.parkir;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rahmatridhams
 */
public class TubesParkir {

    Scanner input = new Scanner(System.in);
    Scanner inputS = new Scanner(System.in);

    private String s;

    /**
     * Function yang mengembalikan pilihan yakni user
     *
     * @return pilihan petugas atau manager
     */
    public int menuUser() {
        System.out.println("1. Petugas");
        System.out.println("2. Manager");
        System.out.println("Pilih User : ");
        int pil = input.nextInt();
        if (pil == 1 || pil == 2) {
            return pil;
        } else {
            throw new InputMismatchException("Pilihan tidak ada");
        }
    }

    /**
     * Function yang mengembalikan pilihan motor, mobil atau kembali
     *
     * @return motor apabila memilih nomor 1, mobil apabila nomor 2, dan kembali
     * apabila nomor 3
     */
    public int motormob() {
        System.out.println("1. Motor ");
        System.out.println("2. Mobil");
        System.out.println("3. Back");
        System.out.println("Pilih kendaraan : ");
        int pil = input.nextInt();
        return pil;
    }

    /**
     * Function yang mengembalikan piihan dari menu Petugas yang dipilih
     *
     * @param parkirMobil ParkiranMobil
     * @param parkirMotor ParkiranMotor
     * @param tubes TubesParkir
     * @return pilihan
     */
    public int menuPetugas(ParkiranMobil parkirMobil, ParkiranMotor parkirMotor, TubesParkir tubes) {
        System.out.println("Parkir Motor Tersedia : " + tubes.parkirRemaining(parkirMotor));
        System.out.println("Parkir Mobil Tersedia : " + tubes.parkirRemaining(parkirMobil));
        System.out.println("1. Tambah Kendaraan ");
        System.out.println("2. Keluarkan Kendaraan");
        System.out.println("3. History Transaksi");
        System.out.println("4. Logout");
        System.out.println("Pilih Pilihan : ");
        int pilu = input.nextInt();
        return pilu;
    }

    /**
     * Function yang mengembalikan pilihan dari menu manager
     *
     * @param parkirMobil ParkiranMobil
     * @param parkirMotor ParkiranMotor
     * @param tubes Tubesparkir
     * @return pilihan
     */
    public int menuManager(ParkiranMobil parkirMobil, ParkiranMotor parkirMotor, TubesParkir tubes) {
        System.out.println("Parkir Motor Tersedia : " + tubes.parkirRemaining(parkirMotor));
        System.out.println("Parkir Mobil Tersedia : " + tubes.parkirRemaining(parkirMobil));
        System.out.println("1. Tambah Pegawai");
        System.out.println("2. Daftar Pegawai");
        System.out.println("3. History Transaksi");
        System.out.println("4. Logout");
        System.out.println("Pilih Pilihan : ");
        int pil = input.nextInt();
        return pil;
    }

    /**
     * Method untuk menambah pegawai dengan memasukkan nama, username, dan
     * password
     *
     * @param tubes TubesParkir
     * @param parkirMobil ParkiranMobil
     * @param parkirMotor ParkiranMotor
     * @param daftarPegawai DaftarPegawai
     */
    public void addPegawaian(TubesParkir tubes, ParkiranMobil parkirMobil, ParkiranMotor parkirMotor, DaftarPegawai daftarPegawai) {
        Pegawai peg;
        System.out.println("Masukkan nama lengkap pegawai : ");
        String name = inputS.nextLine();
        System.out.println("Masukkan username : ");
        String usrname = inputS.nextLine();
        System.out.println("Masukkan password : ");
        String pass = inputS.nextLine();
        System.out.println("Confirm password : ");
        String passcon = inputS.nextLine();
        if (pass.equals(passcon)) {
            System.out.println("Nama Lengkap :" + name);
            System.out.println("Username :" + usrname);
            System.out.println("Apakah anda yakin?(y/n)");
            String yakin = inputS.nextLine();
            if (yakin.equals("y")) {
                peg = new Pegawai(name, usrname, passcon);
                System.out.println("objek terbuat");
                daftarPegawai.addPegawai(peg);
                System.out.println("objek nambah");
            } else {
            }
        } else {
            System.out.println("Password not match");
            tubes.menuManager(parkirMobil, parkirMotor, tubes);
        }
    }

    /**
     * Function yang mengembalikan tempat kosong di parkiran
     *
     * @param p Parkiran
     * @return rem
     */
    public int parkirRemaining(Parkiran p) {
        int rem = p.getKapasitas() - p.KendaraanP.size();
        return rem;
    }

    /**
     * Method untuk memasukkan nama pegawai, usename, dan password, memasukkan
     * atau mengeluarkan motor atau mobil, memasukkan plat nomor kendaraan,
     * mengetahui kendaraan sudah bayar atau belum, lunas atau belum, serta
     * menghitung biaya tarif parkir dan denda
     *
     * @param tubes Tubesparkir
     * @param parkirMobil ParkiranMobil
     * @param parkirMotor ParkiranMotor
     * @param tarifMotor Tarif
     * @param tarifMobil Tarif
     * @param daftarPegawai DaftarPegawai
     */
    public void play(TubesParkir tubes, ParkiranMobil parkirMobil, ParkiranMotor parkirMotor, Tarif tarifMotor, Tarif tarifMobil, DaftarPegawai daftarPegawai) {
        int pil0 = 0;
        int pil1 = 0;
        int pil2 = 0;
        int pil3 = 0;

        KendaraanMobil mob;
        KendaraanMotor mot;
        try {
            pil0 = tubes.menuUser();
            while (pil0 < 4) {
                if (pil0 == 1) {

                    System.out.println("Masukkan Username : ");
                    String usrnmPetugas = inputS.nextLine();
                    System.out.println("Masukkan Password : ");
                    String psswrdPetugas = inputS.nextLine();
                    Pegawai p = daftarPegawai.findPegawai(usrnmPetugas, psswrdPetugas);
                    if (p != null) {
                        System.out.println("Selamat Datang " + p.getNamaPegawai());

                        while (pil1 < 4) {
                            pil1 = tubes.menuPetugas(parkirMobil, parkirMotor, tubes);
                            switch (pil1) {
                                case 1:
                                    pil2 = tubes.motormob();
                                    if (pil2 == 1) {
                                        System.out.println("Masukkan plat nomor : ");
                                        String plat = inputS.nextLine();
                                        Kendaraan k = new Kendaraan();
                                        k = parkirMotor.findKendaraan(plat);
                                        if (k == null) {
                                            if (tubes.parkirRemaining(parkirMotor) == 0) {
                                                System.out.println("Parkiran sudah penuh");
                                            } else {
                                                try {
                                                    mot = new KendaraanMotor(plat);
                                                    parkirMotor.addKendaraan(mot);
                                                } catch (IllegalArgumentException e) {
                                                    System.out.println("Plat nomor minimal 4 digit dan maksimal 8 digit!");
                                                    break;
                                                }
                                            }
                                        } else {
                                            System.out.println("Plat nomor sudah pernah diinput!");
                                        }
                                    } else if (pil2 == 2) {
                                        System.out.println("Masukkan plat nomor : ");
                                        String plat = inputS.nextLine();
                                        Kendaraan k = new Kendaraan();
                                        k = parkirMobil.findKendaraan(plat);
                                        if (k == null) {
                                            if (tubes.parkirRemaining(parkirMobil) == 0) {
                                                System.out.println("Parkiran sudah penuh!");
                                            } else {
                                                try {
                                                    mob = new KendaraanMobil(plat);
                                                    parkirMobil.addKendaraan(mob);
                                                } catch (IllegalArgumentException e) {
                                                    System.out.println("Plat nomor minimal 4 digit dan maksimal 8 digit!");
                                                    break;
                                                }

                                            }
                                        } else {
                                            System.out.println("Plat nomor sudah pernah diinput!");
                                        }
                                    } else if (pil2 == 3) {
                                        break;
                                    }
                                    break;

                                case 2:
                                    if (parkirMobil.KendaraanP.isEmpty() && parkirMotor.KendaraanP.isEmpty()) {
                                        System.out.println("Kendaraan belum ada");
                                    } else {
                                        pil3 = tubes.motormob();
                                        String plats = "";
                                        if (pil3 != 3) {
                                            System.out.println("Masukkan plat nomor : ");
                                            plats = inputS.nextLine();
                                        }
                                        if (pil3 == 1) {
                                            KendaraanMotor temp = (KendaraanMotor) parkirMotor.findKendaraan(plats);
                                            if (temp == null) {
                                                System.out.println("Kendaraan belum ada");
                                            } else {
                                                String yorn = "";
                                                if (!temp.isDenda()) {
                                                    System.out.println("Denda?(y/n)");
                                                    yorn = inputS.nextLine();
                                                    if (yorn.equals("y")) {
                                                        temp.denda();
                                                        System.out.println("Total : " + temp.getBiaya(tarifMotor)); //try catch detected
                                                    } else {
                                                        System.out.println("Tarif : " + temp.getBiaya(tarifMotor)); //try catch detected
                                                    }
                                                }

                                                System.out.println("sudah bayar?(y/n) : ");
                                                yorn = inputS.nextLine();
                                                if (yorn.equals("y")) {
                                                    temp.bayar();
                                                    if (this.s == null) {
                                                        this.s = temp.toString() + " Pegawai : " + p.getNamaPegawai();
                                                    } else {
                                                        this.s += "\n" + temp.toString() + " Pegawai : " + p.getNamaPegawai();
                                                    }
                                                    parkirMotor.removeKendaraan(temp);

                                                } else {
                                                    temp.setLunas(false);
                                                    System.out.println("Belum lunas");
                                                    tubes.menuPetugas(parkirMobil, parkirMotor, tubes);
                                                }
                                            }
                                        } else if (pil3 == 2) {
                                            KendaraanMobil temp1 = (KendaraanMobil) parkirMobil.findKendaraan(plats);
                                            String yorn1 = "";
                                            if (!temp1.isDenda()) {
                                                System.out.println("Denda?(y/n)");
                                                yorn1 = inputS.nextLine();
                                                if (yorn1.equals("y")) {
                                                    temp1.denda();
                                                    System.out.println("Total : " + temp1.getBiaya(tarifMobil)); //try catch detected
                                                } else {
                                                    System.out.println("Tarif : " + temp1.getBiaya(tarifMobil)); //try catch detected
                                                }
                                            }

                                            System.out.println("sudah bayar?(y/n) : ");
                                            yorn1 = inputS.nextLine();
                                            if (yorn1.equals("y")) {
                                                temp1.bayar();
                                                if (this.s == null) {
                                                    this.s = temp1.toString() + " Pegawai : " + p.getNamaPegawai();
                                                } else {
                                                    this.s += "\n" + temp1.toString() + " Pegawai : " + p.getNamaPegawai();
                                                }
                                                parkirMobil.removeKendaraan(temp1);
                                            } else {
                                                temp1.setLunas(false);
                                                System.out.println("Belum lunas");
                                                tubes.menuPetugas(parkirMobil, parkirMotor, tubes);
                                            }

                                        } else if (pil3 == 3) {
                                            break;
                                        }

                                        break;
                                    }

                                case 3:
                                    if (s == null) {
                                        System.out.println("History belum ada");
                                    } else {
                                        System.out.println(s);
                                    }
                                    break;

                                case 4:
                                    tubes.play(tubes, parkirMobil, parkirMotor, tarifMotor, tarifMobil, daftarPegawai);
                                    break;
                                default:
                                    System.out.println("Option doesn't exist!!");
                                    tubes.menuPetugas(parkirMobil, parkirMotor, tubes);
                            }
                        }
                    } else {
                        System.out.println("User and password doesn't exist");
                        pil0 = tubes.menuUser();
                    }

                } else if (pil0 == 2) {
                    System.out.println("Masukkan Username : ");
                    String usrnmManager = inputS.nextLine();
                    System.out.println("Masukkan Password : ");
                    String psswrdManager = inputS.nextLine();

                    if (usrnmManager.equals("admin") && usrnmManager.equals(psswrdManager)) {
                        System.out.println("Selamat Datang " + usrnmManager);
                        while (pil1 < 4) {
                            pil1 = tubes.menuManager(parkirMobil, parkirMotor, tubes);
                            switch (pil1) {
                                case 1:
                                    tubes.addPegawaian(tubes, parkirMobil, parkirMotor, daftarPegawai);
                                    break;
                                case 2:
                                    if (daftarPegawai.isEmpty()) {
                                        System.out.println("Daftar Pegawai belum ada");
                                    } else {
                                        System.out.println(daftarPegawai.toString());
                                    }
                                    break;
                                case 3:
                                    System.out.println(s);
                                    break;
                                case 4:
                                    tubes.play(tubes, parkirMobil, parkirMotor, tarifMotor, tarifMobil, daftarPegawai);
                                    break;
                                default:
                                    System.out.println("Option doesn't exist!!");
                                    tubes.menuManager(parkirMobil, parkirMotor, tubes);
                            }

                        }
                    } else {
                        System.out.println("User and password doesn't exist");
                        pil0 = tubes.menuUser();
                    }
                } else {
                    System.out.println("Option doesn't exist!!");
                    tubes.play(tubes, parkirMobil, parkirMotor, tarifMotor, tarifMobil, daftarPegawai);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Pilihan tidak ada!");
            System.out.println(tubes.menuUser());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputS = new Scanner(System.in);
        // TODO code application logic here
        System.out.println("================================");
        System.out.println("APPLIKASI PARKIR ABAL-ABAL");
        System.out.println("BY KELOMPOK PBO IF 37 03");
        System.out.println("WAJIB BAWA STNK YAA!!!");
        System.out.println("================================");

        DaftarPegawai daftarPeg = new DaftarPegawai();
        ParkiranMobil parkirMobil = new ParkiranMobil("parkirCar", 10);
        ParkiranMotor parkirMotor = new ParkiranMotor("parkirMtr", 5);
        Pegawai p = new Pegawai("aulia", "aulia", "123");
        daftarPeg.addPegawai(p);

        TarifMobil tarifMobil = new TarifMobil();
        tarifMobil.setJamAwal(250);
        tarifMobil.setJamBerikut(200);
        tarifMobil.setDenda(500);

        TarifMotor tarifMotor = new TarifMotor();
        tarifMotor.setJamAwal(150);
        tarifMotor.setJamBerikut(100);
        tarifMotor.setDenda(500);
        TubesParkir tubes = new TubesParkir();
        tubes.play(tubes, parkirMobil, parkirMotor, tarifMotor, tarifMobil, daftarPeg);

    }
}
