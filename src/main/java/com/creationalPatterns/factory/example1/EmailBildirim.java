package com.creationalPatterns.factory.example1;

public class EmailBildirim implements Bildirim{

    @Override
    public void gonder(String message) {
        System.out.println("[Email] Gönderiliyor: " + message);    }
}
class SmsBildirim implements Bildirim {
    @Override
    public void gonder(String mesaj) {
        System.out.println("[SMS] Gönderiliyor: " + mesaj);
    }
}
class PushBildirim implements Bildirim {
    @Override
    public void gonder(String mesaj) {
        System.out.println("[Push] Gönderiliyor: " + mesaj);
    }
}