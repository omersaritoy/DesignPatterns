package com.creationalPatterns.singletonPatterns.example6;

import java.util.*;

public class OdaYoneticisi {
    //Görünürlük garantisi-Sıralama garantisi
    private static volatile OdaYoneticisi instance;

    private Map<String, List<String>> odalar;

    private OdaYoneticisi() {
        this.odalar = new HashMap<>();
    }

    public static OdaYoneticisi getInstance() {
        if (instance == null) {
            synchronized (OdaYoneticisi.class) {
                if (instance == null)
                    instance = new OdaYoneticisi();
            }
        }
        return instance;
    }

    public void odaOlustur(String odaAdi) {
        if (odalar.containsKey(odaAdi)) {
            System.out.println("Bu oda zaten mevcut: " + odaAdi);
            return;
        }
        odalar.put(odaAdi, new ArrayList<>());
    }

    public void odayaKatil(String odaAdi, String oyuncuAdi) {
        if (!odalar.containsKey(odaAdi))
            throw new IllegalArgumentException("Oda bulunamadı: " + odaAdi);

        odalar.get(odaAdi).add(oyuncuAdi);
    }

    public void odadanAyril(String odaAdi, String oyuncuAdi) {
        if (!odalar.containsKey(odaAdi))
            return;

        odalar.get(odaAdi).remove(oyuncuAdi);
    }

    public void odaDurumu(String odaAdi) {
        List<String> oyuncular = odalar.get(odaAdi);
        if (oyuncular == null) {
            System.out.println(odaAdi + " odası bulunamadı.");
            return;
        }
        System.out.println(odaAdi + " - Oyuncu sayısı: " + oyuncular.size() + " - Oyuncular: " + oyuncular);
    }
}
class Demo {
    public static void main(String[] args) throws InterruptedException {

        OdaYoneticisi yonetici = OdaYoneticisi.getInstance();

        yonetici.odaOlustur("Oda1");
        yonetici.odaOlustur("Oda2");

        yonetici.odayaKatil("Oda1", "Ali");
        yonetici.odayaKatil("Oda1", "Veli");
        yonetici.odayaKatil("Oda1", "Ayşe");

        yonetici.odayaKatil("Oda2", "Fatma");

        yonetici.odaOlustur("Oda1"); // zaten var mesajı

        try {
            yonetici.odayaKatil("Oda3", "Mehmet");
        } catch (IllegalArgumentException e) {
            System.out.println("Hata yakalandı: " + e.getMessage());
        }

        yonetici.odadanAyril("Oda1", "Ali");

        yonetici.odaDurumu("Oda1");
        yonetici.odaDurumu("Oda2");

        // Bonus: iki thread aynı anda getInstance() çağırıyor
        Runnable gorev = () -> {
            OdaYoneticisi ref = OdaYoneticisi.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + (ref == yonetici));
        };

        Thread t1 = new Thread(gorev);
        Thread t2 = new Thread(gorev);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}