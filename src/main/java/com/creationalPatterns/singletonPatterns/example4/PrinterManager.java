package com.creationalPatterns.singletonPatterns.example4;

import java.util.ArrayList;
import java.util.List;

public class PrinterManager {

    private static PrinterManager instance;
    private List<String> kayitlar;
    private PrinterManager(){
        kayitlar = new ArrayList<>();
        System.out.println("Yazıcı bağlantısı kuruldu.");
    }

    public static PrinterManager getInstance(){
        if(instance==null)
            instance=new PrinterManager();
        return instance;
    }
    public void yazdir(String belge) {
        System.out.println("[Yazıcı] " + belge + " yazdırılıyor...");
        kayitlar.add(belge);
    }
    public void kuyrukBilgisi() {
        System.out.println("Toplam yazdırılan belge sayısı: " + kayitlar.size());
    }
}
class Uygulama {
    public static void main(String[] args) {
        PrinterManager p1 = PrinterManager.getInstance();
        p1.yazdir("Rapor.docx");

        PrinterManager p2 = PrinterManager.getInstance();
        p2.yazdir("Fatura.pdf");

        PrinterManager p3 = PrinterManager.getInstance();
        p3.yazdir("Sunum.pptx");

        p1.kuyrukBilgisi();

        System.out.println("p1 == p2 ? " + (p1 == p2));
        System.out.println("p2 == p3 ? " + (p2 == p3));
    }
}
