package com.creationalPatterns.singletonPatterns.example2;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    //1.Tek nesneyi tutacak statik referans
    private static ConfigurationManager instance;

    //Ayarları tutan örnek bir veri yapısı
    private Map<String,String > ayarlar;

    // 2. Constructor'ı private yapıyoruz -> dışarıdan "new" ile oluşturulamaz
    private ConfigurationManager(){
        ayarlar=new HashMap<>();
        System.out.println("Ayarlar Dosyası okunuyor...");
        //Normalde burada dosyadan/veritabanından okuma yapılır
        ayarlar.put("dilAyari", "tr");
        ayarlar.put("temaAyari", "koyu");
    }

    // 3. Kontrollü erişim noktası
    public static ConfigurationManager getInstance(){
        if(instance==null)
            instance=new ConfigurationManager();

        return instance;
    }
    public String ayarGetir(String anahtar) {
        return ayarlar.get(anahtar);
    }

    public void ayarGuncelle(String anahtar, String deger) {
        ayarlar.put(anahtar, deger);
    }
}

