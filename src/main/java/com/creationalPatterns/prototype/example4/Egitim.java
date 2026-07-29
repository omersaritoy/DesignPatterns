package com.creationalPatterns.prototype.example4;

import java.util.ArrayList;
import java.util.List;

public class Egitim {

    String okul;
    String bolum;

    public Egitim(String okul, String bolum) {
        this.okul = okul;
        this.bolum = bolum;
    }


}

class CV implements Cloneable {
    String ad;
    Egitim egitim;
    List<String> yetenekler;

    public CV(String ad, Egitim egitim, List<String> yetenekler) {
        this.ad = ad;
        this.egitim = egitim;
        this.yetenekler = yetenekler;
    }

    public void bilgiGosteer() {
        System.out.println(ad + " - " + egitim.okul + " / " + egitim.bolum + " - Yetenekler: " + yetenekler);
    }


    @Override
    public CV clone() {
        try {
            CV clone = (CV) super.clone();
            clone.egitim = new Egitim(this.egitim.okul, this.egitim.bolum);
            clone.yetenekler = new ArrayList<>(this.yetenekler);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
