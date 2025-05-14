package kendaraan;

import java.util.Date;
import java.util.Calendar;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;
    private boolean berjalan;
    private Date terakhirServis;

    public Sepeda(String merek, String model) {
        super(merek, model);
        this.terakhirServis = new Date();
        this.kecepatan = 0;
        this.berjalan = false;
    }

    // Getter dan Setter jenisSepeda
    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenis) {
        this.jenisSepeda = jenis;
    }

    // Getter dan Setter jumlahGear
    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlah) {
        this.jumlahGear = jumlah;
    }

    // Getter dan Setter ukuranRoda
    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuran) {
        this.ukuranRoda = ukuran;
    }

    // Implementasi abstract dari Kendaraan
    @Override
    public double hitungPajak() {
        // Pajak sepeda biasanya sangat kecil
        return 50000; // contoh nilai pajak tetap
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    // Implementasi IBergerak
    @Override
    public boolean mulai() {
        berjalan = true;
        return true;
    }

    @Override
    public boolean berhenti() {
        berjalan = false;
        kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (berjalan) {
            this.kecepatan = kecepatan;
        }
    }

    // Implementasi IServiceable
    @Override
    public boolean periksaKondisi() {
        long tigaBulan = 1000L * 60 * 60 * 24 * 30 * 3;
        return new Date().getTime() - terakhirServis.getTime() < tigaBulan;
    }

    @Override
    public void lakukanServis() {
        this.terakhirServis = new Date();
        System.out.println("Sepeda telah diservis.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(terakhirServis);
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        // Biaya servis tetap, lebih murah dari mobil
        return 150000;
    }
}
