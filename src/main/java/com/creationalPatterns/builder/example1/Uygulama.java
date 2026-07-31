package com.creationalPatterns.builder.example1;

public class Uygulama {
    public static void main(String[] args) {
        // Sadece zorunlu alanlarla, minimum bir bilgisayar
        Bilgisayar temelBilgisayar = new Bilgisayar.Builder("Intel i5", 8)
                .build();

        // Tüm opsiyonel alanları da doldurarak, üst düzey bir bilgisayar
        Bilgisayar gamingBilgisayar = new Bilgisayar.Builder("Intel i9", 32)
                .disk(1024)
                .ekranKarti("RTX 4090")
                .garantiEkle(true)
                .build();

        temelBilgisayar.bilgiGoster();
        gamingBilgisayar.bilgiGoster();
    }
}