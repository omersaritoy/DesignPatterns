package com.strucuralPatterns.adapter.example1;

public class AudioPlayer implements MediaPlayer {


    @Override
    public void play(String dosyaTuru, String dosyaAdi) {
        if (dosyaTuru.equalsIgnoreCase("mp3")) {
            System.out.println("MP3 dosyası oynatılıyor: " + dosyaAdi);
        } else if (dosyaTuru.equalsIgnoreCase("vlc") || dosyaTuru.equalsIgnoreCase("mp4")) {
            // Kendi bilmediği formatlar için Adapter'a devrediyor
            MediaAdapter adapter = new MediaAdapter(dosyaTuru);
            adapter.play(dosyaTuru, dosyaAdi);
        } else {
            System.out.println("Desteklenmeyen format: " + dosyaTuru);
        }

    }
}
