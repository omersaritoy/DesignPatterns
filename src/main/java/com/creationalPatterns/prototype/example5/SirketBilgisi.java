package com.creationalPatterns.prototype.example5;

import java.util.ArrayList;
import java.util.List;

public class SirketBilgisi {
    String sirketAdi;
    String adres;

    public SirketBilgisi(String sirketAdi, String adres) {
        this.sirketAdi = sirketAdi;
        this.adres = adres;
    }
}
class Sozlesme implements Cloneable {
    String musteriAdi;
    SirketBilgisi sirketBilgisi;      // REFERANS TİPİ alan
    List<String> maddeler;             // REFERANS TİPİ alan (liste)

    public Sozlesme(String musteriAdi, SirketBilgisi sirketBilgisi, List<String> maddeler) {
        this.musteriAdi = musteriAdi;
        this.sirketBilgisi = sirketBilgisi;
        this.maddeler = maddeler;
    }

    public void bilgiGoster() {
        System.out.println("Müşteri: " + musteriAdi);
        System.out.println("Şirket: " + sirketBilgisi.sirketAdi + " - " + sirketBilgisi.adres);
        System.out.println("Maddeler: " + maddeler);
        System.out.println("---");
    }

    @Override
    public Sozlesme clone() {
//        try {
//            // super.clone() SIĞ KOPYA yapar - şimdilik bunu bilerek bırakıyoruz,
//            // az sonra ne anlama geldiğini göreceğiz
//            return (Sozlesme) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
        try {
            Sozlesme kopya= (Sozlesme) super.clone();
            kopya.sirketBilgisi=new SirketBilgisi(this.sirketBilgisi.sirketAdi,this.sirketBilgisi.adres);
            kopya.maddeler=new ArrayList<>(this.maddeler);
            return kopya;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Uygulama {
    public static void main(String[] args) {

        SirketBilgisi sirket = new SirketBilgisi("ABC Yazılım", "İstanbul");
        List<String> maddeler = new ArrayList<>();
        maddeler.add("Madde 1: Gizlilik");
        maddeler.add("Madde 2: Ödeme koşulları");

        Sozlesme sablon = new Sozlesme("ŞABLON", sirket, maddeler);

        // Şablonu kopyalayarak yeni bir müşteri sözleşmesi oluşturuyoruz
        Sozlesme musteriSozlesmesi = sablon.clone();
        musteriSozlesmesi.musteriAdi = "Ahmet Yılmaz"; // sadece müşteri adını değiştiriyoruz

        System.out.println("--- Klonlama sonrası ---");
        sablon.bilgiGoster();
        musteriSozlesmesi.bilgiGoster();

        // Şimdi SADECE müşteri sözleşmesindeki şirket adresini değiştirelim
        System.out.println("--- musteriSozlesmesi'nin adresi değiştiriliyor ---");
        musteriSozlesmesi.sirketBilgisi.adres = "Ankara";

        // Ve SADECE müşteri sözleşmesine yeni bir madde ekleyelim
        musteriSozlesmesi.maddeler.add("Madde 3: Ekstra hüküm");

        System.out.println("--- Değişiklik sonrası ---");
        sablon.bilgiGoster();
        musteriSozlesmesi.bilgiGoster();
    }
}
