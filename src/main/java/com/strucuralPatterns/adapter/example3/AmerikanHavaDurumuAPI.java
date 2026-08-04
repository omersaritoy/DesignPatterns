package com.strucuralPatterns.adapter.example3;

public class AmerikanHavaDurumuAPI {
    public double sicakligiFahrenheitGetir(String sehirKodu) {
        // Örnek: "Istanbul" için sabit bir değer döndürsün, gerçek API çağrısı gibi düşün
        System.out.println("Amerikan API'den " + sehirKodu + " için Fahrenheit veri çekiliyor...");
        return 68.0; // örnek sabit değer (Fahrenheit)
    }
}
