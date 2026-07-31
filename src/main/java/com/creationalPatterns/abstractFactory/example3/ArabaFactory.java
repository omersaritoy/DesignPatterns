package com.creationalPatterns.abstractFactory.example3;

import java.util.ArrayList;
import java.util.List;

interface AracFactory  {
    Araba arabaOlustur();
    Motor motorOlustur();
    Lastik lastikOlustur();
}

class TeslaFactory implements AracFactory {

    @Override
    public Araba arabaOlustur() {
        return new TeslaAraba();
    }

    @Override
    public Motor motorOlustur() {
        return new TeslaMotor();
    }

    @Override
    public Lastik lastikOlustur() {
        return new TeslaLastik();
    }
}
class ToyotaFactory implements AracFactory  {

    @Override
    public Araba arabaOlustur() {
        return new ToyotaAraba();
    }

    @Override
    public Motor motorOlustur() {
        return new ToyotaMotor();
    }

    @Override
    public Lastik lastikOlustur() {
        return new ToyotaLastik();
    }
}

class AracUretimi {

    static void aracUret(AracFactory factory) {
        Araba araba = factory.arabaOlustur();
        Motor motor = factory.motorOlustur();
        Lastik lastik = factory.lastikOlustur();

        araba.surus();
        motor.calistir();
        lastik.yolTutus();
    }
}

class Demo {
    public static void main(String[] args) {

        System.out.println("--- Tesla Üretimi ---");
        AracFactory teslaFactory = new TeslaFactory();
        AracUretimi.aracUret(teslaFactory);

        System.out.println("\n--- Toyota Üretimi ---");
        AracFactory toyotaFactory = new ToyotaFactory();
        AracUretimi.aracUret(toyotaFactory);

        System.out.println("\n--- Bonus: Tüm Fabrikalar Listede, Tek Döngü ---");
        List<AracFactory> factories = new ArrayList<>();
        factories.add(new TeslaFactory());
        factories.add(new ToyotaFactory());

        for (AracFactory factory : factories) {
            AracUretimi.aracUret(factory);
        }
    }
}