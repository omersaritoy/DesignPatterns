package com.strucuralPatterns.bridge.example4;


public class Savasci extends Karakter {

    public Savasci(Silah silah) {
        super(silah);
    }

    @Override
    void saldiriYap() {
        System.out.print("Savaşçı saldırıya geçiyor: ");

    }
}
