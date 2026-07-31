package com.creationalPatterns.builder.example1;

public class Bilgisayar {
    // Zorunlu alanlar
    private final String islemci;
    private final int ram;

    // Opsiyonel alanlar
    private final int disk;
    private final String ekranKarti;
    private final boolean garantiVar;

    // Constructor private -> dışarıdan direkt new ile oluşturulamaz
    private Bilgisayar(Builder builder) {
        this.islemci = builder.islemci;
        this.ram = builder.ram;
        this.disk = builder.disk;
        this.ekranKarti = builder.ekranKarti;
        this.garantiVar = builder.garantiVar;
    }
    public void bilgiGoster() {
        System.out.println("İşlemci: " + islemci
                + " | RAM: " + ram + "GB"
                + " | Disk: " + disk + "GB"
                + " | Ekran Kartı: " + (ekranKarti == null ? "Yok" : ekranKarti)
                + " | Garanti: " + (garantiVar ? "Var" : "Yok"));
    }
    // Builder statik iç sınıf olarak tanımlanır
    public static class Builder {
        // Zorunlu alanlar - Builder constructor'ında istenir
        private final String islemci;
        private final int ram;

        // Opsiyonel alanlar - varsayılan değerlerle başlar
        private int disk = 256; // varsayılan disk boyutu
        private String ekranKarti = null; // varsayılan: yok
        private boolean garantiVar = false; // varsayılan: garanti yok

        public Builder(String islemci, int ram) {
            this.islemci = islemci;
            this.ram = ram;
        }

        public Builder disk(int disk) {
            this.disk = disk;
            return this; // zincirleme için kendini döndürüyor
        }

        public Builder ekranKarti(String ekranKarti) {
            this.ekranKarti = ekranKarti;
            return this;
        }

        public Builder garantiEkle(boolean garantiVar) {
            this.garantiVar = garantiVar;
            return this;
        }

        public Bilgisayar build() {
            // İstersek burada validasyon da yapabiliriz
            if (ram <= 0) {
                throw new IllegalArgumentException("RAM 0'dan büyük olmalı!");
            }
            return new Bilgisayar(this);
        }
    }


}