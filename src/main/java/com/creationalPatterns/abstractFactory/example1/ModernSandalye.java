package com.creationalPatterns.abstractFactory.example1;

class ModernSandalye implements Sandalye{
    @Override
    public void oturmaBilgisi() {
        System.out.println("Modern sandalyede oturuluyor - minimal ve sade tasarım.");
    }
}

class ModernMasa implements Masa{

    @Override
    public void masaBilgisi() {
        System.out.println("Modern masa kullanılıyor - cam yüzeyli, ince ayaklı.");
    }
}
// Klasik aile
class KlasikSandalye implements Sandalye {
    @Override
    public void oturmaBilgisi() {
        System.out.println("Klasik sandalyede oturuluyor - oymalı ahşap tasarım.");
    }
}
class KlasikMasa implements Masa {
    @Override
    public void masaBilgisi() {
        System.out.println("Klasik masa kullanılıyor - masif ahşap, detaylı işçilik.");
    }
}