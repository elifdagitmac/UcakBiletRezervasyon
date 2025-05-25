import java.util.*;
import java.io.*;

// Entity Classes
class Ucak {
    String model;
    String marka;
    String seriNo;
    int koltukKapasitesi;

    public Ucak(String model, String marka, String seriNo, int koltukKapasitesi) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.koltukKapasitesi = koltukKapasitesi;
    }

   
    public String toString() {
        return marka + " " + model + " (" + seriNo + ") - Koltuk Kapasitesi: " + koltukKapasitesi;
    }
}

class Lokasyon {
    String ulke;
    String sehir;
    String havaalani;
    boolean aktif;

    public Lokasyon(String ulke, String sehir, String havaalani, boolean aktif) {
        this.ulke = ulke;
        this.sehir = sehir;
        this.havaalani = havaalani;
        this.aktif = aktif;
    }

    @Override
    public String toString() {
        return sehir + " - " + havaalani + (aktif ? " (Aktif)" : " (Pasif)");
    }
}

class Ucus {
    Lokasyon kalkis;
    Lokasyon varis;
    String saat;
    String bilgi;

    public Ucus(Lokasyon kalkis, Lokasyon varis, String saat, String bilgi) {
        this.kalkis = kalkis;
        this.varis = varis;
        this.saat = saat;
        this.bilgi = bilgi;
    }

    @Override
    public String toString() {
        return bilgi + " - Saat: " + saat;
    }
}

class Rezervasyon {
    Ucus ucus;
    String ad;
    String soyad;
    int yas;

    public Rezervasyon(Ucus ucus, String ad, String soyad, int yas) {
        this.ucus = ucus;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
    }

    @Override
    public String toString() {
        return ad + " " + soyad + " - Yaş: " + yas + " - Uçuş: " + ucus;
    }
}

public class UcakBiletRezervasyon {
    public static void main(String[] args) throws IOException {
        List<Ucak> ucaklar = new ArrayList<>();
        List<Lokasyon> lokasyonlar = new ArrayList<>();
        List<Ucus> ucuslar = new ArrayList<>();
        List<Rezervasyon> rezervasyonlar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Verileri manuel oluşturuyoruz
        Ucak ucak = new Ucak("737", "Boeing", "SN123", 150);
        ucaklar.add(ucak);

        Lokasyon ist = new Lokasyon("Türkiye", "İstanbul", "IST", true);
        Lokasyon ank = new Lokasyon("Türkiye", "Ankara", "ESB", true);
        lokasyonlar.add(ist);
        lokasyonlar.add(ank);

        Ucus ucus = new Ucus(ist, ank, "10:00", "İstanbul -> Ankara");
        ucuslar.add(ucus);

        // Kullanıcıya uçuş bilgilerini göster
        System.out.println("Mevcut Uçuşlar:");
        for (int i = 0; i < ucuslar.size(); i++) {
            System.out.println(i + ". " + ucuslar.get(i));
        }

        // Kullanıcıdan seçim al
        System.out.print("Rezervasyon yapmak istediğiniz uçuş numarasını girin: ");
        int secim = scanner.nextInt();
        scanner.nextLine();

        // Yolcu bilgilerini al
        System.out.print("Adınız: ");
        String ad = scanner.nextLine();
        System.out.print("Soyadınız: ");
        String soyad = scanner.nextLine();
        System.out.print("Yaşınız: ");
        int yas = scanner.nextInt();

        if (ucak.koltukKapasitesi <= rezervasyonlar.size()) {
            System.out.println("Üzgünüz, bu uçak için boş koltuk yok.");
            return;
        }

        Rezervasyon rezervasyon = new Rezervasyon(ucuslar.get(secim), ad, soyad, yas);
        rezervasyonlar.add(rezervasyon);

        // Dosyaya kaydet (CSV)
        try (FileWriter writer = new FileWriter("rezervasyonlar.csv", true)) {
            writer.write(rezervasyon.ad + "," + rezervasyon.soyad + "," + rezervasyon.yas + "," + rezervasyon.ucus.bilgi + "," + rezervasyon.ucus.saat + "\n");
        }

        System.out.println("Rezervasyon başarıyla yapıldı ve dosyaya kaydedildi.");
    }
}

