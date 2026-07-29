package com.creationalPatterns.prototype.example4;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Egitim egitim=new Egitim("ODTÜ","Bilgisayar Mühendisliği");

        CV cv1=new CV("Ali",egitim, List.of("JAVA", "SQL"));
        CV cv2= cv1.clone();
        cv2.ad="Veli";
        cv2.egitim.bolum="Yazılım Mühendislği";
        cv2.yetenekler.add("Python");

        cv1.bilgiGosteer();
        cv2.bilgiGosteer();

    }
}
