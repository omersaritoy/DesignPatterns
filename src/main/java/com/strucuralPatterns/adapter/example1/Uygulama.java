package com.strucuralPatterns.adapter.example1;

public class Uygulama {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();

        player.play("mp3", "muzik.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "film.vlc");
        player.play("avi", "eskiVideo.avi");
    }
}
