package kendaraan;

import java.util.Date;
import java.util.Calendar;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;
    private boolean berjalan;
    private Date terakhirServis;

    public Mobil(String merek, String model) {
        super(merek, model);
        this.terakhirServis = new Date(); // default waktu servis
        this.kecepatan = 0;
        this.berjalan = false;
    }

    // Getter dan Setter jumlahPintu
    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah;
    }

    // Getter dan Setter kapasitasMesin
    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) {
        this.kapasitasMesin = kapasitas;
    }

    // Getter dan Setter jumlahKursi
    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlah) {
        this.jumlahKursi = jumlah;
    }

    // Getter dan Setter bahanBakar
    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    // Implementasi dari abstract method Kendaraan
    @Override
    public double hitungPajak() {
        // Contoh: Pajak tergantung kapasitas mesin
        if (kapasitasMesin < 1.5) {
            return 1000000;
        } else if (kapasitasMesin <= 2.5) {
            return 2000000;
        } else {
            return 3000000;
        }
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
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
        long enamBulan = 1000L * 60 * 60 * 24 * 30 * 6;
        return new Date().getTime() - terakhirServis.getTime() < enamBulan;
    }

    @Override
    public void lakukanServis() {
        this.terakhirServis = new Date();
        System.out.println("Servis mobil telah dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(terakhirServis);
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        // Biaya servis berdasarkan kapasitas mesin
        return kapasitasMesin * 500000;
    }
}
