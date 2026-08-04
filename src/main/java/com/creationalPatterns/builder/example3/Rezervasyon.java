package com.creationalPatterns.builder.example3;

import java.util.ArrayList;
import java.util.List;

public class Rezervasyon {
    private final String misafirAdi;
    private final String odaTuru;
    private final int geceSayisi;
    private final boolean kahvaltiDahil;
    private final List<String> ozelIstekler;
    private final boolean gecKontrol;
    private Rezervasyon(Builder builder) {
        this.misafirAdi = builder.misafirAdi;
        this.odaTuru = builder.odaTuru;
        this.geceSayisi = builder.geceSayisi;
        this.kahvaltiDahil = builder.kahvaltiDahil;
        this.ozelIstekler = builder.ozelIstekler;
        this.gecKontrol = builder.gecKontrol;
    }
    public void bilgiGoster() {
        System.out.println("Misafir: " + misafirAdi
                + " | Oda: " + odaTuru
                + " | Gece: " + geceSayisi
                + " | Kahvaltı: " + (kahvaltiDahil ? "Var" : "Yok")
                + " | Özel İstekler: " + ozelIstekler
                + " | Geç Check-out: " + (gecKontrol ? "Var" : "Yok"));
    }


    public static class Builder{
        private final String misafirAdi;
        private final String odaTuru;
        private final int geceSayisi;

        private boolean kahvaltiDahil = false;
        private List<String> ozelIstekler = new ArrayList<>();
        private boolean gecKontrol = false;

        public Builder(String misafirAdi, String odaTuru, int geceSayisi) {
            this.misafirAdi = misafirAdi;
            this.odaTuru = odaTuru;
            this.geceSayisi = geceSayisi;
        }
        public Builder kahvaltiEkle(boolean kahvaltiDahil) {
            this.kahvaltiDahil = kahvaltiDahil;
            return this;
        }

        public Builder ozelIstekEkle(String istek) {
            this.ozelIstekler.add(istek);
            return this;
        }

        public Builder gecKontrolEkle(boolean gecKontrol) {
            this.gecKontrol = gecKontrol;
            return this;
        }

        public Rezervasyon build() {
            if (geceSayisi <= 0) {
                throw new IllegalArgumentException("Gece sayısı 0'dan büyük olmalıdır!");
            }
            return new Rezervasyon(this);
        }
    }
}
class Demo {
    public static void main(String[] args) {

        // 1. Basit rezervasyon
        Rezervasyon basitRezervasyon = new Rezervasyon.Builder("Ahmet Yılmaz", "Standart", 2)
                .build();

        // 2. Özel rezervasyon
        Rezervasyon ozelRezervasyon = new Rezervasyon.Builder("Zeynep Kaya", "Suit", 5)
                .kahvaltiEkle(true)
                .ozelIstekEkle("Yüksek kat")
                .ozelIstekEkle("Deniz manzarası")
                .gecKontrolEkle(true)
                .build();

        System.out.println("--- Basit Rezervasyon ---");
        basitRezervasyon.bilgiGoster();

        System.out.println("\n--- Özel Rezervasyon ---");
        ozelRezervasyon.bilgiGoster();

        // 3. Bonus: validasyon testi
        System.out.println("\n--- Validasyon Testi ---");
        try {
            Rezervasyon hataliRezervasyon = new Rezervasyon.Builder("Hatalı Misafir", "Standart", 0)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Hata yakalandı: " + e.getMessage());
        }
    }
}