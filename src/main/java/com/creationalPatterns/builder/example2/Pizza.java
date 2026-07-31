package com.creationalPatterns.builder.example2;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final String boyut;
    private final String hamurTuru;
    private final String peynirMiktari;// opsiyonel
    private final List<String> malzemeler;
    private final boolean extraSos;

    private Pizza(Builder builder) {
        this.boyut = builder.boyut;
        this.hamurTuru = builder.hamurTuru;
        this.peynirMiktari = builder.peynirMiktari;
        this.malzemeler = builder.malzemeler;
        this.extraSos = builder.extraSos;
    }

    public void bilgiGoster() {
        System.out.println("Boyut: " + boyut
                + " | Hamur: " + hamurTuru
                + " | Peynir: " + peynirMiktari
                + " | Malzemeler: " + malzemeler
                + " | Ekstra Sos: " + (extraSos ? "Var" : "Yok"));
    }

    public static class Builder {
        private final String boyut;
        private final String hamurTuru;

        private String peynirMiktari = "Normal";// opsiyonel
        private List<String> malzemeler = new ArrayList<>();
        private boolean extraSos = false;

        public Builder(String boyut, String hamurTuru) {
            this.boyut = boyut;
            this.hamurTuru = hamurTuru;
        }

        public Builder peynirMiktari(String peynirMiktari) {
            this.peynirMiktari = peynirMiktari;
            return this;
        }

        public Builder malzemeEkle(String malzeme) {
            this.malzemeler.add(malzeme);
            return this;
        }

        public Builder extraSos(boolean extraSos) {
            this.extraSos = extraSos;
            return this;
        }

        public Pizza build() {
            if (boyut == null || boyut.isEmpty() || hamurTuru == null || hamurTuru.isEmpty()) {
                throw new IllegalArgumentException("Boyut ve hamur türü zorunludur!");
            }
            return new Pizza(this);
        }

    }

}


