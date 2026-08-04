package com.strucuralPatterns.bridge.example4;

public class Buyucu extends Karakter {

    public Buyucu(Silah silah) {
        super(silah);
    }

    @Override
    void saldiriYap() {
        System.out.print("Buyucu saldırıya geçiyor: ");

    }
}
