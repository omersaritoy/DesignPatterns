package com.creationalPatterns.abstractFactory.example4;

interface Buton {
    void ciz();
}

interface YaziTipi {
    void uygula();
}
// Açık tema ürünleri
class AcikTemaButon implements Buton {
    @Override
    public void ciz() {
        System.out.println("Açık temalı, beyaz zeminli buton çiziliyor.");
    }
}

class AcikTemaYaziTipi implements YaziTipi {
    @Override
    public void uygula() {
        System.out.println("Açık temaya uygun, koyu renkli yazı tipi uygulanıyor.");
    }
}

// Koyu tema ürünleri
class KoyuTemaButon implements Buton {
    @Override
    public void ciz() {
        System.out.println("Koyu temalı, siyah zeminli buton çiziliyor.");
    }
}

class KoyuTemaYaziTipi implements YaziTipi {
    @Override
    public void uygula() {
        System.out.println("Koyu temaya uygun, açık renkli yazı tipi uygulanıyor.");
    }
}
interface TemaFactory{
    Buton butonOlustur();
    YaziTipi yaziTipiOlustur();
}
class AcikTemaFactory implements TemaFactory {
    @Override
    public Buton butonOlustur() {
        return new AcikTemaButon();
    }

    @Override
    public YaziTipi yaziTipiOlustur() {
        return new AcikTemaYaziTipi();
    }

}
class KoyuTemaFactory implements TemaFactory {
    @Override
    public Buton butonOlustur() {
        return new KoyuTemaButon();
    }

    @Override
    public YaziTipi yaziTipiOlustur() {
        return new KoyuTemaYaziTipi();
    }
}
class Uygulama {

    // Bu metod, hangi fabrikayı aldığına bakmaksızın çalışır
    static void temaUygula(TemaFactory factory) {
        Buton buton = factory.butonOlustur();
        YaziTipi yaziTipi = factory.yaziTipiOlustur();

        buton.ciz();
        yaziTipi.uygula();
    }

    public static void main(String[] args) {
        System.out.println("--- Açık Tema Uygulanıyor ---");
        TemaFactory acikTema = new AcikTemaFactory();
        temaUygula(acikTema);

        System.out.println("\n--- Koyu Tema Uygulanıyor ---");
        TemaFactory koyuTema = new KoyuTemaFactory();
        temaUygula(koyuTema);
    }
}
