package kendaraan;

import java.util.Calendar;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak,IServiceable{
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;
    private boolean berjalan;
    private Date terakhirServis;

    public Motor(String merek, String model) {
        super(merek, model);
        this.terakhirServis = new Date(); // default waktu servis
        this.kecepatan = 0;
        this.berjalan = false;
    }

    public String getJenisMotor(){
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor){
        this.jenisMotor = jenisMotor;
    }

    public double getKapasitasTangki(){
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki){
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi(){
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi){
        this.tipeSuspensi = tipeSuspensi;
    }

    //Abstract method dari Kendaraan

    @Override
    public double hitungPajak(){
        //Contoh pajak berdsarkan kapasitas tangkinya.
    return 100000 + (kapasitasTangki * 5000);
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
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
        long duaBulan = 1000L * 60 * 60 * 24 * 30 * 2;
        return new Date().getTime() - terakhirServis.getTime() < duaBulan;
    }

    @Override
    public void lakukanServis() {
        this.terakhirServis = new Date();
        System.out.println("Servis motor telah dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(terakhirServis);
        cal.add(Calendar.MONTH, 2);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 250000;
    }
}

    
