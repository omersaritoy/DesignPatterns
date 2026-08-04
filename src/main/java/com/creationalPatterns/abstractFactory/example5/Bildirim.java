package com.creationalPatterns.abstractFactory.example5;

import java.util.ArrayList;
import java.util.List;

interface Bildirim {
    void goster(String mesaj);
}

interface IletisimKutusu {
    void ac(String baslik);
}

class IosBildirim implements Bildirim {

    @Override
    public void goster(String mesaj) {
        System.out.println("[iOS Bildirim]" + mesaj + " - yuvarlak köşeli banner ile gösteriliyor.");
    }
}

class AndroidBildirim implements Bildirim {
    @Override
    public void goster(String mesaj) {
        System.out.println("[Android  Bildirim]" + mesaj + " - material design snackbar ile gösteriliyor.");
    }
}

class IosIletisimKutusu implements IletisimKutusu {

    @Override
    public void ac(String baslik) {
        System.out.println("[iOS Dialog] " + baslik + " - alt taraftan kayan aksiyon menüsü açılıyor.");

    }
}

class AndroidIletisimKutusu implements IletisimKutusu {
    @Override
    public void ac(String baslik) {
        System.out.println("[Android  Dialog] " + baslik + " - ortada material design dialog açılıyor.");
    }
}

interface UIFactory {
    Bildirim bildirimOlustur();

    IletisimKutusu iletisimKutusuOlustur();
}

class IosFactory implements UIFactory {

    @Override
    public Bildirim bildirimOlustur() {
        return new IosBildirim();
    }

    @Override
    public IletisimKutusu iletisimKutusuOlustur() {
        return new IosIletisimKutusu();
    }
}

class AndroidFactory implements UIFactory {

    @Override
    public Bildirim bildirimOlustur() {
        return new AndroidBildirim();
    }

    @Override
    public IletisimKutusu iletisimKutusuOlustur() {
        return new AndroidIletisimKutusu();
    }
}

class Demo {
    static void uiGoster(UIFactory factory) {
        Bildirim bildirim=factory.bildirimOlustur();
        IletisimKutusu iletisimKutusu=factory.iletisimKutusuOlustur();
        bildirim.goster("Yeni mesajınız var");
        iletisimKutusu.ac("Onay");
    }
    public static void main(String[] args) {

        System.out.println("--- iOS Arayüzü ---");
        UIFactory iosFactory = new IosFactory();
        uiGoster(iosFactory);

        System.out.println("\n--- Android Arayüzü ---");
        UIFactory androidFactory = new AndroidFactory();
        uiGoster(androidFactory);

        System.out.println("\n--- Bonus: Liste ile Tüm Fabrikalar ---");
        List<UIFactory> factories = new ArrayList<>();
        factories.add(new IosFactory());
        factories.add(new AndroidFactory());

        for (UIFactory factory : factories) {
            uiGoster(factory);
        }
    }

}
