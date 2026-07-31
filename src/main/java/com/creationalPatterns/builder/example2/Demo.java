package com.creationalPatterns.builder.example2;

public class Demo {
    public static void main(String[] args) {

        // 1. Sadece zorunlu alanlarla basit pizza
        Pizza basitPizza = new Pizza.Builder("Orta", "İnce")
                .build();

        // 2. Tüm opsiyonel alanlarla özel pizza
        Pizza ozelPizza = new Pizza.Builder("Büyük", "Kalın")
                .peynirMiktari("Bol")
                .malzemeEkle("Mantar")
                .malzemeEkle("Zeytin")
                .malzemeEkle("Sucuk")
                .extraSos(true)
                .build();

        System.out.println("--- Basit Pizza ---");
        basitPizza.bilgiGoster();

        System.out.println("\n--- Özel Pizza ---");
        ozelPizza.bilgiGoster();

        // 3. Bonus: Validasyon testi
        System.out.println("\n--- Validasyon Testi ---");
        try {
            Pizza hataliPizza = new Pizza.Builder("", "İnce").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Hata yakalandı: " + e.getMessage());
        }
    }
}
