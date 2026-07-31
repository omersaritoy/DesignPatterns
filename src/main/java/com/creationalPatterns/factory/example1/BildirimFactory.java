package com.creationalPatterns.factory.example1;

public class BildirimFactory {
    public static Bildirim olustur(String tur){
        return switch (tur.toLowerCase()) {
            case "email" -> new EmailBildirim();
            case "sms" -> new SmsBildirim();
            case "push" -> new PushBildirim();
            default -> throw new IllegalArgumentException("Bilinmeyen bildirim türü: " + tur);
        };
    }
}
