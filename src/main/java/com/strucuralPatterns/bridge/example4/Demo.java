package com.strucuralPatterns.bridge.example4;

public class Demo {
    public static void main(String[] args) {

        // 1. Savaşçı, kılıç ile
        Karakter savasci = new Savasci(new KilicSilahi());
        savasci.saldiriYap();

        // 2. Büyücü, asa ile
        Karakter buyucu = new Buyucu(new AsaSilahi());
        buyucu.saldiriYap();

        // 3. Bonus: Savaşçının silahını çalışma zamanında değiştiriyoruz
        System.out.println("\n--- Silah değiştiriliyor ---");
        savasci.silahDegistir(new AsaSilahi());
        savasci.saldiriYap();
    }
}