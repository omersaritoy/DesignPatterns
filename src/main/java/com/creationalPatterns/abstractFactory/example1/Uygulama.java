package com.creationalPatterns.abstractFactory.example1;

public class Uygulama {
    // Bu metod, hangi fabrikayı aldığına bakmaksızın çalışır -> gevşek bağlılık
    static void odaDosemesiYap(MobilyaFactory factory) {
        Sandalye sandalye = factory.sandalyeOlustur();
        Masa masa = factory.masaOlustur();

        sandalye.oturmaBilgisi();
        masa.masaBilgisi();
    }
    public static void main(String[] args) {
        System.out.println("--- Modern Oda ---");
        MobilyaFactory modernFactory = new ModernMobilyaFactory();
        odaDosemesiYap(modernFactory);

        System.out.println("\n--- Klasik Oda ---");
        MobilyaFactory klasikFactory = new KlasikMobilyaFactory();
        odaDosemesiYap(klasikFactory);
    }
}
