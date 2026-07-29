package com.creationalPatterns.singletonPatterns.example3;

public class Uygulama {
    public static void main(String[] args) {
        SiparisServisi siparis = new SiparisServisi();
        OdemeServisi odeme = new OdemeServisi();

        siparis.siparisOlustur();
        odeme.odemeYap();

        // Doğrudan da erişebiliriz
        Logger logger = Logger.getInstance();
        logger.log("Uygulama kapatılıyor.");

        logger.tumLoglariGoster();
    }
}