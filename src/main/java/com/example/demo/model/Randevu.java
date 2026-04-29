package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "randevular") // Veritabanındaki tablo adınla aynı olmalı
public class Randevu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_soyad") // SQL'deki ad_soyad ile eşleştirdik
    private String adSoyad;

    private String telefon;
    
    private LocalDate tarih;
    
    private LocalTime saat;

    @Column(name = "hizmet_tipi")
    private String hizmetTipi;

    private String durum;

    @Column(name = "notlar") // SQL'de 'notlar' yazıyor, Java'da da öyle yaptık
    private String notlar;

    // Getter ve Setter Metotları (Sağ tık -> Source -> Generate Getters and Setters yapabilirsin)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }
    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public LocalDate getTarih() { return tarih; }
    public void setTarih(LocalDate tarih) { this.tarih = tarih; }
    public LocalTime getSaat() { return saat; }
    public void setSaat(LocalTime saat) { this.saat = saat; }
    public String getHizmetTipi() { return hizmetTipi; }
    public void setHizmetTipi(String hizmetTipi) { this.hizmetTipi = hizmetTipi; }
    public String getDurum() { return durum; }
    public void setDurum(String durum) { this.durum = durum; }
    public String getNotlar() { return notlar; }
    public void setNotlar(String notlar) { this.notlar = notlar; }
}