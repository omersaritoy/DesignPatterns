package com.strucuralPatterns.bridge.example4;

abstract public class Karakter {

    protected Silah silah; // KÖPRÜ - kompozisyon

    public Karakter(Silah silah) {
        this.silah = silah;
    }
    abstract void saldiriYap();

    // Bonus: çalışma zamanında silah değiştirme metodu da ekle
    public void silahDegistir(Silah yeniSilah) {
        this.silah = yeniSilah;
    }
}
