package com.creationalPatterns.factory.example2;

class KrediKartiOdeme implements Odeme {
    @Override
    public void ode(double tutar) {
        System.out.println("[Kredi Kartı]" + tutar + " TL ödeniyor...");
    }
}

class HavaleOdeme implements Odeme {
    @Override
    public void ode(double tutar) {
        System.out.println("[Havale]" + tutar + " TL ödeniyor...");
    }
}

class KriptoOdeme implements Odeme {
    @Override
    public void ode(double tutar) {
        System.out.println("[Kripto]" + tutar + " TL ödeniyor...");
    }
}


