package com.strucuralPatterns.adapter.example3;

import java.util.ArrayList;
import java.util.List;

public class Uygulama {
    public static void main(String[] args) {
        List<HavaDurumuServisi> servisler = new ArrayList<>();
        servisler.add(new YerelHavaDurumuServisi());
        servisler.add(new AmerikanHavaDurumuAdapter());

        for (HavaDurumuServisi servis : servisler) {
            double sicaklik = servis.sicakligiGetir("Istanbul");
            System.out.println("Sıcaklık: " + sicaklik + " °C");
        }
    }
}
