package com.creationalPatterns.factory.example2;

import com.creationalPatterns.factory.example1.Bildirim;
import com.creationalPatterns.factory.example1.BildirimFactory;

public class Uygulama {
    public static void main(String[] args) {
        Odeme odeme1 = OdemeFactory.olustur("kredikarti");
        odeme1.ode(150.5);

        Odeme odeme2 = OdemeFactory.olustur("havale");
        odeme2.ode(300);

        Odeme odeme3 = OdemeFactory.olustur("kripto");
        odeme3.ode(999.99);

        System.out.println("\n--- Geçersiz Tür Testi ---");
        try {
            Odeme odeme4 = OdemeFactory.olustur("bitcoin");
            odeme4.ode(100);
        } catch (IllegalArgumentException e) {
            System.out.println("Hata yakalandı: " + e.getMessage());
        }
    }
}
