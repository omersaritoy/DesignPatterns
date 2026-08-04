package com.strucuralPatterns.adapter.example2;

// 4. Sistemin zaten native desteklediği ödeme yöntemi (Adapter'e ihtiyaç yok)
class KrediKartiOdeme implements OdemeSistemi {
    @Override
    public void odemeYap(double tutar) {
        System.out.println("Kredi kartından " + tutar + " TL çekiliyor.");
    }
}