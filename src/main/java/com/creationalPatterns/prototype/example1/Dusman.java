package com.creationalPatterns.prototype.example1;

import java.util.ArrayList;
import java.util.List;

public class Dusman implements Cloneable {
    private String tur;
    private int can;
    private List<String> silahlar;

    public Dusman(String tur, int can) {
        this.tur = tur;
        this.can = can;
        this.silahlar = new ArrayList<>();
        System.out.println(tur + " için ağır kurulum yapılıyor... (texture, yetenekler yükleniyor)");
    }
    public void silahEkle(String silah) {
        silahlar.add(silah);
    }

    public void canAyarla(int yeniCan) {
        this.can = yeniCan;
    }

    public void bilgiGoster() {
        System.out.println("Tür: " + tur + " | Can: " + can + " | Silahlar: " + silahlar);
    }
    // Doğru Prototype yaklaşımı: constructor çağırmadan, alanları doğrudan kopyala
    @Override
    public Dusman clone() {
        try {
            Dusman kopya = (Dusman) super.clone(); // sığ kopya alır (alanları kopyalar, constructor çalışmaz)
            kopya.silahlar = new ArrayList<>(this.silahlar); // listeyi deep copy yapıyoruz
            return kopya;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
