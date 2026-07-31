package com.creationalPatterns.factory.example1;

public class Uygulama {
    public static void main(String[] args) {
        Bildirim bildirim1 = BildirimFactory.olustur("email");
        bildirim1.gonder("Siparişiniz onaylandı.");

        Bildirim bildirim2 = BildirimFactory.olustur("sms");
        bildirim2.gonder("Kargonuz yola çıktı.");

        Bildirim bildirim3 = BildirimFactory.olustur("push");
        bildirim3.gonder("Yeni bir mesajınız var.");
    }
}
