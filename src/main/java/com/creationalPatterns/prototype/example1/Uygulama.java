package com.creationalPatterns.prototype.example1;

public class Uygulama {
    public static void main(String[] args) {
        // Prototip düşman - sadece 1 kere ağır kurulum yapılıyor
        Dusman prototipOrk = new Dusman("Ork", 100);
        prototipOrk.silahEkle("Balta");
        prototipOrk.silahEkle("Kalkan");

        System.out.println("--- Prototip ---");
        prototipOrk.bilgiGoster();

        System.out.println("\n--- Klonlar oluşturuluyor ---");
        Dusman ork1 = prototipOrk.clone();
        Dusman ork2 = prototipOrk.clone();
        Dusman ork3 = prototipOrk.clone();

        // Klonlardan birinin canını değiştirelim
        ork2.canAyarla(50);

        System.out.println("\n--- Klonların Durumu ---");
        ork1.bilgiGoster();
        ork2.bilgiGoster();
        ork3.bilgiGoster();

        System.out.println("\nprototipOrk == ork1 ? " + (prototipOrk == ork1));
    }
}
