package com.creationalPatterns.singletonPatterns.example2;


public class Uygulama {
    public static void main(String[] args) {

        ConfigurationManager config1=ConfigurationManager.getInstance();
        System.out.println("Dil: "+config1.ayarGetir("dilAyari"));

        ConfigurationManager config2 = ConfigurationManager.getInstance();
        config2.ayarGuncelle("temaAyari", "acik");
        System.out.println("Config1'den tema: " + config1.ayarGetir("temaAyari"));
        System.out.println("Aynı nesne mi? " + (config1 == config2));

    }
}