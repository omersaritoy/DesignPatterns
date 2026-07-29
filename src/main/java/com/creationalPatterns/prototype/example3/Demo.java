package com.creationalPatterns.prototype.example3;

public class Demo {
    public static void main(String[] args) {
        Address ortakAdres = new Address("İstanbul", "Bağdat Caddesi");
        Customer musteri1 = new Customer(ortakAdres, "Ahmet");

        Customer musteri2 = musteri1.clone();
        musteri2.name = "Mehmet"; // sadece ismi değiştirdik

        System.out.println("--- Klonlama sonrası (shallow copy) ---");
        musteri1.bilgiGoster();
        musteri2.bilgiGoster();

        System.out.println("\n--- musteri2'nin adresini değiştiriyoruz ---");
        musteri2.address.street = "Ankara"; // sadece musteri2'nin şehrini değiştirmek istiyoruz

        System.out.println("--- Değişiklik sonrası ---");
        musteri1.bilgiGoster();
        musteri2.bilgiGoster();


    }
}
