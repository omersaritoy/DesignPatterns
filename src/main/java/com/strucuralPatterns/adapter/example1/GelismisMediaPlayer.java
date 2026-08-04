package com.strucuralPatterns.adapter.example1;

//adaptee var olan uyumsuz sınıflar
//
public interface GelismisMediaPlayer {
    void oynatVlc(String dosyaAdi);
    void oynatMp4(String dosyaAdi);
}

class VlcPlayer implements GelismisMediaPlayer {
    @Override
    public void oynatVlc(String dosyaAdi) {
        System.out.println("VLC dosyası oynatılıyor: " + dosyaAdi);
    }

    @Override
    public void oynatMp4(String dosyaAdi) {
        // VLC player MP4 çalmaz, bu metod boş kalır
    }
}

class Mp4Player implements GelismisMediaPlayer {
    @Override
    public void oynatVlc(String dosyaAdi) {
        // MP4 player VLC çalmaz, bu metod boş kalır
    }

    @Override
    public void oynatMp4(String dosyaAdi) {
        System.out.println("MP4 dosyası oynatılıyor: " + dosyaAdi);
    }
}
