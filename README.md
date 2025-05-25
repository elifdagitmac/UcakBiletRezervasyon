# Uçak Bilet Rezervasyon Uygulaması ✈️

Bu proje, **Java** ile oluşturulmuş basit bir uçak bilet rezervasyon uygulamasıdır.

## 📦 Sınıf Yapısı

- **`Ucak` sınıfı**:  
  Uçağın modeli, seri numarası ve koltuk kapasitesi tanımlanır.

- **`Lokasyon` sınıfı**:  
  Kalkış ve varış noktalarındaki ülke, şehir ve havaalanı bilgileri tanımlanır.

- **`Ucus` sınıfı**:  
  Uçuş saatleri tanımlanır.

## 🔄 Uygulama Akışı

1. Kullanıcı uygulamayı başlatır.
2. Tüm uçuşlar ekrana yazdırılır.
3. Kullanıcı bir uçuş numarası girerek seçim yapar.
4. Yolcunun **ad**, **soyad** ve **yaş** bilgileri alınır.
5. Uçağın koltuk kapasitesi kontrol edilir.
6. Rezervasyon başarılıysa:
   - Başarı mesajı ekrana yazdırılır.
   - Rezervasyon bilgileri `rezervasyonlar.csv` dosyasına kaydedilir.

## 🛠 Kullanılan Teknolojiler

- Java (Temel Sınıf Yapıları, Dosya İşlemleri)
- CSV formatında veri kaydı

---

> Bu uygulama, temel nesne yönelimli programlama (OOP) kavramlarını pekiştirmek için geliştirilmiştir.
