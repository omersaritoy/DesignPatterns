package com.strucuralPatterns.adapter.example2;

public class Uygulama {
    public static void main(String[] args) {

        OdemeSistemi krediKarti = new KrediKartiOdeme();
        krediKarti.odemeYap(250.0);

        OdemeSistemi eskiBanka = new EskiBankaAdapter();
        eskiBanka.odemeYap(500.0);
    }
}
