package com.strucuralPatterns.adapter.example1;


public class MediaAdapter implements MediaPlayer {

    private GelismisMediaPlayer gelismisPlayer;

    public MediaAdapter(String dosyaTuru){
        if (dosyaTuru.equalsIgnoreCase("vlc")) {
            gelismisPlayer = new VlcPlayer();
        } else if (dosyaTuru.equalsIgnoreCase("mp4")) {
            gelismisPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String dosyaTuru, String dosyaAdi) {
        if (dosyaTuru.equalsIgnoreCase("vlc")) {
            gelismisPlayer.oynatVlc(dosyaAdi);
        } else if (dosyaTuru.equalsIgnoreCase("mp4")) {
            gelismisPlayer.oynatMp4(dosyaAdi);
        }
    }
}
