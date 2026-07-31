package com.creationalPatterns.factory.example2;


public class OdemeFactory {

    public static Odeme olustur(String tur) {
        return switch (tur.toLowerCase()) {
            case "kredikarti" -> new KrediKartiOdeme();
            case "havale" -> new HavaleOdeme();
            case "kripto" -> new KriptoOdeme();
            default -> throw new IllegalArgumentException("Bilinmeyen ödeme türü: " + tur);
        };
    }
}
