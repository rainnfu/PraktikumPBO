import kendaraan.Mobil;
import kendaraan.Motor;
import kendaraan.Sepeda;

public class App {
    public static void main(String[] args) {
        // Membuat objek Mobil
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setJumlahPintu(4);
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahKursi(7);
        mobil.setBahanBakar("Bensin");
        mobil.setTahunProduksi(2022);
        mobil.setWarna("Hitam");

        // Menampilkan data mobil
        System.out.println("==== MOBIL ====");
        System.out.println("Merek: " + mobil.getMerek());
        System.out.println("Model: " + mobil.getModel());
        System.out.println("Jumlah Pintu: " + mobil.getJumlahPintu());
        System.out.println("Kapasitas Mesin: " + mobil.getKapasitasMesin());
        System.out.println("Jumlah Kursi: " + mobil.getJumlahKursi());
        System.out.println("Bahan Bakar: " + mobil.getBahanBakar());
        System.out.println("Pajak: Rp" + mobil.hitungPajak());
        System.out.println("Waktu Servis Berikutnya: " + mobil.getWaktuServisBerikutnya());
        mobil.mulai();
        mobil.setKecepatan(60);
        System.out.println("Kecepatan: " + mobil.getKecepatan() + " km/jam");

        // Membuat objek Motor
        Motor motor = new Motor("Honda", "Vario 160");
        motor.setJenisMotor("Skutik");
        motor.setKapasitasTangki(5.5);
        motor.setTipeSuspensi("Teleskopik");
        motor.setTahunProduksi(2023);
        motor.setWarna("Putih");

        System.out.println("\n==== MOTOR ====");
        System.out.println("Merek: " + motor.getMerek());
        System.out.println("Model: " + motor.getModel());
        System.out.println("Jenis Motor: " + motor.getJenisMotor());
        System.out.println("Kapasitas Tangki: " + motor.getKapasitasTangki());
        System.out.println("Tipe Suspensi: " + motor.getTipeSuspensi());
        System.out.println("Pajak: Rp" + motor.hitungPajak());
        motor.mulai();
        motor.setKecepatan(80);
        System.out.println("Kecepatan: " + motor.getKecepatan() + " km/jam");

         // Membuat objek Sepeda
        Sepeda sepeda = new Sepeda("Polygon", "Premier 4");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        sepeda.setTahunProduksi(2021);
        sepeda.setWarna("Merah");
 
        System.out.println("\n==== SEPEDA ====");
        System.out.println("Merek: " + sepeda.getMerek());
        System.out.println("Jenis: " + sepeda.getJenisSepeda());
        System.out.println("Jumlah Gear: " + sepeda.getJumlahGear());
        System.out.println("Ukuran Roda: " + sepeda.getUkuranRoda());
        System.out.println("Pajak: Rp" + sepeda.hitungPajak());
        sepeda.mulai();
        sepeda.setKecepatan(20);
        System.out.println("Kecepatan: " + sepeda.getKecepatan() + " km/jam");

        // Contoh servis
        System.out.println("\n[Servis Motor]");
        if (!motor.periksaKondisi()) {
            motor.lakukanServis();
        }
        System.out.println("Biaya Servis: Rp" + motor.hitungBiayaServis());
    }
}
